/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlineplayer;

import java.util.StringTokenizer;
import javafx.stage.Stage;
import tictactoe.Navigation;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;

/**
 *
 * @author AhmedAli
 */
interface GameOnlinePlayerController {

    void onBackButtonPressed(Stage stage);
}

public class GameOnlinePlayerControllerImpl implements GameOnlinePlayerController, NetworkUser {

    GameOnlinePlayerController gameOnlinePlayerController;
    Stage stage;
    Stage mDialog = null;
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;
    
    public GameOnlinePlayerControllerImpl(OnlinePlayerScreenInterface onlinePlayerScreenInterface, Stage stage) {
        this.gameOnlinePlayerController = gameOnlinePlayerController;
        this.stage = stage;
        networkLayer = NetworkLayerImpl.getInstance(this);
    }
    
    @Override
    public void onBackButtonPressed(Stage stage) {
        // show confirmation dialog
        Navigation.navigateToOnlinePlayersScreen(stage);
    }

    @Override
    public void exitNetwork(String msg) {
        
    }

    @Override
    public void onMsgReceived(String receivedMsg) {
        
    }
}
