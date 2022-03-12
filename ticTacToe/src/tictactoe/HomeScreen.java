package tictactoe;
import ReplayGame.RecordedScreen;
import CursorHANDWhenMoveToIntoButton.CursorHANDWhenMoveToIntoButton;
import DisplayAlert.DisplayAlert;
import SinglePlayerLevels.SinglePlayerChooseLevel;
import tictactoe.login.LoginScreenBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Navigation.Navigation;
import SnakeGame.layoutBase;

public class HomeScreen extends AnchorPane {

    protected final ColorAdjust colorAdjust;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final AnchorPane anchorPane0;
    protected final Button onlinePlayer;
    protected final Button singlePlayer;
    protected final Button localMultiPlayer;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane1;
    protected final Button records;
    protected final InnerShadow innerShadow;
    protected final Circle circle;
    protected final ImageView imageView0;
    
     protected final ImageView imageSnake;
        
    public HomeScreen(Stage stage) {

        colorAdjust = new ColorAdjust();
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        anchorPane0 = new AnchorPane();
        onlinePlayer = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(onlinePlayer, stage);
        singlePlayer = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(singlePlayer, stage);
        localMultiPlayer = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(localMultiPlayer, stage);
        imageView = new ImageView();
        anchorPane1 = new AnchorPane();
        records = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(records, stage);
        innerShadow = new InnerShadow();
        circle = new Circle();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        setEffect(colorAdjust);

        anchorPane.setLayoutX(108.0);
        anchorPane.setLayoutY(164.0);

        label.setLayoutY(-29.0);
        label.setPrefHeight(140.0);
        label.setPrefWidth(216.0);
        label.setText("Tic");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 100.0));

        label0.setLayoutY(132.0);
        label0.setPrefHeight(140.0);
        label0.setPrefWidth(252.0);
        label0.setText("Toe");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label0.setFont(new Font("Berlin Sans FB", 100.0));

        label1.setLayoutX(3.0);
        label1.setLayoutY(52.0);
        label1.setPrefHeight(140.0);
        label1.setPrefWidth(228.0);
        label1.setText("Tac");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label1.setFont(new Font("Berlin Sans FB", 100.0));

        anchorPane0.setLayoutX(336.0);
        anchorPane0.setLayoutY(246.0);

        onlinePlayer.setLayoutY(193.0);
        onlinePlayer.setMnemonicParsing(false);
        onlinePlayer.setPrefHeight(84.0);
        onlinePlayer.setPrefWidth(427.0);
        onlinePlayer.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        onlinePlayer.setText("Online MultiPlayers");
        onlinePlayer.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        onlinePlayer.setFont(new Font("Comic Sans MS Bold", 40.0));
        onlinePlayer.setOnAction((action) -> {
            Navigation.navigateTo(stage, new LoginScreenBase(stage),"Log in");
        });
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setPrefHeight(84.0);
        singlePlayer.setPrefWidth(419.0);
        singlePlayer.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        singlePlayer.setText("Single Player");
        singlePlayer.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        singlePlayer.setFont(new Font("Comic Sans MS Bold", 40.0));
        singlePlayer.addEventHandler(ActionEvent.ACTION , new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 //DisplayAlert.getPlayerNameOnOnePlayer(stage);    
                Navigation.navigateTo(stage, new SinglePlayerChooseLevel(stage), "Choose Level");   
            }
        });
        
        localMultiPlayer.setLayoutX(4.0);
        localMultiPlayer.setLayoutY(97.0);
        localMultiPlayer.setMnemonicParsing(false);
        localMultiPlayer.setPrefHeight(84.0);
        localMultiPlayer.setPrefWidth(419.0);
        localMultiPlayer.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        localMultiPlayer.setText("Local MultiPlayers");
        localMultiPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        localMultiPlayer.setFont(new Font("Comic Sans MS Bold", 40.0));
        localMultiPlayer.addEventHandler(ActionEvent.ACTION , new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DisplayAlert.getPlayersName(stage);      
            }
        });
       
        imageView.setFitHeight(185.0);
        imageView.setFitWidth(338.0);
        imageView.setLayoutX(405.0);
        imageView.setLayoutY(38.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/XOLogo.jfif")));
      
        anchorPane1.setLayoutX(770.0);
        anchorPane1.setLayoutY(48.0);

        records.setMnemonicParsing(false);
        records.setPrefHeight(51.0);
        records.setPrefWidth(216.0);
        records.setStyle("-fx-background-color: #434341; -fx-background-radius: 45;");
        records.setText("Records      ");
        records.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        records.setFont(new Font("Comic Sans MS", 24.0));
        records.addEventHandler(ActionEvent.ACTION , new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Navigation.navigateTo(stage,new RecordedScreen(stage), "Recorded screen");
                
            }
        });
        
        records.setEffect(innerShadow);

        circle.setFill(javafx.scene.paint.Color.valueOf("#cd191a"));
        circle.setLayoutX(950.0);
        circle.setLayoutY(74.0);
        circle.setRadius(36.0);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);

        imageView0.setFitHeight(37.0);
        imageView0.setFitWidth(42.0);
        imageView0.setLayoutX(929.0);
        imageView0.setLayoutY(56.0);
        imageView0.setRotate(88.0);
        imageView0.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play.png")));
      
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(onlinePlayer);
        anchorPane0.getChildren().add(singlePlayer);
        anchorPane0.getChildren().add(localMultiPlayer);
        getChildren().add(anchorPane0);
        getChildren().add(imageView);
        anchorPane1.getChildren().add(records);
        getChildren().add(anchorPane1);
        getChildren().add(circle);
        getChildren().add(imageView0);
        
        imageSnake = new ImageView();
        imageSnake.setFitHeight(110.0);
        imageSnake.setFitWidth(150.0);
        imageSnake.setLayoutX(850.0);
        imageSnake.setLayoutY(484.0);
        imageSnake.setPickOnBounds(true);
        imageSnake.setPreserveRatio(true);
        imageSnake.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/snake.png")));
        imageSnake.setOnMouseClicked((value)->{
            Navigation.navigateTo(stage, new layoutBase(stage), "Snake game");
        });
        getChildren().add(imageSnake);
        

    }
}
