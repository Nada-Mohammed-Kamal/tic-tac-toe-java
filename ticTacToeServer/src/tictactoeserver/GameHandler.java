/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import serverdao.PlayerManagerImpl;
import utils.AuthenticationConstants;

/**
 *
 * @author AhmedAli
 */
public class GameHandler extends Thread {
    InputStreamReader dis = null;
    PrintStream ps = null;
    Socket s;
    BufferedReader bufferReader;
    
    
    static Vector<GameHandler> onlinePlayers = new Vector<>();
    static Vector<GameHandler> allPlayers = new Vector<>();
    
    public GameHandler(Socket cs, Stage stage){
        try {
            this.s = cs;
            dis = new InputStreamReader(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            bufferReader = new BufferedReader(dis);
            //GameHandler.onlinePlayers.add(this);
            start();
        } catch (IOException ex) {
            closeStream();
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        handleClosingServer(stage);
    }
    
    PlayerManagerImpl playerMgr = new PlayerManagerImpl();
    @Override
    public void run() {
        while (true) {
            try {
                String msg = bufferReader.readLine();
                String[] recievedMsg = msg.split(";");
                System.out.println(msg);
                if (recievedMsg != null) {
                    if (recievedMsg[0] == null || recievedMsg[0].equals("closedNormally")) {
                        System.out.println("Client closed normally");
                        closeStream();
                    } else {
                        switch(recievedMsg[0]) {
                            case "signup":
                                registerNewPlayer(recievedMsg);
                                break;
                            case AuthenticationConstants.LOGIN:
                                playerLogin(recievedMsg);
                                break;
                            default:
                                //closeStream();
                        }
                    }
                }
//                sendMessageToAll(msg);
            } catch (SocketException ex) {
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
            dis.close();
            ps.close();
            s.close();
            onlinePlayers.remove(this);
            stop();
        } catch (IOException ex1) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }

    private void registerNewPlayer(String[] recievedMsg) {
        if(playerMgr.addNewPlayer(recievedMsg[1], recievedMsg[2], 0, false)) {
            ps.println("success"); 
        } else {
            ps.println("DB Error"); 
        }
    }
    
    
    private void playerLogin(String[] loginQuery){
        new Thread() {
            @Override
            public void run() {
                if(playerMgr.login(loginQuery[1], loginQuery[2])){
                    ps.println(AuthenticationConstants.SUCCESS_LOGIN);
                }else{
                    ps.println(AuthenticationConstants.WRONG_USERNAME_OR_PASSWORD);
                }
            }
        }.start();
    }

    private void handleClosingServer(Stage stage) {
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                closeStream();
                System.exit(0);
            }
        });
    }
}
