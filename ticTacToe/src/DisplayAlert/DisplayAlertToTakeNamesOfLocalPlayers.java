/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayAlert;

import GameLocalMultiPlayersScreenWithAlert.ShowAlertPlayLocalGame;
import MediaPlayer.VideoFXMLBase;
import PersonVSBootWithAlert.SinglePlayerAlert;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.util.Pair;

/**
 *
 * @author Esraa
 */
public class DisplayAlertToTakeNamesOfLocalPlayers {
      public static void getPlayersName(Stage myStage){
            Stage window = new Stage();
            Parent root = new ShowAlertPlayLocalGame(myStage,window);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(400);
            window.setMinWidth(400);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.showAndWait();
            Platform.runLater(() ->       
            {
                
                
            });
    }
       public static void getPlayerNameOnOnePlayer(Stage myStage){
            Stage window = new Stage();
            Parent root = new SinglePlayerAlert(myStage,window);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(400);
            window.setMinWidth(400);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.showAndWait();
            Platform.runLater(() ->       
            {
                
                
            });
    }
}
