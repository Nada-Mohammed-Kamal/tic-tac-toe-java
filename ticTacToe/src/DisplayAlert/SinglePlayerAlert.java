package DisplayAlert;

import CursorHANDWhenMoveToIntoButton.CursorHANDWhenMoveToIntoButton;
import PersonVSBootLevels.EasyLevelScreen;
import PersonVSBootLevels.HardLevelScreen;
import PersonVSBootLevels.MediumLevelScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.Navigation;

public class SinglePlayerAlert extends AnchorPane {

    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final TextField player1Name;
    protected final Label label0;
    protected final Button Start;

    public SinglePlayerAlert(Stage myStage,Stage alertStage,String whichLevel) {

        label = new Label();
        anchorPane = new AnchorPane();
        player1Name = new TextField();
        label0 = new Label();
        Start = new Button();

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
        label.setText("Play local game");
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

        AnchorPane.setLeftAnchor(player1Name, 16.0);
        AnchorPane.setRightAnchor(player1Name, 16.0);
        player1Name.setLayoutX(14.0);
        player1Name.setLayoutY(68.0);
        player1Name.setPrefHeight(26.0);
        player1Name.setPrefWidth(284.0);

        AnchorPane.setLeftAnchor(label0, 16.0);
        label0.setLayoutX(14.0);
        label0.setLayoutY(38.0);
        label0.setPrefHeight(30.0);
        label0.setPrefWidth(129.0);
        label0.setText("Your name :");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 20.0));
        
        Start.setLayoutX(195.0);
        Start.setLayoutY(112.0);
        Start.setMnemonicParsing(false);
        Start.setPrefHeight(10.0);
        Start.setPrefWidth(99.0);
        Start.setStyle("-fx-background-color: #1FA4E5;");
        Start.setText("Start");
        Start.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Start.setTextFill(javafx.scene.paint.Color.WHITE);
        Start.setFont(new Font("Arial Bold", 20.0));
        Start.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                alertStage.close();
                System.out.println("In Alert : "+ player1Name.getText());
                //easy .. medium .. hard
                if(whichLevel.equals("medium"))
                   Navigation.navigateTo(myStage, new MediumLevelScreen(myStage,player1Name.getText()), "Local Game Medim");
                else if(whichLevel.equals("easy"))
                    Navigation.navigateTo(myStage, new EasyLevelScreen(myStage,player1Name.getText()), "Local Game Easy");
                else if(whichLevel.equals("hard"))
                    Navigation.navigateTo(myStage, new HardLevelScreen(myStage,player1Name.getText()), "Local Game Hard");
            }
        });
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(Start, alertStage);
        getChildren().add(label);
        anchorPane.getChildren().add(player1Name);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(Start);
        getChildren().add(anchorPane);

    }
}
