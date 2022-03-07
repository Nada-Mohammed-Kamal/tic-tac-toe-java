package onlineplayerscreen;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.PlayerDto;

interface OnlinePlayerScreenInterface{
    void updateOnlinePlayersList(ArrayList<PlayerDto> players);
    void displayUserData(String username, int score);
}

public class OnlinePlayersScreen extends AnchorPane implements OnlinePlayerScreenInterface{
    OnlinePlayerScreenController onlinePlayerScreenController;
    protected final AnchorPane anchorPane;
    protected final Label UserName;
    protected final ImageView PlayerImg;
    protected final Label playerOneResult1;
    protected final Label UserScore;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;
    protected final Button BackButtonid;
    protected final ImageView imageView;
   
    protected final AnchorPane anchorPane3;
    protected final Label label;
    protected final AnchorPane anchorPane4;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    
    protected final AnchorPane anchorPane5;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;

    public OnlinePlayersScreen(Stage stage) {

        anchorPane = new AnchorPane();
        UserName = new Label();
        PlayerImg = new ImageView();
        playerOneResult1 = new Label();
        UserScore = new Label();
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        BackButtonid = new Button();
        imageView = new ImageView();
        
        anchorPane3 = new AnchorPane();
        label = new Label();
        anchorPane4 = new AnchorPane();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        
        anchorPane5 = new AnchorPane();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        

        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072A40;");

        anchorPane.setLayoutX(24.0);
        anchorPane.setLayoutY(56.0);
        anchorPane.setPrefHeight(407.0);
        anchorPane.setPrefWidth(194.0);

        UserName.setLayoutX(26.0);
        UserName.setLayoutY(155.0);
        UserName.setPrefHeight(59.0);
        UserName.setPrefWidth(194.0);
        UserName.setText("Esraa");
        UserName.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        UserName.setFont(new Font("Berlin Sans FB", 53.0));

        PlayerImg.setFitHeight(144.0);
        PlayerImg.setFitWidth(171.0);
        PlayerImg.setLayoutX(12.0);
        PlayerImg.setLayoutY(4.0);
        PlayerImg.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        PlayerImg.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play1.png")));

        playerOneResult1.setLayoutX(11.0);
        playerOneResult1.setLayoutY(264.0);
        playerOneResult1.setPrefHeight(59.0);
        playerOneResult1.setPrefWidth(101.0);
        playerOneResult1.setText("Score");
        playerOneResult1.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerOneResult1.setFont(new Font("Berlin Sans FB", 42.0));

        UserScore.setLayoutX(161.0);
        UserScore.setLayoutY(267.0);
        UserScore.setPrefHeight(59.0);
        UserScore.setPrefWidth(57.0);
        UserScore.setText("5");
        UserScore.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        UserScore.setFont(new Font("Berlin Sans FB", 45.0));

        anchorPane0.setLayoutX(773.0);
        anchorPane0.setLayoutY(114.0);

        anchorPane1.setLayoutX(19.0);
        anchorPane1.setLayoutY(485.0);
        anchorPane1.setPrefHeight(78.0);
        anchorPane1.setPrefWidth(180.0);

        BackButtonid.setLayoutX(-3.0);
        BackButtonid.setMnemonicParsing(false);
        BackButtonid.setPrefHeight(84.0);
        BackButtonid.setPrefWidth(194.0);
        BackButtonid.setStyle("-fx-background-radius: 17; -fx-background-color: #E7FFDB;");
        BackButtonid.setText("       Back");
        BackButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        BackButtonid.setFont(new Font("Berlin Sans FB", 33.0));

        imageView.setFitHeight(65.0);
        imageView.setFitWidth(67.0);
        imageView.setLayoutX(13.0);
        imageView.setLayoutY(11.0);
        imageView.setOpacity(0.47);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));

        anchorPane3.setLayoutX(378.0);
        anchorPane3.setLayoutY(300.0);
        anchorPane3.setPrefHeight(75.0);
        anchorPane3.setPrefWidth(259.0);

        label.setLayoutX(279.0);
        label.setLayoutY(16.0);
        label.setPrefHeight(95.0);
        label.setPrefWidth(454.0);
        label.setText("TIC TAC TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 82.0));

        anchorPane4.setLayoutX(275.0);
        anchorPane4.setLayoutY(216.0);
        anchorPane4.setMinHeight(USE_PREF_SIZE);
        anchorPane4.setMinWidth(USE_PREF_SIZE);
        anchorPane4.setPrefHeight(357.0);
        anchorPane4.setPrefWidth(710.0);
        anchorPane4.setStyle("-fx-background-color: #E9EDF0; -fx-background-radius: 10;");

        scrollPane.setHbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutX(5.0);
        scrollPane.setLayoutY(19.0);
        scrollPane.setPrefHeight(337.0);
        scrollPane.setPrefWidth(706.0);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background-radius: 10;");
        scrollPane.setVbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.ALWAYS);

        vBox.setPrefHeight(326.0);
        vBox.setPrefWidth(690.0);

        scrollPane.setContent(vBox);

        anchorPane5.setLayoutX(276.0);
        anchorPane5.setLayoutY(152.0);
        anchorPane5.setPrefHeight(74.0);
        anchorPane5.setPrefWidth(710.0);
        anchorPane5.setStyle("-fx-background-color: #8596A0; -fx-background-radius: 10;");

        label0.setLayoutX(39.0);
        label0.setLayoutY(14.0);
        label0.setPrefHeight(44.0);
        label0.setPrefWidth(107.0);
        label0.setText("Name");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("Berlin Sans FB", 40.0));

        label1.setLayoutX(286.0);
        label1.setLayoutY(17.0);
        label1.setPrefHeight(36.0);
        label1.setPrefWidth(89.0);
        label1.setText("Score");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("Berlin Sans FB", 40.0));

        label2.setLayoutX(446.0);
        label2.setLayoutY(15.0);
        label2.setPrefHeight(44.0);
        label2.setPrefWidth(109.0);
        label2.setText("Status");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Berlin Sans FB", 40.0));

        anchorPane.getChildren().add(UserName);
        anchorPane.getChildren().add(PlayerImg);
        anchorPane.getChildren().add(playerOneResult1);
        anchorPane.getChildren().add(UserScore);
        getChildren().add(anchorPane);
        getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(BackButtonid);
        anchorPane1.getChildren().add(imageView);
        getChildren().add(anchorPane1);
        getChildren().add(anchorPane3);
        getChildren().add(label);
        
        anchorPane4.getChildren().add(scrollPane);
        getChildren().add(anchorPane4);
        anchorPane5.getChildren().add(label0);
        anchorPane5.getChildren().add(label1);
        anchorPane5.getChildren().add(label2);
        getChildren().add(anchorPane5);
        vBox.setSpacing(8);
        vBox.minWidth(USE_PREF_SIZE);
        vBox.minHeight(USE_PREF_SIZE);
        onlinePlayerScreenController = new OnlinePlayerScreenControllerImpl(this, stage);

        //onlinePlayerScreenController.showOnlineUsers();
    }
    void addNewOnlineUser(String name ,String score,String status,String buttonText)
    {
        Label OnlinePlayerName = new Label();
        OnlinePlayerName.setLayoutX(45.0);
        OnlinePlayerName.setLayoutY(27.0);
        OnlinePlayerName.setText(name);
        OnlinePlayerName.setTextFill(javafx.scene.paint.Color.WHITE);
        OnlinePlayerName.setFont(new Font("Arial", 31.0));
        
        Label OnlinePlayerScore = new Label();
        OnlinePlayerScore.setLayoutX(314.0);
        OnlinePlayerScore.setLayoutY(25.0);
        OnlinePlayerScore.setText(score);
        OnlinePlayerScore.setTextFill(javafx.scene.paint.Color.WHITE);
        OnlinePlayerScore.setFont(new Font("Arial", 31.0));
        
        Label OnlinePlyerStauts = new Label();
        OnlinePlyerStauts.setLayoutX(451.0);
        OnlinePlyerStauts.setLayoutY(24.0);
        OnlinePlyerStauts.setText(status);
        OnlinePlyerStauts.setTextFill(javafx.scene.paint.Color.WHITE);
        OnlinePlyerStauts.setFont(new Font("Arial", 31.0));
        
        Button ButtonToOnlineUser = new Button();
        ButtonToOnlineUser.setLayoutX(569.0);
        ButtonToOnlineUser.setLayoutY(23.0);
        ButtonToOnlineUser.setMnemonicParsing(false);
        ButtonToOnlineUser.setPrefHeight(34.0);
        ButtonToOnlineUser.setPrefWidth(91.0);
        ButtonToOnlineUser.setStyle("-fx-background-color: #1FA4E5;");
        ButtonToOnlineUser.setText(buttonText);
        ButtonToOnlineUser.setTextFill(javafx.scene.paint.Color.WHITE);
        ButtonToOnlineUser.setFont(new Font(18.0));
        ButtonToOnlineUser.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //write your own code to do when click the button
                //The name of the player you choose
                //OnlinePlayerName.getText();
                 }
        });
        AnchorPane UserDetails = new AnchorPane();
        UserDetails.setPrefHeight(85.0);
        UserDetails.setPrefWidth(681.0);
        UserDetails.setStyle("-fx-background-color: #8596A0; -fx-background-radius: 10;");
        UserDetails.minWidth(USE_PREF_SIZE);
        UserDetails.minHeight(USE_PREF_SIZE);
        
        UserDetails.getChildren().add(OnlinePlayerName);
        UserDetails.getChildren().add(OnlinePlayerScore);
        UserDetails.getChildren().add(OnlinePlyerStauts);
        UserDetails.getChildren().add(ButtonToOnlineUser);
        vBox.getChildren().add(UserDetails);
    }
    @Override
    public void updateOnlinePlayersList(ArrayList<PlayerDto> players){
        vBox.getChildren().clear();
        for(PlayerDto player : players) {
            addNewOnlineUser(player.getUsername(), String.valueOf(player.getScore()), "online", "play");
        }
    }

    @Override
    public void displayUserData(String username, int score) {
        UserName.setText(username);
        UserScore.setText(""+score);
    }
}
