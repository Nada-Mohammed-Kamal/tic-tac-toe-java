package GameLocalMultiPlayersScreenWithAlert;
import DisplayAlert.PlayersNames;
import CursorHANDWhenMoveToIntoButton.CursorHANDWhenMoveToIntoButton;
import SaveGame.SaveGame;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
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
import tictactoe.HomeScreen;
import tictactoe.Navigation;
import tictactoe.PlayVideo;
public class GameLocalMultiPlayersScreenBase extends AnchorPane {
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
    protected final Button PlayAgainButtonid;
    protected final Label GameResultId;
    protected final Button SaveButtonid;
    protected final ImageView savImageIcon;
    protected final AnchorPane saveAchorPane;
    protected final ImageView playAgainIcon;    
    protected final AnchorPane anchorPanePlayAgain;
    String playerOneName = "";
    String playerTwoName = "";
    List<List> allWinningLists;
    String winnerName;
    ArrayList<Integer> player1Moves = new ArrayList<>();
    ArrayList<Integer> player2Moves = new ArrayList<>();
    public boolean player1Turn = true;
    public String symbol;
    int numberOfTheButtonClicked;
    int playingCount = 0;
    int playerOneNumberOfWins = 0;
    int playerTwoNumberOfWins = 0;
    int playerOneResult = 0;
    int playerTwoResult = 0;
    Vector<Integer> vc;
    int numberofGameMovesInTheGame;
    ArrayList<Integer> playersRecorderMoves;
    int arr1Index;
    int arr2Index;
    String movesAsAString;
    String nameOfPlayer1;
    String nameOfPlayer2;
    String readedTextFromFile;
    String PlayernamesFromDataReturned;
    String getSubStringForNames = "";
    String nameOfPlayerOneRecorder = "";
    String nameOfPlayerTwoRecorder = "";
    public GameLocalMultiPlayersScreenBase(Stage stage,PlayersNames names) {
        System.out.println("In Game : "+ names.getPlayer1() + "   "+ names.getPlayer2());
                
        playerOneName = names.getPlayer1();
        playerTwoName = names.getPlayer2();
        allWinningLists = new ArrayList<>();
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftcol = Arrays.asList(1,4,7);
        List midcol = Arrays.asList(2,5,8);
        List rightcol = Arrays.asList(3,6,9);
        List diagonalOne = Arrays.asList(1,5,9);
        List diagonalTwo = Arrays.asList(3,5,7);
        allWinningLists.add(topRow);
        allWinningLists.add(midRow);
        allWinningLists.add(bottomRow);
        allWinningLists.add(leftcol);
        allWinningLists.add(midcol);
        allWinningLists.add(rightcol);
        allWinningLists.add(diagonalOne);
        allWinningLists.add(diagonalTwo);
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
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(backButtonId, stage);
        imageView = new ImageView();
        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072A40;");
//        dialogWithTwoTextBoxes();
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
        player1name.setText(playerOneName);
        player1name.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player1name.setFont(new Font("Berlin Sans FB", 36.0));
        player1result.setLayoutX(32.0);
        player1result.setLayoutY(297.0);
        player1result.setPrefHeight(54.0);
        player1result.setPrefWidth(109.0);
        player1result.setText(Integer.toString(playerOneNumberOfWins));
        player1result.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player1result.setFont(new Font("Berlin Sans FB", 50.0));
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
        player2name.setPrefWidth(210.0);
        player2name.setText(playerTwoName);
        player2name.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player2name.setFont(new Font("Berlin Sans FB", 36.0));
        player2result.setLayoutX(44.0);
        player2result.setLayoutY(294.0);
        player2result.setPrefHeight(54.0);
        player2result.setPrefWidth(109.0);
        player2result.setText(Integer.toString(playerTwoNumberOfWins));
        player2result.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        player2result.setFont(new Font("Berlin Sans FB", 50.0));
        anchorPane4.setLayoutX(29.0);
        anchorPane4.setLayoutY(501.0);
        backButtonId.setMnemonicParsing(false);
        backButtonId.setPrefHeight(75.0);
        backButtonId.setPrefWidth(185.0);
        backButtonId.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        backButtonId.setText("       Back");
        backButtonId.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        backButtonId.setFont(new Font("Berlin Sans FB", 33.0));
        backButtonId.addEventHandler(ActionEvent.ACTION ,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                   
                    Navigation.navigateTo(stage, new HomeScreen(stage), "Home Screen");
                 }
        });
        imageView.setFitHeight(54.0);
        imageView.setFitWidth(62.0);
        imageView.setLayoutX(13.0);
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
        button1id.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playingCount++;
                mainfunc();
                button1id.setText(symbol);
                button1id.setDisable(true);
                numberOfTheButtonClicked = 1;
                addTheButtonNumberToThePlayerList();
                winnerName = detectWin();
                actionPerformedDependingOnTheWinner(winnerName);
            }
        });
        button2id.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playingCount++;
                mainfunc();
                button2id.setText(symbol);
                button2id.setDisable(true);
                numberOfTheButtonClicked = 2;
                addTheButtonNumberToThePlayerList();
                winnerName = detectWin();
                actionPerformedDependingOnTheWinner(winnerName);
            }
        });
        button3id.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playingCount++;
                mainfunc();
                button3id.setText(symbol);
                button3id.setDisable(true);
                numberOfTheButtonClicked = 3;
                addTheButtonNumberToThePlayerList();
                winnerName = detectWin();
                //System.out.println(winnerName);
                actionPerformedDependingOnTheWinner(winnerName);
            }
        });
        button4id.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playingCount++;
                mainfunc();
                button4id.setText(symbol);
                button4id.setDisable(true);
                numberOfTheButtonClicked = 4;
                addTheButtonNumberToThePlayerList();
                winnerName = detectWin();
                actionPerformedDependingOnTheWinner(winnerName);
            }
        });
        button5id.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playingCount++;
                mainfunc();
                button5id.setText(symbol);
                button5id.setDisable(true);
                numberOfTheButtonClicked = 5;
                addTheButtonNumberToThePlayerList();
                winnerName = detectWin();
                actionPerformedDependingOnTheWinner(winnerName);
            }
        });
        button6id.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playingCount++;
                mainfunc();
                button6id.setText(symbol);
                button6id.setDisable(true);
                numberOfTheButtonClicked = 6;
                addTheButtonNumberToThePlayerList();
                winnerName = detectWin();
                actionPerformedDependingOnTheWinner(winnerName);
            }
        });
        button7id.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            playingCount++;
            mainfunc();
            button7id.setText(symbol);
            button7id.setDisable(true);
            numberOfTheButtonClicked = 7;
            addTheButtonNumberToThePlayerList();
            winnerName = detectWin();
            actionPerformedDependingOnTheWinner(winnerName);
        });
        button8id.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            playingCount++;
            mainfunc();
            button8id.setText(symbol);
            button8id.setDisable(true);
            numberOfTheButtonClicked = 8;
            addTheButtonNumberToThePlayerList();
            winnerName = detectWin();
            //System.out.println(winnerName);
            actionPerformedDependingOnTheWinner(winnerName);
        });
        button9id.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            playingCount++;
            mainfunc();
            button9id.setText(symbol);
            button9id.setDisable(true);
            numberOfTheButtonClicked = 9;
            addTheButtonNumberToThePlayerList();
            winnerName = detectWin();
            //System.out.println(winnerName);
            actionPerformedDependingOnTheWinner(winnerName);
        });
        PlayAgainButtonid = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(PlayAgainButtonid, stage);
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
                        cleartextFromButtons();
                        restart();
                        viewGameButtons();
                        saveAchorPane.setVisible(false);
                        anchorPanePlayAgain.setVisible(false);
                        GameResultId.setVisible(false); 
                        SaveButtonid.setDisable(false);
                 }
        });
	GameResultId = new Label();
        GameResultId.setVisible(false);
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
        GameResultId.setFont(new Font("Berlin Sans FB", 50.0));
        SaveButtonid = new Button();
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(SaveButtonid, stage);
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
                
                numberofGameMovesInTheGame = player1Moves.size() + player2Moves.size();
                vc = new Vector<>(numberofGameMovesInTheGame);
                vc = convertToVector(player1Moves, player2Moves);
                SaveGame.saveFile(new PlayersNames(playerOneName,playerTwoName),vc);
                SaveButtonid.setDisable(true);
                        
                       
            }
        });
       savImageIcon = new ImageView();
       savImageIcon.setFitHeight(40.0);
       savImageIcon.setFitWidth(48.0);
       savImageIcon.setLayoutX(16.0);
       savImageIcon.setLayoutY(16.0);
       savImageIcon.setOpacity(0.47);
       savImageIcon.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/Save.png")));
       saveAchorPane = new AnchorPane();
       saveAchorPane.setVisible(false);
       saveAchorPane.setLayoutX(779.0);
       saveAchorPane.setLayoutY(500.0);
       playAgainIcon = new ImageView();
       playAgainIcon.setFitHeight(54.0);
       playAgainIcon.setFitWidth(62.0);
       playAgainIcon.setLayoutX(13.0);
       playAgainIcon.setLayoutY(11.0);
       playAgainIcon.setOpacity(0.47);
       playAgainIcon.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/refresh.png")));
       anchorPanePlayAgain = new AnchorPane();
       anchorPanePlayAgain.setLayoutX(378.0);
       anchorPanePlayAgain.setLayoutY(300.0);
       anchorPanePlayAgain.setPrefHeight(75.0);
       anchorPanePlayAgain.setPrefWidth(259.0);
       anchorPanePlayAgain.setVisible(false);
       anchorPanePlayAgain.getChildren().add(PlayAgainButtonid);
       anchorPanePlayAgain.getChildren().add(playAgainIcon);
       getChildren().add(anchorPanePlayAgain);   
       getChildren().add(GameResultId);
       saveAchorPane.getChildren().add(SaveButtonid);
       saveAchorPane.getChildren().add(savImageIcon);
       getChildren().add(saveAchorPane);
    }
    public void playerwins(String playerName){

        if(playerName.equals("No one"))
        {
            PlayVideo.displayVideo("draw","");
            GameResultId.setText("It's a tie");
            
        }
        else
        {
             GameResultId.setText(playerName + " Wins");
             PlayVideo.displayVideo("winner",playerName);
        }
        saveAchorPane.setVisible(true);
        anchorPanePlayAgain.setVisible(true);
        GameResultId.setVisible(true);
        hideGameButtons();
        
        
          
    }
    public void restart()
    {
        player1Moves.clear();
        player2Moves.clear();
        player1Turn = true;
        playingCount = 0;
        winnerName = "";
    }
    public void enableButtons()
    {
        button1id.setDisable(false);
        button2id.setDisable(false);
        button3id.setDisable(false);
        button4id.setDisable(false);
        button5id.setDisable(false);
        button6id.setDisable(false);
        button7id.setDisable(false);
        button8id.setDisable(false);
        button9id.setDisable(false);
    } 
    public void addTheButtonNumberToThePlayerList()
    {
        if(player1Turn)
        {
            player1Moves.add(numberOfTheButtonClicked);
            player1Turn = false;
        }
        else
        {
            player2Moves.add(numberOfTheButtonClicked);
            player1Turn = true;
        }
        
    }
    public String detectWin(){
        if(playingCount >= 5)
        {
            for(List l : allWinningLists)
            {
                if(player1Moves.containsAll(l))
                {
                    return "player1";
                }
                else if(player2Moves.containsAll(l))
                {
                    return  "player2";
                }
                else if(player1Moves.size()+ player2Moves.size() == 9)
                {
                    return "tie";
                }
            }
        }
        return "";
    }
    public void cleartextFromButtons()
    {
        button1id.setText("");
        button2id.setText("");
        button3id.setText("");
        button4id.setText("");
        button5id.setText("");
        button6id.setText("");
        button7id.setText("");
        button8id.setText("");
        button9id.setText("");
    }
    public void actionPerformedDependingOnTheWinner(String nameOfTheWinner){
        if(nameOfTheWinner.equals("player1"))
        {
            playerOneResult++;
            player1result.setText(String.valueOf(playerOneResult));
            playerwins(playerOneName);
            enableButtons();
        }
        else if(nameOfTheWinner.equals("player2"))
        {
            playerTwoResult++;
            player2result.setText(String.valueOf(playerTwoResult));
            playerwins(playerTwoName);
            enableButtons();
        }
        else if(nameOfTheWinner.equals("tie"))
        {
            playerwins("No one");
            enableButtons();
        }
        
    }
    public void mainfunc(){
        //player1 turn
        if(player1Turn)
        {
            symbol = "X";
        }
        //player2 turn
        else
        {
            symbol = "O";
        }
    }
    Vector<Integer> convertToVector(ArrayList<Integer> arr1 ,ArrayList<Integer> arr2 ){
        arr1Index = 0;
        arr2Index = 0;
        nameOfPlayer1 = playerOneName;
        nameOfPlayer2 = playerTwoName;
        numberofGameMovesInTheGame = vc.size();
        playersRecorderMoves =new ArrayList<>();arr1Index = 0;
        arr2Index = 0;
        nameOfPlayer1 = playerOneName;
        nameOfPlayer2 = playerTwoName;
        numberofGameMovesInTheGame = vc.size();
        playersRecorderMoves =new ArrayList<>();
        for(int i = 0 ; i < (arr1.size() + arr2.size()) ; i++)
        {
            if(i%2 == 0 || i==0)
            {
                vc.add(arr1.get(arr1Index));
                arr1Index++;
            }
            else{
                vc.add(arr2.get(arr2Index));
                arr2Index++;
            }
        }
        return vc;
    } 
    void convertStringFromFileToArrayListOfIntsAndPlayerNames(String strDatawithRecordedGameInfo){
        int i = 0;
        int res = strDatawithRecordedGameInfo.indexOf(",&");
        System.out.println(res);
        getSubStringForNames = strDatawithRecordedGameInfo.substring(res + 2);
        System.out.println(getSubStringForNames);
        String sub = "";
        sub = strDatawithRecordedGameInfo.substring(0,res);
        System.out.println(sub);
        StringTokenizer st = new StringTokenizer(sub,",");  
        while (st.hasMoreTokens()) 
        {  
              playersRecorderMoves.add(Integer.parseInt(st.nextToken()));
              System.out.println(playersRecorderMoves.get(i));
              i++;
        }
    } 
    void seperateTheTwoPlayersNames(String concatenatedNames)
    { 
        int res = concatenatedNames.indexOf("&");
        nameOfPlayerOneRecorder = concatenatedNames.substring(0,res);
        nameOfPlayerTwoRecorder = concatenatedNames.substring(res+1);
        System.out.println(nameOfPlayerOneRecorder);
        System.out.println(nameOfPlayerTwoRecorder);
    }
    void hideGameButtons(){
        button1id.setVisible(false);
        button2id.setVisible(false);
        button3id.setVisible(false);
        button4id.setVisible(false);
        button5id.setVisible(false);
        button6id.setVisible(false);
        button7id.setVisible(false);
        button8id.setVisible(false);
        button9id.setVisible(false);  
    }
    void viewGameButtons(){
        button1id.setVisible(true);
        button2id.setVisible(true);
        button3id.setVisible(true);
        button4id.setVisible(true);
        button5id.setVisible(true);
        button6id.setVisible(true);
        button7id.setVisible(true);
        button8id.setVisible(true);
        button9id.setVisible(true);  
    }
}
