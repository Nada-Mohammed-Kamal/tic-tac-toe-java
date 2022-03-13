    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayAlert;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

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
            window.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    window.setX(((myStage.getWidth()-400)/2) + myStage.getX());
                    window.setY(((myStage.getHeight()-100)/2) + myStage.getY());

                }
            });
            window.showAndWait();
    }
    public static void getPlayerNameOnOnePlayer(Stage myStage,String whichLevel){
            Stage window = new Stage();
            Parent root = new SinglePlayerAlert(myStage,window,whichLevel);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(400);
            window.setMinWidth(400);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    window.setX(((myStage.getWidth()-200)/2) + myStage.getX());
                    window.setY(((myStage.getHeight()-100)/2) + myStage.getY());

                }
            });
            window.showAndWait();
            Platform.runLater(() ->       
            {
                System.out.print("Hi");
                
            });
    }
    public static boolean confirmationDialog(Stage myStage,String message,String leftButtonText,String rightButtonText){
            Stage window = new Stage();
            Parent root = new OnlineGameAlert(window,message,leftButtonText,rightButtonText);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(600);
            window.setMinWidth(600);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    window.setX(((myStage.getWidth()-200)/2) + myStage.getX());
                    window.setY(((myStage.getHeight()-100)/2) + myStage.getY());

                }
            });
            window.showAndWait();
        return OnlineGameAlert.flag;
                    
    }
    public static Stage waitingAlertOnlineGame(String message,Stage myStage){
            Stage window = new Stage();
            Parent root = new WaitingAlertOnlineGame(message);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(600);
            window.setMinWidth(600);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    window.setX(((myStage.getWidth()-200)/2) + myStage.getX());
                    window.setY(((myStage.getHeight()-100)/2) + myStage.getY());

                }
            });
        return window;
                    
    }
    public static void informationAlert(String message,Stage myStage){
            Stage window = new Stage();
            Parent root = new InformationAlert(window,message);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(600);
            window.setMinWidth(600);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.addEventHandler(WindowEvent.WINDOW_SHOWN, new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    window.setX(((myStage.getWidth()-200)/2) + myStage.getX());
                    window.setY(((myStage.getHeight()-100)/2) + myStage.getY());

                }
            });
            window.showAndWait();          
    }
}
