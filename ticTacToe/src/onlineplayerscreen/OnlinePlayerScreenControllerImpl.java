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
import javafx.stage.Stage;
import model.PlayerDto;
import tictactoe.HomeScreen;
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
}

public class OnlinePlayerScreenControllerImpl implements OnlinePlayerScreenController, NetworkUser {

    OnlinePlayerScreenInterface onlinePlayerScreenInterface;
    Stage stage;
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;

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
        System.out.println(commandToExcute);
        switch (commandToExcute) {
            case ServerQueries.ONLINE_USERS:
                showOnlineUsers();
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
        if(msg.equals(ErrorConstants.CLOSED_ABBNORMALLY)){
                UIHelper.showAlertMessage(Constants.WARNING,ErrorConstants.SERVER_CLOSED, Alert.AlertType.WARNING);
        }
        Platform.runLater(()->{
            Navigation.navigateToHome(stage);
            });
    }

}
