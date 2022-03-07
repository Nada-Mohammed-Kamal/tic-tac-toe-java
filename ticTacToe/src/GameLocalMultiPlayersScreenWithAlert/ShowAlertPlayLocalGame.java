package GameLocalMultiPlayersScreenWithAlert;

import GameLocalMultiPlayersScreenWithAlert.GameLocalMultiPlayersScreenBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.Navigation;

public class ShowAlertPlayLocalGame extends AnchorPane {

    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final TextField player1Name;
    protected final Label label0;
    protected final Label label1;
    protected final TextField player2Name;
    public final Button Start;

    public ShowAlertPlayLocalGame(Stage myStage,Stage alertStage) {

        label = new Label();
        anchorPane = new AnchorPane();
        player1Name = new TextField();
        label0 = new Label();
        label1 = new Label();
        player2Name = new TextField();
        Start = new Button();

        setId("AnchorPane");
        setPrefHeight(270.0);
        setPrefWidth(443.0);

        AnchorPane.setLeftAnchor(label, 8.0);
        AnchorPane.setRightAnchor(label, 8.0);
        AnchorPane.setTopAnchor(label, 8.0);
        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(566.0);
        label.setText("Paly local game");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#aaaaaa"));
        label.setFont(new Font("Berlin Sans FB Demi Bold", 29.0));

        AnchorPane.setBottomAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 0.0);
        AnchorPane.setRightAnchor(anchorPane, 0.0);
        AnchorPane.setTopAnchor(anchorPane, 50.0);
        anchorPane.setLayoutX(-6.0);
        anchorPane.setLayoutY(48.0);
        anchorPane.setPrefHeight(215.0);
        anchorPane.setPrefWidth(600.0);
        anchorPane.setStyle("-fx-background-color: #AAAAAA");

        player1Name.setLayoutX(100.0);
        player1Name.setLayoutY(55.0);
        player1Name.setPrefHeight(26.0);
        player1Name.setPrefWidth(285.0);

        label0.setLayoutX(14.0);
        label0.setLayoutY(53.0);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(99.0);
        label0.setText("Palyer1: ");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 20.0));

        label1.setLayoutX(14.0);
        label1.setLayoutY(119.0);
        label1.setPrefHeight(30.0);
        label1.setPrefWidth(99.0);
        label1.setText("Palyer2: ");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 20.0));

        player2Name.setLayoutX(100.0);
        player2Name.setLayoutY(121.0);
        player2Name.setPrefHeight(26.0);
        player2Name.setPrefWidth(285.0);

        Start.setLayoutX(270.0);
        Start.setLayoutY(177.0);
        Start.setMnemonicParsing(false);
        Start.setPrefHeight(40.0);
        Start.setPrefWidth(150.0);
        Start.setStyle("-fx-background-color: #1FA4E5;");
        Start.setText("Start");
        Start.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Start.setTextFill(javafx.scene.paint.Color.WHITE);
        Start.setFont(new Font("Arial Bold", 20.0));
        Start.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alertStage.close();
                PlayersNames playersNames = new PlayersNames(player1Name.getText(),player2Name.getText());
                System.out.println("In Alert : "+ playersNames.getPlayer1() + "   "+ playersNames.getPlayer2());
                Navigation.navigateTo(myStage, new GameLocalMultiPlayersScreenBase(myStage,playersNames), "Local Game");
                }
        });
        getChildren().add(label);
        anchorPane.getChildren().add(player1Name);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(player2Name);
        anchorPane.getChildren().add(Start);
        getChildren().add(anchorPane);

    }
}
