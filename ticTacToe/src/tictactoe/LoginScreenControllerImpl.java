/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.AuthenticationConstants;
import utils.ErrorConstants;
import utils.UIHelper;

interface LoginScreenController {

    void onPressLoginBtn(String username, String password);

    void onPressSignupBtn(Stage stage);

    void onPressPressBackBtn(Stage stage);

    void setNetworkLayer();
}

public class LoginScreenControllerImpl implements LoginScreenController, NetworkUser {

    LoginScreenBase view;
    NetworkLayer networkLayer;

    public LoginScreenControllerImpl(LoginScreenBase view) {
        this.view = view;
    }

    @Override
    public void setNetworkLayer() {
        this.networkLayer = NetworkLayerImpl.getInstance(this);
    }

    @Override
    public void onPressLoginBtn(String username, String password) {
        validateInputs(username, password);
    }

    @Override
    public void onPressSignupBtn(Stage stage) {
        Navigation.navigateToSignUp(stage);
    }

    @Override
    public void onPressPressBackBtn(Stage stage) {
        Navigation.navigateToHome(stage);
    }

    private void validateInputs(String username, String password) {
        if (isNotEmpty(username, password)) {
            System.out.println(AuthenticationConstants.LOGIN.concat(";").concat(username).concat(";").concat(password));
            networkLayer.printStream(AuthenticationConstants.LOGIN.concat(";").concat(username).concat(";").concat(password));
        } else {
            UIHelper.showAlertMessage("You can't let fields empty!", "Error", Alert.AlertType.ERROR);
        }
    }

    private boolean isNotEmpty(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    @Override
    public void onErrorReceived(String errorMsg) {

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

    @Override
    public void onMsgReceived(String receivedMsg) {
        System.out.println("onMsgReceived" + receivedMsg);
        switch (receivedMsg) {
            case AuthenticationConstants.SUCCESS_LOGIN:
                Platform.runLater(() -> {
                    UIHelper.showAlertMessage("Congrats!", receivedMsg, Alert.AlertType.INFORMATION);
                });
                break;
            case AuthenticationConstants.ALEARDY_LOGINED_ON_ANOTHER_DEVICE:
                UIHelper.showAlertMessage("Ouhh!", receivedMsg, Alert.AlertType.ERROR);
                break;
            case AuthenticationConstants.WRONG_USERNAME_OR_PASSWORD:
                UIHelper.showAlertMessage("Ouhh!", receivedMsg, Alert.AlertType.ERROR);
                break;
            default:
                Logger.getLogger(LoginScreenControllerImpl.class.getName()).log(Level.SEVERE, receivedMsg);
        }
    }
}
