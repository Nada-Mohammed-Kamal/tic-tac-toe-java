/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 *
 * @author abdelwahabzayed
 */
public class UIHelper {

    public static void showAlertMessage(String header, String msg, Alert.AlertType type) {
        Platform.runLater(() -> {
            Alert a = new Alert(type);
            a.setHeaderText(header);
            a.setContentText(msg);
            a.show();
        });
    }
    public static  void  showDialogWithTwoOptions(Consumer<? super ButtonType> consumer){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Current project is modified");

        alert.setContentText("Save?");

        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);

        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(okButton, noButton);

        alert.showAndWait().ifPresent(consumer);
    }
}
