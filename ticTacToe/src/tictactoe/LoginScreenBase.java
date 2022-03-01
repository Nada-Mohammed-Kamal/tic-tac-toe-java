package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.UIHelper;

public class LoginScreenBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final AnchorPane anchorPane0;
    protected final Button backButtonid;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane1;
    protected final Button loginId;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final AnchorPane anchorPane2;
    protected final Label label2;
    protected final Button signUpHere;
    protected final TextField nameTextBoxid;
    protected final TextField passwordtextboxid;
    private LoginScreenController controller;
    public LoginScreenBase(Stage stage) {
        controller = new LoginScreenControllerImpl(this);
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        anchorPane0 = new AnchorPane();
        backButtonid = new Button();
        imageView = new ImageView();
        anchorPane1 = new AnchorPane();
        loginId = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        anchorPane2 = new AnchorPane();
        label2 = new Label();
        signUpHere = new Button();
        nameTextBoxid = new TextField();
        passwordtextboxid = new TextField();

        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        anchorPane.setLayoutX(79.0);
        anchorPane.setLayoutY(164.0);

        label.setLayoutY(132.0);
        label.setPrefHeight(140.0);
        label.setPrefWidth(252.0);
        label.setText("Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 100.0));

        label0.setLayoutY(-29.0);
        label0.setPrefHeight(140.0);
        label0.setPrefWidth(216.0);
        label0.setText("Tic");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label0.setFont(new Font("Berlin Sans FB", 100.0));

        label1.setLayoutX(3.0);
        label1.setLayoutY(52.0);
        label1.setPrefHeight(140.0);
        label1.setPrefWidth(228.0);
        label1.setText("Tac");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label1.setFont(new Font("Berlin Sans FB", 100.0));

        anchorPane0.setLayoutX(39.0);
        anchorPane0.setLayoutY(504.0);

        backButtonid.setLayoutY(-14.0);
        backButtonid.setMnemonicParsing(false);
        backButtonid.setPrefHeight(89.0);
        backButtonid.setPrefWidth(185.0);
        backButtonid.setStyle("-fx-background-radius: 17;");
        backButtonid.setText("       Back");
        backButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        backButtonid.setFont(new Font("Berlin Sans FB", 33.0));
        backButtonid.setOnAction(action -> {
            controller.onPressPressBackBtn(stage);
        });
        imageView.setFitHeight(62.0);
        imageView.setFitWidth(62.0);
        imageView.setLayoutX(13.0);
        imageView.setLayoutY(3.0);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));
        
        anchorPane1.setLayoutX(396.0);
        anchorPane1.setLayoutY(504.0);

        loginId.setLayoutY(-14.0);
        loginId.setMnemonicParsing(false);
        loginId.setPrefHeight(89.0);
        loginId.setPrefWidth(185.0);
        loginId.setStyle("-fx-background-radius: 17;");
        loginId.setText("      LogIn");
        loginId.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        loginId.setFont(new Font("Berlin Sans FB", 33.0));
        loginId.setOnAction(action -> {
            controller.onPressLoginBtn(nameTextBoxid.getText(), passwordtextboxid.getText());
        });
        imageView0.setFitHeight(62.0);
        imageView0.setFitWidth(62.0);
        imageView0.setLayoutX(13.0);
        imageView0.setLayoutY(3.0);
        imageView0.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/login.png")));
        
        imageView1.setFitHeight(177.0);
        imageView1.setFitWidth(252.0);
        imageView1.setLayoutX(419.0);
        imageView1.setLayoutY(29.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/XOLogo.jfif")));
        
        anchorPane2.setLayoutX(679.0);
        anchorPane2.setLayoutY(467.0);
        anchorPane2.setPrefHeight(133.0);
        anchorPane2.setPrefWidth(292.0);

        label2.setPrefHeight(89.0);
        label2.setPrefWidth(353.0);
        label2.setText("Don't have an account?");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label2.setFont(new Font("Berlin Sans FB", 30.0));

        signUpHere.setLayoutX(-47.0);
        signUpHere.setLayoutY(45.0);
        signUpHere.setMnemonicParsing(false);
        signUpHere.setPrefHeight(89.0);
        signUpHere.setPrefWidth(282.0);
        signUpHere.setStyle("-fx-background-radius: 17; -fx-background-color: tranceparent;");
        signUpHere.setText("Sign up here");
        signUpHere.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        signUpHere.setFont(new Font("Berlin Sans FB Bold", 33.0));
        signUpHere.setOnAction(action ->{
            controller.onPressSignupBtn(stage);
        });
        signUpHere.setOnMouseEntered((event) -> {
            stage.getScene().setCursor(Cursor.HAND);
        });
        
        nameTextBoxid.setLayoutX(352.0);
        nameTextBoxid.setLayoutY(221.0);
        nameTextBoxid.setPrefHeight(79.0);
        nameTextBoxid.setPrefWidth(556.0);
        nameTextBoxid.setPromptText("Name");
        nameTextBoxid.setStyle("-fx-background-color: trancperant; -fx-border-radius: 20; -fx-border-color: #99a7b0; -fx-border-width: 0.5; -fx-text-fill: #99a7b0;");
        nameTextBoxid.setFont(new Font("Berlin Sans FB", 36.0));

        passwordtextboxid.setLayoutX(352.0);
        passwordtextboxid.setLayoutY(337.0);
        passwordtextboxid.setPrefHeight(79.0);
        passwordtextboxid.setPrefWidth(556.0);
        passwordtextboxid.setPromptText("Password");
        passwordtextboxid.setStyle("-fx-background-color: trancperant; -fx-border-radius: 20; -fx-border-color: #99a7b0; -fx-border-width: 0.5; -fx-text-fill: #99a7b0;");
        passwordtextboxid.setFont(new Font("Berlin Sans FB", 36.0));

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(backButtonid);
        anchorPane0.getChildren().add(imageView);
        getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(loginId);
        anchorPane1.getChildren().add(imageView0);
        getChildren().add(anchorPane1);
        getChildren().add(imageView1);
        anchorPane2.getChildren().add(label2);
        anchorPane2.getChildren().add(signUpHere);
        getChildren().add(anchorPane2);
        getChildren().add(nameTextBoxid);
        getChildren().add(passwordtextboxid);

    }
   

}
