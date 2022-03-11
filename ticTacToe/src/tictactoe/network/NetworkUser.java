/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.network;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import tictactoe.login.LoginScreenControllerImpl;
import utils.ErrorConstants;
import utils.UIHelper;

/**
 *
 * @author abdelwahabzayed
 */
public interface NetworkUser {
    
     void exitNetwork(String msg);
    
    default  void onErrorReceived(String errorMsg){
        System.out.println("onErrorReceived" + errorMsg);
        switch (errorMsg) {
            case ErrorConstants.COULD_NOT_CONNECT_TO_SERVER:
                UIHelper.showAlertMessage("Ouhh!", errorMsg, Alert.AlertType.ERROR);
                break;
            case ErrorConstants.COULD_NOT_RECEIVE_MSG_FROM_SERVER:
                UIHelper.showAlertMessage("Ouhh!", errorMsg, Alert.AlertType.ERROR);
                break;
            case ErrorConstants.PROBLEM_WHILE_CLOSING_CONNECTION:
                UIHelper.showAlertMessage("Ouhh!", errorMsg, Alert.AlertType.ERROR);
                break;
            default:
                Logger.getLogger(LoginScreenControllerImpl.class.getName()).log(Level.SEVERE, errorMsg);
        }
    }
    void onMsgReceived(String receivedMsg);
    
}
