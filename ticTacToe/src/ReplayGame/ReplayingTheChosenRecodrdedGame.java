package ReplayGame;

import ReplayGame.ReplayGameService;
import ReplayGame.RecordedScreen;
import GameLocalMultiPlayersScreenWithAlert.GameLocalMultiPlayersScreenBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import Navigation.Navigation;

public class ReplayingTheChosenRecodrdedGame extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button3id;
    protected final Button button6id;
    protected final Button button2id;
    protected final Button button1id;
    protected final Button button5id;
    protected final Button button8id;
    protected final Button button9id;
    protected final Button button4id;
    protected final Button button7id;
    protected final AnchorPane anchorPane0;
    protected final AnchorPane anchorPane1;
    protected final ImageView player1img;
    protected final Label label;
    protected final Label player1name;
    protected final Label player1result;
    protected final AnchorPane anchorPane2;
    protected final AnchorPane anchorPane3;
    protected final ImageView player2img;
    protected final Label label0;
    protected final Label player2name;
    protected final Label player2result;
    protected final AnchorPane anchorPane4;
    protected final Button backButtonId;
    protected final ImageView imageView;
    ReplayGameService service;

    public ReplayingTheChosenRecodrdedGame(String filename,Stage stage) {
        service = new ReplayGameService(filename);
        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button3id = new Button();
        button6id = new Button();
        button2id = new Button();
        button1id = new Button();
        button5id = new Button();
        button8id = new Button();
        button9id = new Button();
        button4id = new Button();
        button7id = new Button();
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        player1img = new ImageView();
        label = new Label();
        player1name = new Label();
        player1result = new Label();
        anchorPane2 = new AnchorPane();
        anchorPane3 = new AnchorPane();
        player2img = new ImageView();
        label0 = new Label();
        player2name = new Label();
        player2result = new Label();
        anchorPane4 = new AnchorPane();
        backButtonId = new Button();
        imageView = new ImageView();

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

        GridPane.setColumnIndex(button3id, 2);
        button3id.setMnemonicParsing(false);
        button3id.setPrefHeight(95.0);
        button3id.setPrefWidth(133.0);
        button3id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button3id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button3id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setColumnIndex(button6id, 2);
        GridPane.setRowIndex(button6id, 1);
        button6id.setMnemonicParsing(false);
        button6id.setPrefHeight(95.0);
        button6id.setPrefWidth(133.0);
        button6id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button6id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button6id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setColumnIndex(button2id, 1);
        button2id.setMnemonicParsing(false);
        button2id.setPrefHeight(95.0);
        button2id.setPrefWidth(133.0);
        button2id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button2id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button2id.setFont(new Font("Berlin Sans FB", 42.0));

        button1id.setMnemonicParsing(false);
        button1id.setPrefHeight(95.0);
        button1id.setPrefWidth(133.0);
        button1id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button1id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button1id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setColumnIndex(button5id, 1);
        GridPane.setRowIndex(button5id, 1);
        button5id.setMnemonicParsing(false);
        button5id.setPrefHeight(95.0);
        button5id.setPrefWidth(133.0);
        button5id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button5id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button5id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setColumnIndex(button8id, 1);
        GridPane.setRowIndex(button8id, 2);
        button8id.setMnemonicParsing(false);
        button8id.setPrefHeight(95.0);
        button8id.setPrefWidth(133.0);
        button8id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button8id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button8id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setColumnIndex(button9id, 2);
        GridPane.setRowIndex(button9id, 2);
        button9id.setMnemonicParsing(false);
        button9id.setPrefHeight(95.0);
        button9id.setPrefWidth(133.0);
        button9id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button9id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button9id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setRowIndex(button4id, 1);
        button4id.setMnemonicParsing(false);
        button4id.setPrefHeight(95.0);
        button4id.setPrefWidth(133.0);
        button4id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button4id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button4id.setFont(new Font("Berlin Sans FB", 42.0));

        GridPane.setRowIndex(button7id, 2);
        button7id.setMnemonicParsing(false);
        button7id.setPrefHeight(95.0);
        button7id.setPrefWidth(133.0);
        button7id.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        button7id.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        button7id.setFont(new Font("Berlin Sans FB", 42.0));
        gridPane.setPadding(new Insets(10.0, 0.0, 10.0, 10.0));

        anchorPane0.setLayoutX(49.0);
        anchorPane0.setLayoutY(101.0);

        player1img.setFitHeight(142.0);
        player1img.setFitWidth(154.0);
        player1img.setLayoutX(9.0);
        player1img.setLayoutY(94.0);
        player1img.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        player1img.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play1.png")));

        label.setLayoutX(144.0);
        label.setLayoutY(222.0);
        label.setText("X");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label.setFont(new Font("Berlin Sans FB", 68.0));

        player1name.setLayoutX(5.0);
        player1name.setPrefHeight(75.0);
        player1name.setPrefWidth(193.0);
        player1name.setText("player1");
        player1name.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player1name.setFont(new Font("Berlin Sans FB", 36.0));

        player1result.setLayoutX(32.0);
        player1result.setLayoutY(297.0);
        player1result.setPrefHeight(54.0);
        player1result.setPrefWidth(109.0);
        player1result.setText("result1");
        player1result.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player1result.setFont(new Font("Berlin Sans FB", 36.0));

        anchorPane2.setLayoutX(763.0);
        anchorPane2.setLayoutY(104.0);

        anchorPane3.setPrefHeight(305.0);
        anchorPane3.setPrefWidth(196.0);

        player2img.setFitHeight(142.0);
        player2img.setFitWidth(154.0);
        player2img.setLayoutX(9.0);
        player2img.setLayoutY(94.0);
        player2img.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        player2img.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play2.png")));

        label0.setLayoutX(144.0);
        label0.setLayoutY(222.0);
        label0.setText("O");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        label0.setFont(new Font("Berlin Sans FB", 68.0));

        player2name.setLayoutX(3.0);
        player2name.setPrefHeight(64.0);
        player2name.setPrefWidth(193.0);
        player2name.setText("player2");
        player2name.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player2name.setFont(new Font("Berlin Sans FB", 36.0));

        player2result.setLayoutX(44.0);
        player2result.setLayoutY(294.0);
        player2result.setPrefHeight(54.0);
        player2result.setPrefWidth(109.0);
        player2result.setText("result2");
        player2result.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player2result.setFont(new Font("Berlin Sans FB", 36.0));

        anchorPane4.setLayoutX(29.0);
        anchorPane4.setLayoutY(501.0);

        backButtonId.setMnemonicParsing(false);
        backButtonId.setPrefHeight(75.0);
        backButtonId.setPrefWidth(185.0);
        backButtonId.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        backButtonId.setText("       Back");
        backButtonId.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        backButtonId.setFont(new Font("Berlin Sans FB", 33.0));
        backButtonId.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.navigateTo(stage, new RecordedScreen(stage), "Recorded screen");
            }
        });        
        imageView.setFitHeight(50.0);
        imageView.setFitWidth(52.0);
        imageView.setLayoutX(16.0);
        imageView.setLayoutY(11.0);
        imageView.setOpacity(0.47);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));
        
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button3id);
        gridPane.getChildren().add(button6id);
        gridPane.getChildren().add(button2id);
        gridPane.getChildren().add(button1id);
        gridPane.getChildren().add(button5id);
        gridPane.getChildren().add(button8id);
        gridPane.getChildren().add(button9id);
        gridPane.getChildren().add(button4id);
        gridPane.getChildren().add(button7id);
        anchorPane.getChildren().add(gridPane);
        getChildren().add(anchorPane);
        anchorPane1.getChildren().add(player1img);
        anchorPane1.getChildren().add(label);
        anchorPane1.getChildren().add(player1name);
        anchorPane0.getChildren().add(anchorPane1);
        anchorPane0.getChildren().add(player1result);
        getChildren().add(anchorPane0);
        anchorPane3.getChildren().add(player2img);
        anchorPane3.getChildren().add(label0);
        anchorPane3.getChildren().add(player2name);
        anchorPane2.getChildren().add(anchorPane3);
        anchorPane2.getChildren().add(player2result);
        getChildren().add(anchorPane2);
        anchorPane4.getChildren().add(backButtonId);
        anchorPane4.getChildren().add(imageView);
        getChildren().add(anchorPane4);
        service.viewFileData();
        player1name.setText(service.nameOfPlayerOneRecorder);
        player2name.setText(service.nameOfPlayerTwoRecorder);
        player1result.setVisible(false);
        player2result.setVisible(false);
        replayTheMoves(service.playersRecorderMoves);
    }
    
    void replayTheMoves(ArrayList<Integer> PlayersMoves){
        String symbol1 = "X";
        String symbol2 = "O";
        int currentPlayerNumber = 1;
        Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run(){
            int currentPlayerNumber = 1;
                for(int i = 0 ; i < service.playersRecorderMoves.size() ; i++)
                {
                  
                  try {
                    Thread.sleep(1000);
                    if(currentPlayerNumber == 1)
                    {
                        switch (PlayersMoves.get(i)){
                            case 1:
                               Platform.runLater(()->button1id.setText(symbol1));
                               Platform.runLater(()->button1id.setDisable(true));
                               break;
                            case 2:
                               Platform.runLater(()->button2id.setText(symbol1));
                               Platform.runLater(()->button2id.setDisable(true));
                               break;
                            case 3:
                               Platform.runLater(()->button3id.setText(symbol1));
                               Platform.runLater(()->button3id.setDisable(true));
                               break;
                            case 4:
                               Platform.runLater(()->button4id.setText(symbol1)); 
                               Platform.runLater(()->button4id.setDisable(true));
                               break;
                            case 5:
                               Platform.runLater(()->button5id.setText(symbol1));
                               Platform.runLater(()->button5id.setDisable(true));
                               break;
                            case 6:
                               Platform.runLater(()->button6id.setText(symbol1));
                               Platform.runLater(()->button6id.setDisable(true));
                               break;
                            case 7:
                               Platform.runLater(()->button7id.setText(symbol1));
                               Platform.runLater(()->button7id.setDisable(true));
                               break;
                            case 8:
                               Platform.runLater(()->button8id.setText(symbol1));
                               Platform.runLater(()->button8id.setDisable(true));
                               break;
                            case 9:
                               Platform.runLater(()->button9id.setText(symbol1));
                               Platform.runLater(()->button9id.setDisable(true));
                               break;
                        }
                        //System.out.println("name of player" + player1 + " index(button number) " + PlayersMoves.get(i) + " : " + symbol1);
                        currentPlayerNumber = 2;
                    }else{
                        switch (PlayersMoves.get(i)){
                            case 1:
                               Platform.runLater(()->button1id.setText(symbol2));
                               Platform.runLater(()->button1id.setDisable(true));
                               break;
                            case 2:
                               Platform.runLater(()->button2id.setText(symbol2));
                               Platform.runLater(()->button2id.setDisable(true));
                               break;
                            case 3:
                               Platform.runLater(()->button3id.setText(symbol2));
                               Platform.runLater(()->button3id.setDisable(true));
                               break;
                            case 4:
                               Platform.runLater(()->button4id.setText(symbol2));
                               Platform.runLater(()->button4id.setDisable(true));
                               break;
                            case 5:
                               Platform.runLater(()->button5id.setText(symbol2));
                               Platform.runLater(()->button5id.setDisable(true));
                               break;
                            case 6:
                               Platform.runLater(()->button6id.setText(symbol2));
                               Platform.runLater(()->button6id.setDisable(true));
                               break;
                            case 7:
                               Platform.runLater(()->button7id.setText(symbol2));
                               Platform.runLater(()->button7id.setDisable(true));
                               break;
                            case 8:
                               Platform.runLater(()->button8id.setText(symbol2));
                               Platform.runLater(()->button8id.setDisable(true));
                               break;
                            case 9:
                               Platform.runLater(()->button9id.setText(symbol2));
                               Platform.runLater(()->button9id.setDisable(true));
                               break;
                        }
                        //System.out.println("name of player" + player2 + " index(button number) " + PlayersMoves.get(i) + " : " + symbol2);
                        currentPlayerNumber = 1;
                    }
                    }catch (Exception ex) {
                        Logger.getLogger(GameLocalMultiPlayersScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread1.start();
    }

    
}
