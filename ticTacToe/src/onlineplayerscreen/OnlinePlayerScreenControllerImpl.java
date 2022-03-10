/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineplayerscreen;

import DisplayAlert.DisplayAlert;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.PlayerDto;
import tictactoe.Navigation;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.ErrorConstants;
import utils.ServerQueries;
import utils.UIHelper;

/**
 *
 * @author nados
 */
interface OnlinePlayerScreenController {

    void onBackButtonPressed(Stage stage);
    void requestGameFrom(String playerName);
}

public class OnlinePlayerScreenControllerImpl implements OnlinePlayerScreenController, NetworkUser {

    OnlinePlayerScreenInterface onlinePlayerScreenInterface;
    Stage stage;
    Stage mDialog=null;
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;
    Alert showWaitingAlertMessage;

    public OnlinePlayerScreenControllerImpl(OnlinePlayerScreenInterface onlinePlayerScreenInterface, Stage stage) {
        this.onlinePlayerScreenInterface = onlinePlayerScreenInterface;
        this.stage = stage;
        networkLayer = NetworkLayerImpl.getInstance(this);
        //networkLayer.printStream(ServerQueries.GET_ONLINE_USERS);
        onlinePlayerScreenInterface.displayUserData(networkLayer.getUsername(),
                networkLayer.getScore());
        
        
    }

    @Override
    public void onMsgReceived(String receivedMsg) {
        stringTokenizer = new StringTokenizer(receivedMsg, ";");
        String commandToExcute = stringTokenizer.nextToken();
        System.out.println(networkLayer.getUsername() + "       " + receivedMsg);
        switch (commandToExcute) {
            case ServerQueries.ONLINE_USERS:
                showOnlineUsers();
                break;
            case ServerQueries.PLAYER_IS_ALREADY_IN_GAME:
                cancelDialog("Request Cancelled", ServerQueries.PLAYER_IS_ALREADY_IN_GAME);
                break;
            case ServerQueries.PLAYER_IS_OFFLINE:
                cancelDialog("Request Cancelled", ServerQueries.PLAYER_IS_OFFLINE);
                break;
            case ServerQueries.PLAYER_IS_ALREADY_WAITING_FOR_ANOTHER_GAME:
                cancelDialog("Request Cancelled", ServerQueries.PLAYER_IS_ALREADY_WAITING_FOR_ANOTHER_GAME);
                break;
            case ServerQueries.GAME_REQUESTED_FROM://; sender request username    
                Platform.runLater(() -> {
                    recievedGameFrom();
                });
                break;
            case ServerQueries.ACCEPT_GAME:
                initializeGame(stringTokenizer.nextToken());
                break;
            case ServerQueries.REJECT_GAME:
                cancelDialog("Request Rejected", ServerQueries.REJECT_GAME);
                break;
            case ServerQueries.START_GAME:
                startGame();
                break;
        }
    }

    private void showOnlineUsers() {
        ArrayList<PlayerDto> players = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String[] player = stringTokenizer.nextToken().split("~");
            players.add(new PlayerDto(player[0], "", Integer.parseInt(player[1]), true));
        }
        players.remove(new PlayerDto(networkLayer.getUsername(), "", 0, true));
        onlinePlayerScreenInterface.updateOnlinePlayersList(players);
    }

    @Override
    public void onBackButtonPressed(Stage stage) {
        networkLayer.printStream(ServerQueries.CLOSE_NORMALLY);
        // networkLayer.closeConnection();
        Navigation.navigateToHome(stage);
    }

    @Override
    public void exitNetwork(String msg) {
        networkLayer = null;
        if (msg.equals(ErrorConstants.CLOSED_ABBNORMALLY)) {
            UIHelper.showAlertMessage("Error", ErrorConstants.SERVER_CLOSED, Alert.AlertType.WARNING);
        }
        Platform.runLater(() -> {
            Navigation.navigateToHome(stage);
        });
    }

    public void recievedGameFrom() {
        String senderRequestUsername = stringTokenizer.nextToken();
        String contentText = senderRequestUsername.concat(" wants to play a game with you, Accept?");
        
        boolean requestPlayGame = DisplayAlert.requestPlayGame(contentText);
        if (requestPlayGame) {
            System.out.println("OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK ");
            networkLayer.printStream(ServerQueries.ACCEPT_GAME.concat(";").concat(senderRequestUsername));
            mDialog = DisplayAlert.waitingAlertOnlineGame("Please wait until "+senderRequestUsername+" confirm.");
            mDialog.showAndWait();
        } else {
            System.out.println("NO NO NO NO NO NO NO NO NO NO NO NO NO NO NO NO ");
            networkLayer.printStream(ServerQueries.REJECT_GAME.concat(";").concat(senderRequestUsername));
        }

    }

    @Override
    public void requestGameFrom(String playerName) {
        networkLayer.printStream(ServerQueries.REQUEST_GAME.concat(";").concat(playerName));
        mDialog = DisplayAlert.waitingAlertOnlineGame("Please wait until " + playerName + " accept.");
        mDialog.showAndWait();
    }

    private void cancelDialog(String title, String msg) {
        mDialog.close();
        UIHelper.showAlertMessage(title, msg, Alert.AlertType.INFORMATION);
    }

    private void initializeGame(String acceptedUsername) {
        networkLayer.printStream(ServerQueries.START_GAME.concat(";").concat(acceptedUsername));
    }

    private void startGame() {
        if(mDialog!=null)
            mDialog.close();
        else
            System.out.println("OnlinePlayerScreenControllerImpl private void startGame() mDialog == null");
        Navigation.navigateToOnlineGame(stage, stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }
}
