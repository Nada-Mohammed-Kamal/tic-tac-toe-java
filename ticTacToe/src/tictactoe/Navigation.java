/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import tictactoe.signup.SignUp;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.login.LoginScreenBase;
import utils.Constants;

/**
 *
 * @author AhmedAli
 */
public class Navigation {
    
    public static void navigateTo(Stage stage, Parent r, String title) {
        Parent root = r;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
    
    public static void navigateToSignUp(Stage stage) {
        navigateTo(stage, new SignUp(stage), Constants.SIGN_UP);
    }
        
    public static void navigateToHome(Stage stage) {
        navigateTo(stage, new HomeScreen(stage), Constants.HOME);
    }
    
    public static void navigateToLogin(Stage stage) {
        navigateTo(stage, new LoginScreenBase(stage), Constants.LOGIN);
    }
    
        
    public static void navigateToOnlinePlayersScreen(Stage stage) {
        navigateTo(stage, new OnlinePlayersScreen(stage), Constants.ONLINE_PLAYERS_SCREEN);
    }
}
