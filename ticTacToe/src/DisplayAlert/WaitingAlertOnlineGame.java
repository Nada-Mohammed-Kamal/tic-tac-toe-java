package DisplayAlert;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class WaitingAlertOnlineGame extends AnchorPane {

    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final Label YourMessage;

    public WaitingAlertOnlineGame(String msg) {

        label = new Label();
        anchorPane = new AnchorPane();
        YourMessage = new Label();

        setId("AnchorPane");
        setPrefHeight(130.0);
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
        anchorPane.setPrefHeight(105.0);
        anchorPane.setPrefWidth(309.0);
        anchorPane.setStyle("-fx-background-color: #AAAAAA;");

        AnchorPane.setLeftAnchor(YourMessage, 9.0);
        YourMessage.setLayoutX(9.0);
        YourMessage.setLayoutY(24.0);
        YourMessage.setLineSpacing(1.0);
        YourMessage.setPrefHeight(50.0);
        YourMessage.setPrefWidth(293.0);
        YourMessage.setWrapText(true);
        YourMessage.setStyle("-fx-alignment: center;");
        YourMessage.setText(msg);
        YourMessage.setTextFill(javafx.scene.paint.Color.WHITE);
        YourMessage.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        YourMessage.setWrapText(true);
        YourMessage.setFont(new Font("System Bold", 15.0));

        getChildren().add(label);
        anchorPane.getChildren().add(YourMessage);
        getChildren().add(anchorPane);

    }
}
