/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.signup;

import DisplayAlert.DisplayAlert;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Navigation.Navigation;
import javafx.application.Platform;
import tictactoe.network.NetworkLayer;
import tictactoe.network.NetworkLayerImpl;
import tictactoe.network.NetworkUser;
import utils.AuthenticationConstants;
import utils.Constants;
import utils.ErrorConstants;
import utils.ServerQueries;
import utils.UIHelper;

/**
 *
 * @author AhmedAli
 */
interface SignupScreenController {

    void onPressSignupBtn(String username, String password, String password2);

    void onPressLoginBtn(Stage stage);

    void onPressBackBtn(Stage stage);

    void setNetworkLayer();
    
    void closeWindow();
}

public class SignUpScreenControllerImpl implements SignupScreenController, NetworkUser {

    NetworkLayer networkLayer;
    Stage stage;
    

    public SignUpScreenControllerImpl(Stage stage) {
       this.stage = stage;
    }

    @Override
    public void onPressBackBtn(Stage stage) {
        if (networkLayer != null) {
            networkLayer.printStream(ServerQueries.CLOSE_NORMALLY);
        }
        Navigation.navigateToHome(stage);
    }
    @Override
    public void closeWindow() {
        if (networkLayer != null) {
            networkLayer.printStream(ServerQueries.CLOSE_NORMALLY);
            networkLayer.closeConnection("closing window...");
        }
        System.exit(0);
    }
    

    @Override
    public void setNetworkLayer() {
        this.networkLayer = NetworkLayerImpl.getInstance(this);
    }

    @Override
    public void onMsgReceived(String receivedMsg) {
        switch(receivedMsg){
            case AuthenticationConstants.SUCCESS_REGISTERED:
                UIHelper.showAlertMessage("Congrats!", "Successfully registered!", Alert.AlertType.INFORMATION);
                break;
            case AuthenticationConstants.REGISTER_FAILED_ALREADY_REGISTERED:
                 UIHelper.showAlertMessage("Alery!", AuthenticationConstants.REGISTER_FAILED_ALREADY_REGISTERED, Alert.AlertType.WARNING);
                break;
            case AuthenticationConstants.PROBLEM_IN_SERVER:
                UIHelper.showAlertMessage("Alery!", AuthenticationConstants.REGISTER_FAILED_ALREADY_REGISTERED, Alert.AlertType.WARNING);
                break;
            default:
                Logger.getLogger(SignUpScreenControllerImpl.class.getName()).log(Level.SEVERE, receivedMsg);
        }
    }

    @Override
    public void onPressSignupBtn(String username, String password, String password2) {
        if(isValidUserData(username, password, password2)){
            networkLayer.printStream(ServerQueries.SIGN_UP.concat(";").concat(username).concat(";").concat(password));
        }
    }

    @Override
    public void onPressLoginBtn(Stage stage) {
        Navigation.navigateToLogin(stage);
    }



    private boolean isValidUserData(String username, String password, String password2) {
        boolean isValidData = true;
        if (username.trim().isEmpty()) {
            UIHelper.showAlertMessage(Constants.WARNING, "Name is Empty!\nPlease, type your name.", Alert.AlertType.WARNING);
            isValidData = false;
        } else if (password.trim().isEmpty()) {
            UIHelper.showAlertMessage(Constants.WARNING, "Password is Empty!\nPlease, type your password.", Alert.AlertType.WARNING);
            isValidData = false;
        } else if (password2.trim().isEmpty()) {
            UIHelper.showAlertMessage(Constants.WARNING, "Re-Password is Empty!\nPlease, confirm your password.", Alert.AlertType.WARNING);
            isValidData = false;
        } else if (!password.trim().equals(password2.trim())) {
            UIHelper.showAlertMessage(Constants.WARNING, "Password and Re-Password isn't the same!\nPlease, type your password and Confirm password correct.", Alert.AlertType.WARNING);
            isValidData = false;
        }

        return isValidData;
    }
    
    @Override
    public void exitNetwork(String msg) {
        networkLayer = null;
        if (msg.equals(ErrorConstants.CLOSED_ABBNORMALLY)) {
            DisplayAlert.informationAlert(ErrorConstants.SERVER_CLOSED, stage);
        }
        Platform.runLater(() -> {
            Navigation.navigateToHome(stage);
        });
    }

}
