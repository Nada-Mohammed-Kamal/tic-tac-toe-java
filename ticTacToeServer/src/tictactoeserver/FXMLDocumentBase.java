package tictactoeserver;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLDocumentBase extends AnchorPane {

    protected final ColorAdjust colorAdjust;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final AnchorPane anchorPane0;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane1;
    protected final Button Stop;
    protected final Button Start;
    protected final Label StautsOfServer;
    protected final Label OnlineNum;
    protected final Label OffilneNum;
    protected final AnchorPane anchorPane2;
    protected final Label statusOfUserOnButton;
    protected final ScrollPane scrollPane;
    protected final Button NameOfPersonButton;

    public FXMLDocumentBase() {

        colorAdjust = new ColorAdjust();
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        anchorPane0 = new AnchorPane();
        imageView = new ImageView();
        anchorPane1 = new AnchorPane();
        Stop = new Button();
        Start = new Button();
        StautsOfServer = new Label();
        OnlineNum = new Label();
        OffilneNum = new Label();
        anchorPane2 = new AnchorPane();
        statusOfUserOnButton = new Label();
        scrollPane = new ScrollPane();
        NameOfPersonButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        setEffect(colorAdjust);

        anchorPane.setLayoutX(66.0);
        anchorPane.setLayoutY(164.0);

        label.setLayoutY(-29.0);
        label.setPrefHeight(140.0);
        label.setPrefWidth(216.0);
        label.setText("TIC");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 100.0));

        label0.setLayoutY(166.0);
        label0.setPrefHeight(140.0);
        label0.setPrefWidth(252.0);
        label0.setText("TOE");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label0.setFont(new Font("Berlin Sans FB", 100.0));

        label1.setLayoutY(66.0);
        label1.setPrefHeight(140.0);
        label1.setPrefWidth(228.0);
        label1.setText("TAC");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label1.setFont(new Font("Berlin Sans FB", 100.0));

        anchorPane0.setLayoutX(336.0);
        anchorPane0.setLayoutY(246.0);

        imageView.setFitHeight(188.0);
        imageView.setFitWidth(307.0);
        imageView.setLayoutX(357.0);
        imageView.setLayoutY(36.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
      //  imageView.setImage(new Image(getClass().getResource("../../../../../../Desktop/044e056e-b176-478c-b7af-34cbd57d197c.jpg").toExternalForm()));

        anchorPane1.setLayoutX(770.0);
        anchorPane1.setLayoutY(48.0);

        Stop.setLayoutX(290.0);
        Stop.setLayoutY(390.0);
        Stop.setMnemonicParsing(false);
        Stop.setPrefHeight(84.0);
        Stop.setPrefWidth(419.0);
        Stop.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        Stop.setText("Stop");
        Stop.setTextFill(javafx.scene.paint.Color.WHITE);
        Stop.setFont(new Font("Comic Sans MS Bold", 40.0));

        Start.setLayoutX(290.0);
        Start.setLayoutY(258.0);
        Start.setMnemonicParsing(false);
        Start.setPrefHeight(84.0);
        Start.setPrefWidth(409.0);
        Start.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        Start.setText("Start");
        Start.setTextFill(javafx.scene.paint.Color.WHITE);
        Start.setFont(new Font("Comic Sans MS Bold", 40.0));

        StautsOfServer.setLayoutX(66.0);
        StautsOfServer.setLayoutY(470.0);
        StautsOfServer.setPrefHeight(140.0);
        StautsOfServer.setPrefWidth(252.0);
        StautsOfServer.setText("Server is online");
        StautsOfServer.setTextFill(javafx.scene.paint.Color.valueOf("#22bd62"));
        StautsOfServer.setFont(new Font("Berlin Sans FB", 38.0));

        OnlineNum.setLayoutX(787.0);
        OnlineNum.setLayoutY(-22.0);
        OnlineNum.setPrefHeight(140.0);
        OnlineNum.setPrefWidth(252.0);
        OnlineNum.setText("Online:7");
        OnlineNum.setTextFill(javafx.scene.paint.Color.valueOf("#22bd62"));
        OnlineNum.setFont(new Font("Berlin Sans FB", 36.0));

        OffilneNum.setLayoutX(787.0);
        OffilneNum.setLayoutY(36.0);
        OffilneNum.setPrefHeight(140.0);
        OffilneNum.setPrefWidth(252.0);
        OffilneNum.setText("Offilne:70");
        OffilneNum.setTextFill(javafx.scene.paint.Color.valueOf("#bd2227"));
        OffilneNum.setFont(new Font("Berlin Sans FB", 38.0));

        anchorPane2.setLayoutX(750.0);
        anchorPane2.setLayoutY(149.0);
        anchorPane2.setMinHeight(USE_PREF_SIZE);
        anchorPane2.setMinWidth(USE_PREF_SIZE);
        anchorPane2.setPrefHeight(410.0);
        anchorPane2.setPrefWidth(228.0);
        anchorPane2.setStyle("-fx-background-color: #E9EDF0; -fx-background-radius: 10;");

        statusOfUserOnButton.setLayoutX(685.0);
        statusOfUserOnButton.setLayoutY(105.0);
        statusOfUserOnButton.setPrefHeight(30.0);
        statusOfUserOnButton.setPrefWidth(62.0);
        statusOfUserOnButton.setText("offline");
        statusOfUserOnButton.setTextFill(javafx.scene.paint.Color.WHITE);
        statusOfUserOnButton.setFont(new Font("Arial", 16.0));

        AnchorPane.setBottomAnchor(scrollPane, 270.0);
        AnchorPane.setLeftAnchor(scrollPane, 336.0);
        AnchorPane.setRightAnchor(scrollPane, 471.0);
        AnchorPane.setTopAnchor(scrollPane, 72.0);
        scrollPane.setHbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutX(336.0);
        scrollPane.setLayoutY(72.0);
        scrollPane.setPannable(true);
        scrollPane.setPrefHeight(258.0);
        scrollPane.setPrefWidth(193.0);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background-radius: 20;");
        scrollPane.setVbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.ALWAYS);

        NameOfPersonButton.setAlignment(javafx.geometry.Pos.BASELINE_LEFT);
        NameOfPersonButton.setLayoutX(575.0);
        NameOfPersonButton.setLayoutY(93.0);
        NameOfPersonButton.setMnemonicParsing(false);
        NameOfPersonButton.setPrefHeight(54.0);
        NameOfPersonButton.setPrefWidth(207.0);
        NameOfPersonButton.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 10;");
        NameOfPersonButton.setText("Esraa");
        NameOfPersonButton.setTextFill(javafx.scene.paint.Color.WHITE);
        NameOfPersonButton.setFont(new Font("Arial", 23.0));

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        getChildren().add(anchorPane);
        getChildren().add(anchorPane0);
        getChildren().add(imageView);
        getChildren().add(anchorPane1);
        getChildren().add(Stop);
        getChildren().add(Start);
        getChildren().add(StautsOfServer);
        getChildren().add(OnlineNum);
        getChildren().add(OffilneNum);
        getChildren().add(anchorPane2);
        getChildren().add(statusOfUserOnButton);
        getChildren().add(scrollPane);
        getChildren().add(NameOfPersonButton);

    }
}