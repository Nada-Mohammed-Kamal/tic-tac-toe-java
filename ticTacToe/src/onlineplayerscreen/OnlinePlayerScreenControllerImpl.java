/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineplayerscreen;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.PlayerDto;
import tictactoe.Navigation;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.Constants;
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
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;
    Alert showWaitingAlertMessage;

    public OnlinePlayerScreenControllerImpl(OnlinePlayerScreenInterface onlinePlayerScreenInterface, Stage stage) {
        this.onlinePlayerScreenInterface = onlinePlayerScreenInterface;
        this.stage = stage;
        networkLayer = NetworkLayerImpl.getInstance(this);
        networkLayer.printStream(ServerQueries.GET_ONLINE_USERS);
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
        players.remove(new PlayerDto(networkLayer.getUsername(), "", 0, true));
        while (stringTokenizer.hasMoreTokens()) {
            String[] player = stringTokenizer.nextToken().split("~");
            players.add(new PlayerDto(player[0], "", Integer.parseInt(player[1]), true));
        }
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
            UIHelper.showAlertMessage(Constants.WARNING, ErrorConstants.SERVER_CLOSED, Alert.AlertType.WARNING);
        }
        Platform.runLater(() -> {
            Navigation.navigateToHome(stage);
        });
    }

    public void recievedGameFrom() {
        String senderRequestUsername = stringTokenizer.nextToken();
        String contentText = senderRequestUsername.concat(" wants to play a game with you, Accept?");
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, contentText, ButtonType.YES, ButtonType.NO);
        alert.setTitle("Game Request");
        alert.setContentText(contentText);
        
        ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
        if (ButtonType.NO.equals(result)) {
            System.out.println("NO NO NO NO NO NO NO NO NO NO NO NO NO NO NO NO ");
            networkLayer.printStream(ServerQueries.REJECT_GAME.concat(";").concat(senderRequestUsername));
        } else {
            System.out.println("OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK ");
            networkLayer.printStream(ServerQueries.ACCEPT_GAME.concat(";").concat(senderRequestUsername));
            showWaitingAlertMessage = UIHelper.showWaitingAlertMessage();
            showWaitingAlertMessage.show();
        }
    }

    @Override
    public void requestGameFrom(String playerName) {
        showWaitingAlertMessage = UIHelper.showWaitingAlertMessage();
        showWaitingAlertMessage.show();
        networkLayer.printStream(ServerQueries.REQUEST_GAME.concat(";").concat(playerName));
    }

    private void cancelDialog(String title, String msg) {
        showWaitingAlertMessage.close();
        UIHelper.showAlertMessage(title, msg, Alert.AlertType.INFORMATION);
    }

    private void initializeGame(String acceptedUsername) {
        networkLayer.printStream(ServerQueries.START_GAME.concat(";").concat(acceptedUsername));
    }

    private void startGame() {
        showWaitingAlertMessage.close();
        Navigation.navigateToOnlineGame(stage);
    }
}
