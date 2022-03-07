/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLocalMultiPlayersScreenWithAlert;

import MediaPlayer.VideoFXMLBase;
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
      public static PlayersNames getPlayersName(Stage myStage){
          PlayersNames names = new PlayersNames("Esraa","Nada");
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
            return names;
    }
}
