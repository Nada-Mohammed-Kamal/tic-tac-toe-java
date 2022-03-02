/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javafx.application.Platform;
import javafx.scene.control.Alert;

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
}
