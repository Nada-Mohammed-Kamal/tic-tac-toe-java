/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlineplayer;

import DisplayAlert.DisplayAlert;
import java.util.StringTokenizer;
import java.util.Vector;
import javafx.stage.Stage;
import tictactoe.Navigation;
import MediaPlayer.PlayVideo;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.Role;
import utils.ServerQueries;

/**
 *
 * @author AhmedAli
 */
interface GameOnlinePlayerController {

    void onBackButtonPressed(Stage stage);
    void onTakeStep(String step, String btnText);
    Vector<Integer> getPlayerMoves();
    void playAgianButtonPressed();
}

public class GameOnlinePlayerControllerImpl implements GameOnlinePlayerController, NetworkUser {

    GameOnlinePlayersScreenInterface gameOnlinePlayersScreenInterface;
    Stage stage;
    Stage mDialog = null;
    NetworkLayer networkLayer;
    private StringTokenizer stringTokenizer;
    Vector<Integer> playerMoves;
    String myRole = "", playerXScore, playerOScore;
    
    public GameOnlinePlayerControllerImpl(GameOnlinePlayersScreenInterface gameOnlinePlayersScreenInterface, Stage stage, String secondPlayerName, String secondPlayerRole) {
        this.gameOnlinePlayersScreenInterface = gameOnlinePlayersScreenInterface;
        this.stage = stage;
        networkLayer = NetworkLayerImpl.getInstance(this);
        myRole = secondPlayerRole.equals(Role.X) ? Role.O : Role.X;
        gameOnlinePlayersScreenInterface.displayPlayersData(networkLayer.getUsername(), myRole, secondPlayerName, secondPlayerRole);
        
        playerMoves = new Vector<>();
    }
    
    @Override
    public void onBackButtonPressed(Stage stage) {
        boolean requestExitGame = DisplayAlert.confirmationDialog(stage,"Are you sure?","OK","Cancel");
        if (requestExitGame) {
             networkLayer.printStream(ServerQueries.QUIT_GAME);
        } 
  
    }

    
    @Override
    public void exitNetwork(String msg) {
        
    }

    @Override
    public void onMsgReceived(String receivedMsg) {
        stringTokenizer = new StringTokenizer(receivedMsg, ";");
        String commandToExcute = stringTokenizer.nextToken();
        System.out.println(commandToExcute);
        System.out.println(networkLayer.getUsername() + "       " + receivedMsg);
        switch(commandToExcute){
            case ServerQueries.TRANSACTION:
                handleTransaction();
                break;
            case ServerQueries.X_WIN:
                if(myRole.equals(Role.X)){
                    handleWin();
                }
                else {
                    handleLoose();
                }
                playerXScore = stringTokenizer.nextToken();
                playerOScore = stringTokenizer.nextToken();
                gameOnlinePlayersScreenInterface.updatePlayersScores(playerXScore, playerOScore);
                break;
            case ServerQueries.O_WIN:
                if(myRole.equals(Role.O)) {
                    handleWin();
                }
                else {
                    handleLoose();
                }
                playerXScore = stringTokenizer.nextToken();
                playerOScore = stringTokenizer.nextToken();
                gameOnlinePlayersScreenInterface.updatePlayersScores(playerXScore, playerOScore);
                break;
            case ServerQueries.TIE:
                handleTie();
                break;
            case ServerQueries.PLAY_AGAIN:
                gameOnlinePlayersScreenInterface.startPlayAgain();
                break;
            case ServerQueries.QUIT_GAME:
                if(stringTokenizer.nextToken().equals(networkLayer.getUsername())) {
                    if (playerXScore != null && !playerXScore.isEmpty()) {
                        networkLayer.setScore(networkLayer.getScore() + Integer.parseInt(playerXScore));
                    }
                    Navigation.navigateToOnlinePlayersScreen(stage);
                }
                else {
                    //show warnig alert that the other player left and when ok pressed navigate
                    if (playerOScore != null && !playerOScore.isEmpty()) {
                        networkLayer.setScore(networkLayer.getScore() + Integer.parseInt(playerOScore));
                    }
                    
                    Navigation.navigateToOnlinePlayersScreen(stage);
                    DisplayAlert.informationAlert("The Second Player Left", stage);
                }
                break;
        }
    }

    @Override
    public void onTakeStep(String step, String btnText) {
        if (isValidStep(btnText)) {
            networkLayer.printStream(ServerQueries.TRANSACTION.concat(";").concat(step).concat(";").concat(myRole));
        }
    }
    
    // x == 0
    // o == 1
    private boolean isMyTurnToPlay() {
        System.out.println(networkLayer.getUsername()+"     "+myRole+"            "+playerMoves.size());
        return ((myRole.equals(Role.X) && playerMoves.size() % 2 == 0) || (myRole.equals(Role.O) && playerMoves.size() % 2 != 0));
    }
    
    private boolean isValidStep(String btnText){
        return isMyTurnToPlay() && btnText.isEmpty();
    }

    private void handleTransaction() {
        String step = stringTokenizer.nextToken();
        String role = stringTokenizer.nextToken();
        playerMoves.add(Integer.parseInt(step));
        gameOnlinePlayersScreenInterface.displayStepOnBtn(role, step);
    }

    private void handleWin() {
        handleTransaction();
        gameOnlinePlayersScreenInterface.hideAllXOButtonWhenGameFinished();
        PlayVideo.displayVideo("winner","",stage);
        //
        gameOnlinePlayersScreenInterface.setGameResultId("You win");
        System.out.println("handleWin");
    }

    private void handleLoose() {
        handleTransaction();
        gameOnlinePlayersScreenInterface.hideAllXOButtonWhenGameFinished();
        PlayVideo.displayVideo("loser","",stage);
        //
        gameOnlinePlayersScreenInterface.setGameResultId("You lost");
        System.out.println("handleLoose");
    }

    private void handleTie() {
        handleTransaction();
        gameOnlinePlayersScreenInterface.hideAllXOButtonWhenGameFinished();
        PlayVideo.displayVideo("draw","",stage);
        gameOnlinePlayersScreenInterface.setGameResultId("It's a tie");
        System.out.println("handleTie");
    }

    @Override
    public Vector<Integer> getPlayerMoves() {
        return playerMoves;
    }
    @Override
    public void playAgianButtonPressed() {
        networkLayer.printStream(ServerQueries.PLAY_AGAIN);
    }
}
