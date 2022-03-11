/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinglePlayerLevels;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import tictactoe.Navigation;
import CursorHANDWhenMoveToIntoButton.CursorHANDWhenMoveToIntoButton;
import DisplayAlert.DisplayAlert;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.HomeScreen;

/**
 *
 * @author Esraa
 */
public class SinglePlayerChooseLevel  extends AnchorPane {

    protected final ColorAdjust colorAdjust;
    protected final AnchorPane anchorPaneText;
    protected final Label tICLabel;
    protected final Label tACLabel;
    protected final Label tOElabel;
    protected final AnchorPane levelsButtonsAncotPane;
    protected final Button HardLevel;
    protected final Button easyLevel;
    protected final Button mediumLevel;
    protected final ImageView logoImage;
    protected final AnchorPane anchorPane1;
    protected final InnerShadow innerShadow;
    protected final Button backButton;
    protected final ImageView backButtonImage;
     protected final AnchorPane anchorPaneBackButton;
    public SinglePlayerChooseLevel(Stage stage) {
        anchorPaneBackButton = new AnchorPane();
        backButton = new Button();
        colorAdjust = new ColorAdjust();
        anchorPaneText = new AnchorPane();
        tICLabel = new Label();
        tACLabel = new Label();
        tOElabel = new Label();
        levelsButtonsAncotPane = new AnchorPane();
        HardLevel = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(HardLevel, stage);
        easyLevel = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(easyLevel, stage);
        mediumLevel = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(mediumLevel, stage);
        logoImage = new ImageView();
        backButtonImage = new ImageView();
        anchorPane1 = new AnchorPane();
        innerShadow = new InnerShadow();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        setEffect(colorAdjust);

        anchorPaneText.setLayoutX(108.0);
        anchorPaneText.setLayoutY(164.0);

        tICLabel.setLayoutY(-29.0);
        tICLabel.setPrefHeight(140.0);
        tICLabel.setPrefWidth(216.0);
        tICLabel.setText("Tic");
        tICLabel.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        tICLabel.setFont(new Font("Berlin Sans FB", 100.0));

        tACLabel.setLayoutY(132.0);
        tACLabel.setPrefHeight(140.0);
        tACLabel.setPrefWidth(252.0);
        tACLabel.setText("Toe");
        tACLabel.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        tACLabel.setFont(new Font("Berlin Sans FB", 100.0));

        tOElabel.setLayoutX(3.0);
        tOElabel.setLayoutY(52.0);
        tOElabel.setPrefHeight(140.0);
        tOElabel.setPrefWidth(228.0);
        tOElabel.setText("Tac");
        tOElabel.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        tOElabel.setFont(new Font("Berlin Sans FB", 100.0));

        levelsButtonsAncotPane.setLayoutX(336.0);
        levelsButtonsAncotPane.setLayoutY(246.0);
        
        easyLevel.setMnemonicParsing(false);
        easyLevel.setPrefHeight(84.0);
        easyLevel.setPrefWidth(419.0);
        easyLevel.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        easyLevel.setText("Easy Level");
        easyLevel.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        easyLevel.setFont(new Font("Comic Sans MS Bold", 40.0));
        easyLevel.addEventHandler(ActionEvent.ACTION , new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 DisplayAlert.getPlayerNameOnOnePlayer(stage,"easy");                   
            }
        });
        
        mediumLevel.setLayoutX(4.0);
        mediumLevel.setLayoutY(97.0);
        mediumLevel.setMnemonicParsing(false);
        mediumLevel.setPrefHeight(84.0);
        mediumLevel.setPrefWidth(419.0);
        mediumLevel.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        mediumLevel.setText("Medium Level");
        mediumLevel.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        mediumLevel.setFont(new Font("Comic Sans MS Bold", 40.0));
        mediumLevel.addEventHandler(ActionEvent.ACTION , new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                DisplayAlert.getPlayerNameOnOnePlayer(stage,"medium"); 
            }
        });
        
        HardLevel.setLayoutY(193.0);
        HardLevel.setMnemonicParsing(false);
        HardLevel.setPrefHeight(84.0);
        HardLevel.setPrefWidth(427.0);
        HardLevel.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        HardLevel.setText("Hard Level");
        HardLevel.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        HardLevel.setFont(new Font("Comic Sans MS Bold", 40.0));
        HardLevel.setOnAction((action) -> {
            DisplayAlert.getPlayerNameOnOnePlayer(stage,"hard"); 
            //Navigation.navigateTo(stage, new LoginScreenBase(stage),"Log in");
        });
        
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(75.0);
        backButton.setPrefWidth(185.0);
        backButton.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        backButton.setText("       Back");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        backButton.setFont(new Font("Berlin Sans FB", 33.0));
        backButton.addEventHandler(ActionEvent.ACTION ,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Navigation.navigateTo(stage, new HomeScreen(stage), "Home Screen");
                 }
        });
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(backButton, stage);
        
        logoImage.setFitHeight(185.0);
        logoImage.setFitWidth(338.0);
        logoImage.setLayoutX(405.0);
        logoImage.setLayoutY(38.0);
        logoImage.setPickOnBounds(true);
        logoImage.setPreserveRatio(true);
        logoImage.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/XOLogo.jfif")));
      
        backButtonImage.setFitHeight(50.0);
        backButtonImage.setFitWidth(52.0);
        backButtonImage.setLayoutX(16.0);
        backButtonImage.setLayoutY(11.0);
        backButtonImage.setOpacity(0.47);
        backButtonImage.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));
        
        anchorPaneBackButton.setLayoutX(29.0);
        anchorPaneBackButton.setLayoutY(501.0);
        
        anchorPaneText.getChildren().add(tICLabel);
        anchorPaneText.getChildren().add(tACLabel);
        anchorPaneText.getChildren().add(tOElabel);
        
        getChildren().add(anchorPaneText);
        levelsButtonsAncotPane.getChildren().add(HardLevel);
        levelsButtonsAncotPane.getChildren().add(easyLevel);
        levelsButtonsAncotPane.getChildren().add(mediumLevel);
        
        anchorPaneBackButton.getChildren().add(backButton);
        anchorPaneBackButton.getChildren().add(backButtonImage);
        getChildren().add(anchorPaneBackButton);
        
        getChildren().add(levelsButtonsAncotPane);
        getChildren().add(logoImage);
        getChildren().add(anchorPane1);
        

    }
}