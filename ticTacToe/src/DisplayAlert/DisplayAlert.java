/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayAlert;

import GameLocalMultiPlayersScreenWithAlert.ShowAlertPlayLocalGame;
import OnlineGameAlert.OnlineGameAlert;
import PersonVSBootWithAlert.SinglePlayerAlert;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Esraa
 */
public class DisplayAlert {
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
                System.out.print("Hi");
                
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
                System.out.print("Hi");
                
            });
    }
    public static boolean requestPlayGame(String message){
            Stage window = new Stage();
            Parent root = new OnlineGameAlert(window,message);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(600);
            window.setMinWidth(600);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.showAndWait();
            Platform.runLater(() ->       
            {
               
              
            });
           
           if(OnlineGameAlert.flag) System.out.println("Accept *****");
               else  System.out.println("reject***********");
        return OnlineGameAlert.flag;
                    
    }
}
