package utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DBConnectionErrorDialog extends AnchorPane {

    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final Label YourMessage;
    protected final Button Accept;
    public static boolean flag;
    public DBConnectionErrorDialog(Stage window,String messege) {

      label = new Label();
        anchorPane = new AnchorPane();
        YourMessage = new Label();
        Accept = new Button();

        setId("AnchorPane");
        setPrefHeight(213.0);
        setPrefWidth(309.0);
        setStyle("-fx-background-radius: 0 0 20 20; -fx-border-radius: 0 0 20 20;");

        AnchorPane.setLeftAnchor(label, 8.0);
        AnchorPane.setRightAnchor(label, 8.0);
        AnchorPane.setTopAnchor(label, 8.0);
        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(566.0);
        label.setText("Erorr!!");
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
        anchorPane.setStyle("-fx-background-color: #AAAAAA;");

        AnchorPane.setLeftAnchor(YourMessage, 16.0);
        YourMessage.setLayoutX(16.0);
        YourMessage.setLayoutY(24.0);
        YourMessage.setPrefHeight(30.0);
        YourMessage.setPrefWidth(277.0);
        YourMessage.setStyle("-fx-alignment: center;");
        YourMessage.setText(messege);
        YourMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        YourMessage.setTextFill(javafx.scene.paint.Color.WHITE);
        YourMessage.setFont(new Font("System Bold", 15.0));

        AnchorPane.setBottomAnchor(Accept, 16.0);
        AnchorPane.setLeftAnchor(Accept, 16.0);
        Accept.setLayoutX(16.0);
        Accept.setLayoutY(114.0);
        Accept.setMnemonicParsing(false);
        Accept.setPrefHeight(34.0);
        Accept.setPrefWidth(99.0);
        Accept.setStyle("-fx-background-color: #1FA4E5;");
        Accept.setText("Close..");
        Accept.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Accept.setTextFill(javafx.scene.paint.Color.WHITE);
        Accept.setFont(new Font("Arial Bold", 20.0));
        Accept.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                flag = true;
                window.close(); 
            }
        });
        getChildren().add(label);
        anchorPane.getChildren().add(YourMessage);
        anchorPane.getChildren().add(Accept);
        getChildren().add(anchorPane);

    }
}
