/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author nados
 */
public class ResultScreenController{

    /**
     * Initializes the controller class.
     */
       
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView playerOneImg;

    @FXML
    private Label playerOneName;

    @FXML
    private Label playerOneResult;

    @FXML
    private ImageView playerTwoImage;

    @FXML
    private Label playerTwoName;

    @FXML
    private Label playerTwoResult;

    @FXML
    private Button BackButtonid;

    @FXML
    private Button SaveButtonid;

    @FXML
    private Button PlayAgainButtonid;

    @FXML
    private Label GameResultId;

    @FXML
    void BackButton(ActionEvent event) {

    }

    @FXML
    void PlayAgainButton(ActionEvent event) {

    }

    @FXML
    void SaveButton(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    }
    
}
