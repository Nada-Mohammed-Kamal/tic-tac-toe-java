/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPlayer;

import MediaPlayer.VideoFXMLBase;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 *
 * @author Esraa
 */
public class PlayVideo {
    //winner .. loser .. draw
    public static void displayVideo(String playerWinnerOrNot,String WinnerName,Stage myStage){
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
            window.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    window.setX(((myStage.getWidth()-300)/2) + myStage.getX());
                    window.setY( 100+ myStage.getY());

                }
            });
            window.show();
            
                PauseTransition wait = new PauseTransition(Duration.seconds(7));
                wait.setOnFinished((e) -> {
                    VideoFXMLBase.mp.stop();
                    window.close();
                });
                wait.play();
                            
                window.setOnCloseRequest((event) -> {
                    System.out.println("closing vid");
                    VideoFXMLBase.mp.stop();
                });
    }
}
