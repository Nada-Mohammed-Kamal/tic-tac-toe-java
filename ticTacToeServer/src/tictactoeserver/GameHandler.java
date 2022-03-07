/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import model.Game;
import model.PlayerDto;
import serverdao.ConnectionDB;
import serverdao.PlayerManager;
import serverdao.PlayerManagerImpl;
import utils.AuthenticationConstants;
import utils.ErrorConstants;
import utils.PlayerStatusValues;
import utils.ResultConstants;
import utils.ServerQueries;

/**
 *
 * @author AhmedAli
 */
public class GameHandler extends Thread {

    InputStreamReader dis = null;
    PrintStream ps = null;
    Socket s;
    BufferedReader bufferReader;
    StringTokenizer stringTokenizer;
    PlayerManager playerMgr = PlayerManagerImpl.getInstance(ConnectionDB.getInstance());
    PlayerDto currentPlayer;
    static Map<String, PlayerDto> sessions = Collections.synchronizedMap(new HashMap());
    static Vector<Game> currentGames = new Vector<>();
    boolean flag = true;
    
    private String id = UUID.randomUUID().toString();
    private static Vector<GameHandler> inActiveSession = new Vector<>();

    public GameHandler(Socket cs, Stage stage) {
        try {
            this.s = cs;
            dis = new InputStreamReader(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            bufferReader = new BufferedReader(dis);
            GameHandler.inActiveSession.add(this);
            start();
        } catch (IOException ex) {
            closeStream();
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        handleClosingServer(stage);
    }

    @Override
    public void run() {
        while (flag) {
            try {
                String msg = bufferReader.readLine();
                if (msg != null) {
                    System.out.println(msg);
                    checkCommand(msg);
                }
//                sendMessageToAll(msg);
            } catch (SocketException ex) {
                flag = false;
                closeStream();

                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    void sendMessageToAll(String msg){
//        for(int i=0; i<clientsVector.size(); i++) {
//           clientsVector.get(i).ps.println(msg);
//        }
//    }
    private void closeStream() {
        try {
            ps.println(ServerQueries.CLOSE_NORMALLY);
            flag = false;
            dis.close();
            ps.close();
            bufferReader.close();
            s.close();
            //currentGames.remove(this);
            stop();
        } catch (IOException ex1) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex1);
        }
    } 

    private void registerNewPlayer(String username, String password) {
        new Thread() {
            @Override
            public void run() {
                int result = playerMgr.addNewPlayer(username, password, 0, false);
                switch (result) {
                    case ResultConstants.SUCCESSFULLY_REGISTERED:
                        ps.println(AuthenticationConstants.SUCCESS_REGISTERED);
                        break;
                    case ResultConstants.ALREADY_REGISTERED:
                        ps.println(AuthenticationConstants.REGISTER_FAILED_ALREADY_REGISTERED);
                        break;
                    case ResultConstants.DB_ERROR:
                        ps.println(AuthenticationConstants.PROBLEM_IN_SERVER);
                        break;
                    default:
                        System.out.println("ERORR UNKOWN VALUE == " + result);
                }
            }

        }.start();

    }

    private void playerLogin(String username, String password) {
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);
        new Thread() {
            @Override
            public void run() {
                Integer scoreRefrence = 0;
                switch (playerMgr.login(username, password, scoreRefrence)) {
                    case ResultConstants.SUCCESSFULLY_LOGGINED:
                        currentPlayer = new PlayerDto(username, "", scoreRefrence, true , GameHandler.this);
                        ps.println(AuthenticationConstants.SUCCESS_LOGIN.concat(";").concat(username).concat(";").concat(String.valueOf(scoreRefrence)));
                        sessions.put(username, currentPlayer);
                        GameHandler.inActiveSession.remove(GameHandler.this);
                        break;
                    case ResultConstants.WRONG_USERNAME_OR_PASSWORD:
                        ps.println(AuthenticationConstants.WRONG_USERNAME_OR_PASSWORD);
                        break;
                    case ResultConstants.ALREADY_LOGGINED:
                        ps.println(AuthenticationConstants.ALREADY_LOGINED_ON_ANOTHER_DEVICE);
                        break;
                    case ResultConstants.DB_ERROR:
                        ps.println(AuthenticationConstants.PROBLEM_IN_SERVER);
                        break;
                    default:
                        System.out.println("ERROR: Unknown message");
                }
            }
        }.start();
    }

    private void handleClosingServer(Stage stage) {
        stage.setOnCloseRequest((event) -> {
            closeStream();
            System.exit(0);
        });
    }

    private void closeNormally(String username) {
        playerMgr.logOut(username);
    }

    private void checkCommand(String msg) {
        stringTokenizer = new StringTokenizer(msg, ";");
        String commandToExcute = stringTokenizer.nextToken();
        System.out.println(commandToExcute);

        switch (commandToExcute) {
            case ServerQueries.CLOSE_NORMALLY:
                System.out.println("Client " + ServerQueries.CLOSE_NORMALLY);
                playerMgr.logOut(currentPlayer.getUsername());
                ps.println(ServerQueries.CLOSE_NORMALLY);
                closeStream();
                break;
            case ServerQueries.SIGN_UP:
                registerNewPlayer(stringTokenizer.nextToken(), stringTokenizer.nextToken());
                break;
            case ServerQueries.LOGIN:
                playerLogin(stringTokenizer.nextToken(), stringTokenizer.nextToken());
                break;
            case ServerQueries.GET_ONLINE_USERS:
                getOnlineUsers();
                break;
            case ServerQueries.REQUEST_GAME:
                handleRequest();
                break;   
            default:
                System.out.println("UNEXPECTED ERROR MSG: " + msg);
        }
    }

    private void getOnlineUsers() {
        List<PlayerDto> onlinePlayers = playerMgr.getOnlinePlayersWithScores();
        //remove my name from the online list in order not to send to himself a request  
        System.out.println(currentPlayer.getUsername());
        onlinePlayers.remove(currentPlayer);
        System.out.println(onlinePlayers);
        for(Game game : currentGames){
            onlinePlayers.remove(game.getPlayer1());
            onlinePlayers.remove(game.getPlayer2());
        }
        StringBuilder onlinePlayersString = new StringBuilder("");
        onlinePlayers.forEach((user) -> {
            onlinePlayersString.append(";").append(user.getUsername()).append("~").append(user.getScore());
        });
        //replace the string builder with string if failed
        ps.println(onlinePlayersString.insert(0,ServerQueries.ONLINE_USERS));
    }
    //nexr Token has reciever user name
    private void handleRequest() {
        //case reciver is in game ==> return user busy
        //case user is offline
        //case idle user online
        String recieverUserName = stringTokenizer.nextToken();
        PlayerDto player = playerMgr.getPlayer(recieverUserName);
        if(player.isIsOnline()){
           switch(player.getStatus()){
                case PlayerStatusValues.IDLE:
                    sendRequestToPlayer(recieverUserName);
                    break;
                case PlayerStatusValues.IN_GAME:
                    ps.println(ServerQueries.PLAYER_IS_ALREADY_IN_GAME);
                    break;
                case PlayerStatusValues.WAITING:
                    ps.println(ServerQueries.PLAYER_IS_ALREADY_WAITING_FOR_ANOTHER_GAME);
                    break;
            } 
        }else{
        
        }
    }
    
    public static void sendMsgToAllUsers(String msg) {
        
    }
    
    public static void onClosingServer() {
        new Thread(() -> {
            PlayerManagerImpl.getInstance(ConnectionDB.getInstance()).updateSetPlayerOffline();
            PlayerManagerImpl.getInstance(ConnectionDB.getInstance()).updateSetPlayerStatusZero();
            PlayerManagerImpl.getInstance(ConnectionDB.getInstance()).updateServerStatistics();
            closeAllResourses();
            
        }).start();
//        sendMsgToAllUsers(msg);
    }
    
    public static void closeAllResourses() {
        for(Map.Entry<String, PlayerDto> session : sessions.entrySet()) {
            System.out.println("session"+session);
            session.getValue().getHandler().closeStream();
        }
        sessions.clear();
        for(GameHandler game : GameHandler.inActiveSession) {
            System.out.println("Game   "+game);
            game.closeStream();
        }
        inActiveSession.clear();
        
        // close DB
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean returnValue = false;
        if (obj instanceof GameHandler && id.equals(((GameHandler) obj).id)) {
            returnValue = true;
        }
        
        return returnValue;
    }

    private void sendRequestToPlayer(String recieverUserName) {
        sessions
                .get(recieverUserName)
                .getHandler()
                .ps
                .println(ServerQueries
                        .REQUEST_GAME_FROM
                        .concat(currentPlayer
                                .getUsername()));
    }
}
