/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.login;

import DisplayAlert.DisplayAlert;
import java.util.StringTokenizer;
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

interface LoginScreenController {

    void onPressLoginBtn(String username, String password , Stage stage);

    void onPressSignupBtn(Stage stage);

    void onPressPressBackBtn(Stage stage);

    void setNetworkLayer();
    
    void closeWindow();
}

public class LoginScreenControllerImpl implements LoginScreenController, NetworkUser {

    NetworkLayer networkLayer;
    Stage stage;
    private StringTokenizer stringTokenizer;
    
    public LoginScreenControllerImpl(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void setNetworkLayer() {
        new Thread(()->{
            LoginScreenControllerImpl.this.networkLayer = NetworkLayerImpl.getInstance(LoginScreenControllerImpl.this);
        }).start();
        
    }

    @Override
    public void onPressLoginBtn(String username, String password, Stage stage) {
        validateInputs(username, password, stage);
    }

    @Override
    public void onPressSignupBtn(Stage stage) {
        if(networkLayer != null && networkLayer.isConnectedToServer())
            Navigation.navigateToSignUp(stage);  
    }

    @Override
    public void onPressPressBackBtn(Stage stage) {
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
    
    private void validateInputs(String username, String password, Stage stage) {
        if(networkLayer !=null)
            if (isNotEmpty(username, password)) {
                
                System.out.println(ServerQueries.LOGIN.concat(";").concat(username).concat(";").concat(password.replace(";", "@")));
                networkLayer.printStream(ServerQueries.LOGIN.concat(";").concat(username).concat(";").concat(password.replace(";", "@")));
                this.stage = stage;
            }else if(username.contains(";")){
                UIHelper.showAlertMessage("Username can't contain special chars!", "Error", Alert.AlertType.ERROR);
            }else {
                UIHelper.showAlertMessage("You can't let fields empty!", "Error", Alert.AlertType.ERROR);
            }            
    }

    private boolean isNotEmpty(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    @Override
    public void onMsgReceived(String receivedMsg) {
        stringTokenizer = new StringTokenizer(receivedMsg, ";");
        String commandToExcute = stringTokenizer.nextToken();
        System.out.println(commandToExcute);
        System.out.println("onMsgReceived" + receivedMsg);

        switch (commandToExcute) {
            case AuthenticationConstants.SUCCESS_LOGIN:
                //UIHelper.showAlertMessage("Congrats!", receivedMsg, Alert.AlertType.INFORMATION);
                String username = stringTokenizer.nextToken();
                int score = Integer.parseInt(stringTokenizer.nextToken());
                System.out.println("user = " + username);
                System.out.println("score = " + score);
                networkLayer.setUsername(username);
                networkLayer.setScore(score);
                Navigation.navigateToOnlinePlayersScreen(this.stage);
                break;
            case AuthenticationConstants.ALREADY_LOGINED_ON_ANOTHER_DEVICE:
                UIHelper.showAlertMessage("Ouhh!", receivedMsg, Alert.AlertType.ERROR);
                break;
            case AuthenticationConstants.WRONG_USERNAME_OR_PASSWORD:
                UIHelper.showAlertMessage("Ouhh!", receivedMsg, Alert.AlertType.ERROR);
                break;
            case AuthenticationConstants.PROBLEM_IN_SERVER:
               UIHelper.showAlertMessage("Ouhh!", receivedMsg, Alert.AlertType.WARNING);
               break;
            default:
                Logger.getLogger(LoginScreenControllerImpl.class.getName()).log(Level.SEVERE, receivedMsg);
        }
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
