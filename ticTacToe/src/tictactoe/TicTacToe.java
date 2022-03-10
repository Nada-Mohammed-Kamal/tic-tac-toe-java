/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author nados
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
      
        Navigation.navigateTo(stage, new HomeScreen(stage), "Home screen");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
