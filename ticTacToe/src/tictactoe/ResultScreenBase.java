package tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class ResultScreenBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;
    protected final ImageView playerOneImg;
    protected final Label label;
    protected final Label playerOneName;
    protected final Label playerOneResult;
    protected final AnchorPane anchorPane1;
    protected final AnchorPane anchorPane2;
    protected final ImageView playerTwoImage;
    protected final Label label0;
    protected final Label playerTwoName;
    protected final Label playerTwoResult;
    protected final AnchorPane anchorPane3;
    protected final Button BackButtonid;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane4;
    protected final Button SaveButtonid;
    protected final ImageView imageView0;
    protected final AnchorPane anchorPane5;
    protected final Button PlayAgainButtonid;
    protected final ImageView imageView1;
    protected final Label GameResultId;

    public ResultScreenBase() {

        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();
        playerOneImg = new ImageView();
        label = new Label();
        playerOneName = new Label();
        playerOneResult = new Label();
        anchorPane1 = new AnchorPane();
        anchorPane2 = new AnchorPane();
        playerTwoImage = new ImageView();
        label0 = new Label();
        playerTwoName = new Label();
        playerTwoResult = new Label();
        anchorPane3 = new AnchorPane();
        BackButtonid = new Button();
        imageView = new ImageView();
        
        anchorPane4 = new AnchorPane();
        
        SaveButtonid = new Button();
        
        imageView0 = new ImageView();
        anchorPane5 = new AnchorPane();
        PlayAgainButtonid = new Button();
        imageView1 = new ImageView();
        GameResultId = new Label();

        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072A40;");

        anchorPane.setLayoutX(59.0);
        anchorPane.setLayoutY(111.0);

        playerOneImg.setFitHeight(142.0);
        playerOneImg.setFitWidth(154.0);
        playerOneImg.setLayoutX(9.0);
        playerOneImg.setLayoutY(94.0);
        playerOneImg.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        playerOneImg.setImage(new Image(getClass().getResource("../../../../../../Desktop/male.jfif").toExternalForm()));

        label.setLayoutX(144.0);
        label.setLayoutY(222.0);
        label.setText("X");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label.setFont(new Font("Berlin Sans FB", 68.0));

        playerOneName.setLayoutX(5.0);
        playerOneName.setPrefHeight(75.0);
        playerOneName.setPrefWidth(193.0);
        playerOneName.setText("player1");
        playerOneName.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerOneName.setFont(new Font("Berlin Sans FB", 36.0));

        playerOneResult.setLayoutX(32.0);
        playerOneResult.setLayoutY(297.0);
        playerOneResult.setPrefHeight(54.0);
        playerOneResult.setPrefWidth(109.0);
        playerOneResult.setText("result1");
        playerOneResult.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerOneResult.setFont(new Font("Berlin Sans FB", 36.0));

        anchorPane1.setLayoutX(773.0);
        anchorPane1.setLayoutY(114.0);

        anchorPane2.setPrefHeight(305.0);
        anchorPane2.setPrefWidth(196.0);

        playerTwoImage.setFitHeight(142.0);
        playerTwoImage.setFitWidth(154.0);
        playerTwoImage.setLayoutX(9.0);
        playerTwoImage.setLayoutY(94.0);
        playerTwoImage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        playerTwoImage.setImage(new Image(getClass().getResource("../../../../../../Desktop/female.jfif").toExternalForm()));

        label0.setLayoutX(144.0);
        label0.setLayoutY(222.0);
        label0.setText("O");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label0.setFont(new Font("Berlin Sans FB", 68.0));

        playerTwoName.setLayoutX(3.0);
        playerTwoName.setPrefHeight(64.0);
        playerTwoName.setPrefWidth(193.0);
        playerTwoName.setText("player2");
        playerTwoName.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerTwoName.setFont(new Font("Berlin Sans FB", 36.0));

        playerTwoResult.setLayoutX(44.0);
        playerTwoResult.setLayoutY(294.0);
        playerTwoResult.setPrefHeight(54.0);
        playerTwoResult.setPrefWidth(109.0);
        playerTwoResult.setText("result2");
        playerTwoResult.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerTwoResult.setFont(new Font("Berlin Sans FB", 36.0));

        anchorPane3.setLayoutX(39.0);
        anchorPane3.setLayoutY(511.0);

        BackButtonid.setMnemonicParsing(false);
        BackButtonid.setOnAction(this::BackButton);
        BackButtonid.setPrefHeight(75.0);
        BackButtonid.setPrefWidth(185.0);
        BackButtonid.setStyle("-fx-background-radius: 17;");
        BackButtonid.setText("       Back");
        BackButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        BackButtonid.setFont(new Font("Berlin Sans FB", 33.0));

        imageView.setFitHeight(54.0);
        imageView.setFitWidth(62.0);
        imageView.setLayoutX(13.0);
        imageView.setLayoutY(11.0);
        imageView.setOpacity(0.47);
        imageView.setImage(new Image(getClass().getResource("../../../../../../Desktop/back%20button.png").toExternalForm()));

        
        anchorPane4.setLayoutX(779.0);
        anchorPane4.setLayoutY(511.0);

        
        SaveButtonid.setMnemonicParsing(false);
        SaveButtonid.setOnAction(this::SaveButton);
        SaveButtonid.setPrefHeight(75.0);
        SaveButtonid.setPrefWidth(185.0);
        SaveButtonid.setStyle("-fx-background-radius: 17;");
        SaveButtonid.setText("       Save");
        SaveButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        SaveButtonid.setFont(new Font("Berlin Sans FB", 33.0));

        imageView0.setFitHeight(54.0);
        imageView0.setFitWidth(62.0);
        imageView0.setLayoutX(13.0);
        imageView0.setLayoutY(11.0);
        imageView0.setOpacity(0.47);
        imageView0.setImage(new Image(getClass().getResource("../../../../../../Desktop/back%20button.png").toExternalForm()));

        anchorPane5.setLayoutX(378.0);
        anchorPane5.setLayoutY(300.0);
        anchorPane5.setPrefHeight(75.0);
        anchorPane5.setPrefWidth(259.0);

        AnchorPane.setBottomAnchor(PlayAgainButtonid, 0.0);
        AnchorPane.setLeftAnchor(PlayAgainButtonid, 0.0);
        AnchorPane.setRightAnchor(PlayAgainButtonid, 0.0);
        AnchorPane.setTopAnchor(PlayAgainButtonid, 0.0);
        PlayAgainButtonid.setMnemonicParsing(false);
        PlayAgainButtonid.setOnAction(this::PlayAgainButton);
        PlayAgainButtonid.setPrefHeight(75.0);
        PlayAgainButtonid.setPrefWidth(216.0);
        PlayAgainButtonid.setStyle("-fx-background-radius: 17;");
        PlayAgainButtonid.setText("       Play Again");
        PlayAgainButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        PlayAgainButtonid.setFont(new Font("Berlin Sans FB", 33.0));

        imageView1.setFitHeight(54.0);
        imageView1.setFitWidth(62.0);
        imageView1.setLayoutX(13.0);
        imageView1.setLayoutY(11.0);
        imageView1.setOpacity(0.47);
        imageView1.setImage(new Image(getClass().getResource("../../../../../../Desktop/back%20button.png").toExternalForm()));

        GameResultId.setAlignment(javafx.geometry.Pos.CENTER);
        GameResultId.setLayoutX(339.0);
        GameResultId.setLayoutY(219.0);
        GameResultId.setMinHeight(USE_PREF_SIZE);
        GameResultId.setMinWidth(USE_PREF_SIZE);
        GameResultId.setPrefHeight(54.0);
        GameResultId.setPrefWidth(342.0);
        GameResultId.setText("game Result");
        GameResultId.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        GameResultId.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        GameResultId.setFont(new Font("Berlin Sans FB", 36.0));

        anchorPane0.getChildren().add(playerOneImg);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(playerOneName);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(playerOneResult);
        getChildren().add(anchorPane);
        anchorPane2.getChildren().add(playerTwoImage);
        anchorPane2.getChildren().add(label0);
        anchorPane2.getChildren().add(playerTwoName);
        anchorPane1.getChildren().add(anchorPane2);
        anchorPane1.getChildren().add(playerTwoResult);
        getChildren().add(anchorPane1);
        anchorPane3.getChildren().add(BackButtonid);
        anchorPane3.getChildren().add(imageView);
        getChildren().add(anchorPane3);
        
        anchorPane4.getChildren().add(SaveButtonid);
        anchorPane4.getChildren().add(imageView0);
        getChildren().add(anchorPane4);
        anchorPane5.getChildren().add(PlayAgainButtonid);
        anchorPane5.getChildren().add(imageView1);
        getChildren().add(anchorPane5);
        getChildren().add(GameResultId);

    }

    protected abstract void BackButton(javafx.event.ActionEvent actionEvent);

    protected abstract void SaveButton(javafx.event.ActionEvent actionEvent);

    protected abstract void PlayAgainButton(javafx.event.ActionEvent actionEvent);

}
