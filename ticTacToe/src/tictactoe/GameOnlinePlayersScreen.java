/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
/**
 *
 * @author Esraa
 */
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameOnlinePlayersScreen extends AnchorPane {
    
    protected final AnchorPane anchorPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button b3;
    protected final Button b6;
    protected final Button b2;
    protected final Button b1;
    protected final Button b5;
    protected final Button b8;
    protected final Button b9;
    protected final Button b4;
    protected final Button b7;
    protected final Button PlayAgainButtonid;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;
    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final Label playerXresult;
    protected final AnchorPane anchorPane2;
    protected final AnchorPane anchorPane3;
    protected final ImageView imageView0;
    protected final Label label1;
    protected final Label label2;
    protected final Label computerYResult;
    protected final AnchorPane anchorPane4;
    protected final Button button;
    protected final ImageView imageView1;
    protected final Label GameResultId;
    protected final Button SaveButtonid;
    protected final ImageView savImageIcon;
    protected final AnchorPane saveAchorPane;
    protected final ImageView playAgainIcon;
      
    protected final AnchorPane anchorPanePlayAgain;
  
    public GameOnlinePlayersScreen(Stage stage) {
        
        
        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        GameResultId = new Label();
        GameResultId.setVisible(false);
       
        b3 = new Button();
        b6 = new Button();
        b2 = new Button();
        b1 = new Button();
        b5 = new Button();
        b8 = new Button();
        b9 = new Button();
        b4 = new Button();
        b7 = new Button(); 
        savImageIcon = new ImageView();
        SaveButtonid = new Button();
        saveAchorPane = new AnchorPane();
        saveAchorPane.setVisible(false);
        
        SaveButtonid.setMnemonicParsing(false);
        SaveButtonid.setPrefHeight(75.0);
        SaveButtonid.setPrefWidth(195.0);
        SaveButtonid.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        SaveButtonid.setText("       Save");
        SaveButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        SaveButtonid.setFont(new Font("Berlin Sans FB", 33.0));
        SaveButtonid.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                  }
        });
        SaveButtonid.setOnMouseEntered((event) -> {
            stage.getScene().setCursor(Cursor.HAND);
        });
       
       savImageIcon.setFitHeight(40.0);
       savImageIcon.setFitWidth(48.0);
       savImageIcon.setLayoutX(16.0);
       savImageIcon.setLayoutY(16.0);
       savImageIcon.setOpacity(0.47);
       savImageIcon.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/Save.png")));

        anchorPanePlayAgain = new AnchorPane();
        anchorPanePlayAgain.setLayoutX(378.0);
        anchorPanePlayAgain.setLayoutY(300.0);
        anchorPanePlayAgain.setPrefHeight(75.0);
        anchorPanePlayAgain.setPrefWidth(259.0);
        anchorPanePlayAgain.setVisible(false);
        
        saveAchorPane.setLayoutX(779.0);
        saveAchorPane.setLayoutY(500.0);
        
        PlayAgainButtonid = new Button();
        playAgainIcon = new ImageView();
        playAgainIcon.setFitHeight(54.0);
        playAgainIcon.setFitWidth(62.0);
        playAgainIcon.setLayoutX(13.0);
        playAgainIcon.setLayoutY(11.0);
        playAgainIcon.setOpacity(0.47);
        playAgainIcon.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/refresh.png")));
       
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        playerXresult = new Label();
        anchorPane2 = new AnchorPane();
        anchorPane3 = new AnchorPane();
        imageView0 = new ImageView();
        label1 = new Label();
        label2 = new Label();
        computerYResult = new Label();
        anchorPane4 = new AnchorPane();
        button = new Button();
        imageView1 = new ImageView();
      
        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072A40;");

        anchorPane.setLayoutX(277.0);
        anchorPane.setLayoutY(101.0);
        anchorPane.setPrefHeight(375.0);
        anchorPane.setPrefWidth(463.0);

        gridPane.setHgap(10.0);
        gridPane.setPrefHeight(375.0);
        gridPane.setPrefWidth(458.0);
        gridPane.setVgap(10.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(b3, 2);
        
        b3.setMnemonicParsing(false);
        b3.setPrefHeight(95.0);
        b3.setPrefWidth(133.0);
        b3.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b3.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b3.setFont(new Font("Berlin Sans FB", 42.0));
        b3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        GridPane.setColumnIndex(b6, 2);
        GridPane.setRowIndex(b6, 1);
        b6.setMnemonicParsing(false);
        b6.setPrefHeight(95.0);
        b6.setPrefWidth(133.0);
        b6.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b6.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b6.setFont(new Font("Berlin Sans FB", 42.0));
        b6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        GridPane.setColumnIndex(b2, 1);
        b2.setMnemonicParsing(false);
        b2.setPrefHeight(95.0);
        b2.setPrefWidth(133.0);
        b2.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b2.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b2.setFont(new Font("Berlin Sans FB", 42.0));
        b2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        b1.setMnemonicParsing(false);
        b1.setPrefHeight(95.0);
        b1.setPrefWidth(133.0);
        b1.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b1.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b1.setFont(new Font("Berlin Sans FB", 42.0));
        b1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           
        });
        
        GridPane.setColumnIndex(b5, 1);
        GridPane.setRowIndex(b5, 1);
        b5.setMnemonicParsing(false);
        b5.setPrefHeight(95.0);
        b5.setPrefWidth(133.0);
        b5.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b5.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b5.setFont(new Font("Berlin Sans FB", 42.0));
        b5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        GridPane.setColumnIndex(b8, 1);
        GridPane.setRowIndex(b8, 2);
        b8.setMnemonicParsing(false);
        b8.setPrefHeight(95.0);
        b8.setPrefWidth(133.0);
        b8.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b8.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b8.setFont(new Font("Berlin Sans FB", 42.0));
        b8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        GridPane.setColumnIndex(b9, 2);
        GridPane.setRowIndex(b9, 2);
        b9.setMnemonicParsing(false);
        b9.setPrefHeight(95.0);
        b9.setPrefWidth(133.0);
        b9.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b9.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b9.setFont(new Font("Berlin Sans FB", 42.0));
        b9.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        GridPane.setRowIndex(b4, 1);
        b4.setMnemonicParsing(false);
        b4.setPrefHeight(95.0);
        b4.setPrefWidth(133.0);
        b4.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b4.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b4.setFont(new Font("Berlin Sans FB", 42.0));
        b4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            
        });
        
        GridPane.setRowIndex(b7, 2);
        b7.setMnemonicParsing(false);
        b7.setPrefHeight(95.0);
        b7.setPrefWidth(133.0);
        b7.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b7.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        b7.setFont(new Font("Berlin Sans FB", 42.0));
        b7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
          
        });
        
        AnchorPane.setBottomAnchor(PlayAgainButtonid, 0.0);
        AnchorPane.setLeftAnchor(PlayAgainButtonid, 0.0);
        AnchorPane.setRightAnchor(PlayAgainButtonid, 0.0);
        AnchorPane.setTopAnchor(PlayAgainButtonid, 0.0);
        PlayAgainButtonid.setMnemonicParsing(false);
        PlayAgainButtonid.setPrefHeight(75.0);
        PlayAgainButtonid.setPrefWidth(216.0);
        PlayAgainButtonid.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        PlayAgainButtonid.setText("       Play Again");
        PlayAgainButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        PlayAgainButtonid.setFont(new Font("Berlin Sans FB", 33.0));
        PlayAgainButtonid.addEventHandler(ActionEvent.ACTION ,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                 }
        });
        PlayAgainButtonid.setOnMouseEntered((event) -> {
            stage.getScene().setCursor(Cursor.HAND);
        });
        gridPane.setPadding(new Insets(10.0, 0.0, 10.0, 10.0));

        anchorPane0.setLayoutX(49.0);
        anchorPane0.setLayoutY(101.0);

        imageView.setFitHeight(142.0);
        imageView.setFitWidth(154.0);
        imageView.setLayoutX(9.0);
        imageView.setLayoutY(94.0);
        imageView.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play1.png")));
       
        label.setLayoutX(144.0);
        label.setLayoutY(222.0);
        label.setText("X");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        label.setFont(new Font("Berlin Sans FB", 68.0));
        
        label0.setLayoutX(5.0);
        label0.setPrefHeight(75.0);
        label0.setPrefWidth(193.0);
        label0.setText("You");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label0.setFont(new Font("Berlin Sans FB", 36.0));

        playerXresult.setLayoutX(32.0);
        playerXresult.setLayoutY(297.0);
        playerXresult.setPrefHeight(54.0);
        playerXresult.setPrefWidth(109.0);
        playerXresult.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerXresult.setFont(new Font("Berlin Sans FB", 24.0));

        
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
        GameResultId.setFont(new Font("Berlin Sans FB", 24.0));
        
        anchorPane2.setLayoutX(763.0);
        anchorPane2.setLayoutY(104.0);

        anchorPane3.setPrefHeight(305.0);
        anchorPane3.setPrefWidth(196.0);

        imageView0.setFitHeight(142.0);
        imageView0.setFitWidth(154.0);
        imageView0.setLayoutX(9.0);
        imageView0.setLayoutY(94.0);
        imageView0.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        imageView0.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play1.png")));

        label1.setLayoutX(144.0);
        label1.setLayoutY(222.0);
        label1.setText("O");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label1.setFont(new Font("Berlin Sans FB", 68.0));

        label2.setLayoutX(3.0);
        label2.setPrefHeight(64.0);
        label2.setPrefWidth(193.0);
        label2.setText("Computer");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label2.setFont(new Font("Berlin Sans FB", 36.0));

        computerYResult.setLayoutX(44.0);
        computerYResult.setLayoutY(294.0);
        computerYResult.setPrefHeight(54.0);
        computerYResult.setPrefWidth(109.0);
        computerYResult.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        computerYResult.setFont(new Font("Berlin Sans FB", 24.0));

        anchorPane4.setLayoutX(29.0);
        anchorPane4.setLayoutY(501.0);

        button.setMnemonicParsing(false);
        button.setPrefHeight(75.0);
        button.setPrefWidth(185.0);
        button.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        button.setText("       Back");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        button.setFont(new Font("Berlin Sans FB", 33.0));
        button.addEventHandler(ActionEvent.ACTION ,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Parent root = new HomeScreen(stage);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                 }
        });
        imageView1.setFitHeight(50.0);
        imageView1.setFitWidth(52.0);
        imageView1.setLayoutX(16.0);
        imageView1.setLayoutY(11.0);
        imageView1.setOpacity(0.47);
        imageView1.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(b3);
        gridPane.getChildren().add(b6);
        gridPane.getChildren().add(b2);
        gridPane.getChildren().add(b1);
        gridPane.getChildren().add(b5);
        gridPane.getChildren().add(b8);
        gridPane.getChildren().add(b9);
        gridPane.getChildren().add(b4);
        gridPane.getChildren().add(b7);
        anchorPane.getChildren().add(gridPane);
        getChildren().add(anchorPane);
        anchorPane1.getChildren().add(imageView);
        anchorPane1.getChildren().add(label);
        anchorPane1.getChildren().add(label0);
        anchorPane0.getChildren().add(anchorPane1);
        anchorPane0.getChildren().add(playerXresult);
        getChildren().add(anchorPane0);
        anchorPane3.getChildren().add(imageView0);
        anchorPane3.getChildren().add(label1);
        anchorPane3.getChildren().add(label2);
        anchorPane2.getChildren().add(anchorPane3);
        anchorPane2.getChildren().add(computerYResult);
        getChildren().add(anchorPane2);
        anchorPane4.getChildren().add(button);
        anchorPane4.getChildren().add(imageView1);
        getChildren().add(anchorPane4);
        anchorPanePlayAgain.getChildren().add(PlayAgainButtonid);
        anchorPanePlayAgain.getChildren().add(playAgainIcon);
        getChildren().add(anchorPanePlayAgain);   
        getChildren().add(GameResultId);
        
        saveAchorPane.getChildren().add(SaveButtonid);
        saveAchorPane.getChildren().add(savImageIcon);
        getChildren().add(saveAchorPane);

    }
}
