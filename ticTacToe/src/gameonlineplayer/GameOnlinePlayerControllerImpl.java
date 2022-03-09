/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlineplayer;

import java.util.StringTokenizer;
import java.util.Vector;
import javafx.stage.Stage;
import tictactoe.Navigation;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.Role;

/**
 *
 * @author AhmedAli
 */
interface GameOnlinePlayerController {

    void onBackButtonPressed(Stage stage);
    void onTakeStep(String step, String btnText);
}

public class GameOnlinePlayerControllerImpl implements GameOnlinePlayerController, NetworkUser {

    OnlinePlayerScreenInterface onlinePlayerScreenInterface;
    Stage stage;
    Stage mDialog = null;
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;
    Vector<Integer> playerMoves;
    String myRole = "";
    
    public GameOnlinePlayerControllerImpl(OnlinePlayerScreenInterface onlinePlayerScreenInterface, Stage stage, String secondPlayerName, String secondPlayerRole) {
        this.onlinePlayerScreenInterface = onlinePlayerScreenInterface;
        this.stage = stage;
        networkLayer = NetworkLayerImpl.getInstance(this);
        myRole = secondPlayerRole.equals(Role.X) ? Role.O : Role.X;
        onlinePlayerScreenInterface.displayPlayersData(networkLayer.getUsername(), myRole, secondPlayerName, secondPlayerRole);
        
        playerMoves = new Vector<>();
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

    @Override
    public void onTakeStep(String step, String btnText) {
        if (isValidStep(btnText)) {
            //NetworkUser
        }
    }
    
    // x == 0
    // o == 1
    private boolean isMyTurnToPlay() {
        return (myRole.equals(Role.X) && playerMoves.size() % 2 == 0) || (myRole.equals(Role.O) && playerMoves.size() % 2 != 0);
    }
    
    private boolean isValidStep(String btnText){
        return isMyTurnToPlay() && btnText.isEmpty();
    }
}
