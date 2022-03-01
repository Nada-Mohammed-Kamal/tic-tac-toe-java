/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import utils.UIHelper;

interface LoginScreenController {

    void onPressLoginBtn(String username, String password);

    void onPressSignupBtn(Stage stage);

    void onPressPressBackBtn(Stage stage);
    
}

public class LoginScreenControllerImpl implements LoginScreenController {
    LoginScreenBase view;
    public LoginScreenControllerImpl(LoginScreenBase view) {
        this.view = view;
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
    private void validateInputs(String username, String password){
        if(isNotEmpty(username,password))
            System.out.println("-----------");
         else
            UIHelper.showAlertMessage("You can't let fields empty!", "Error", Alert.AlertType.ERROR);

    }

    private boolean isNotEmpty(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }
}
