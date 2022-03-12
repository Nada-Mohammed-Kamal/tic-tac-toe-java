package DisplayAlert;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InformationAlert extends AnchorPane {

    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final Label YourMessage;
    protected final Button Reject;

    public InformationAlert(Stage window,String message) {

        label = new Label();
        anchorPane = new AnchorPane();
        YourMessage = new Label();
        Reject = new Button();

        setId("AnchorPane");
        setPrefHeight(165.0);
        setPrefWidth(309.0);
        setStyle("-fx-background-radius: 0 0 20 20; -fx-border-radius: 0 0 20 20;");

        AnchorPane.setLeftAnchor(label, 8.0);
        AnchorPane.setRightAnchor(label, 8.0);
        AnchorPane.setTopAnchor(label, 8.0);
        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(30.0);
        label.setPrefWidth(566.0);
        label.setText("Play online game");
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
        YourMessage.setPrefHeight(60.0);
        YourMessage.setPrefWidth(277.0);
        YourMessage.setStyle("-fx-alignment: center;");
        YourMessage.setWrapText(true);
        YourMessage.setText(message);
        YourMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        YourMessage.setTextFill(javafx.scene.paint.Color.WHITE);
        YourMessage.setFont(new Font("System Bold", 15.0));
        YourMessage.setMaxHeight(USE_COMPUTED_SIZE);
        
        AnchorPane.setBottomAnchor(Reject, 8.0);
        AnchorPane.setRightAnchor(Reject, 8.0);
        Reject.setLayoutX(209.0);
        Reject.setLayoutY(70.0);
        Reject.setMnemonicParsing(false);
        Reject.setPrefHeight(20.0);
        Reject.setPrefWidth(100.0);
        Reject.setStyle("-fx-background-color: #1FA4E5;");
        Reject.setText("OK");
        Reject.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Reject.setTextFill(javafx.scene.paint.Color.WHITE);
        Reject.setFont(new Font("Arial Bold", 18.0));
        Reject.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });
        getChildren().add(label);
        anchorPane.getChildren().add(YourMessage);
        anchorPane.getChildren().add(Reject);
        getChildren().add(anchorPane);

    }
}
