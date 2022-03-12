/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Esraa
 */
public class AlertHelper {

    public static boolean showDBConectionErrorAlert(String message){
            Stage window = new Stage();
            Parent root = new DBConnectionErrorDialog(window,message);
            Scene registerScene = new Scene(root);
            //get stage information
            window.initModality(Modality.APPLICATION_MODAL);
            window.setScene(registerScene);
            window.setMinHeight(600);
            window.setMinWidth(600);
            window.initStyle(StageStyle.UNDECORATED);
            window.setResizable(false);
            window.showAndWait();
//            Platform.runLater(() ->       
//            {
//               
//              
//            });
           
        if(DBConnectionErrorDialog.flag) 
            System.out.println("Accept *****");
        else  
            System.out.println("reject***********");
        return DBConnectionErrorDialog.flag;
                    
    }

}
