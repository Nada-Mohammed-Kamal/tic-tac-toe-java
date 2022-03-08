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
    
    public static Alert showWaitingAlertMessage() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Waiting");
        alert.setContentText("Waiting for player response...");

        alert.showAndWait();
        return alert;
    }
    
    public static void showDialogWithTwoOptions(Alert.AlertType type, String tilte, String contentText, String acceptBtnText, String rejectBtnText, Consumer<? super ButtonType> consumer){
        Alert alert = new Alert(type);

        alert.setTitle(tilte);
        alert.setContentText(contentText);

        ButtonType okButton = new ButtonType(acceptBtnText, ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType(rejectBtnText, ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(consumer);
    }
}
