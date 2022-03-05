/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import MediaPlayer.VideoFXMLBase;
import javafx.animation.PauseTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Esraa
 */
public class PlayVideo {
    //winner .. loser .. draw
    public static void displayVideo(String playerWinnerOrNot,String WinnerName){
            Parent root = new VideoFXMLBase(playerWinnerOrNot,WinnerName);
            Scene registerScene = new Scene(root);
            //get stage information
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(400);
            window.setMinWidth(400);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.show();
            
                PauseTransition wait = new PauseTransition(Duration.seconds(5));
                wait.setOnFinished((e) -> {
                    window.close();
                     VideoFXMLBase.mp.stop();
                    wait.playFromStart();
                });
                wait.play();
                            
                window.setOnCloseRequest((event) -> {
                    System.out.println("closing vid");
                    VideoFXMLBase.mp.stop();
                });
    }
}
