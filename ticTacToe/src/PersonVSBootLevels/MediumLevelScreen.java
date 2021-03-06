package PersonVSBootLevels;

import CursorHANDWhenMoveToIntoButton.CursorHANDWhenMoveToIntoButton;
import DisplayAlert.PlayersNames;
import SaveGame.SaveGame;
import java.util.ArrayList;
import java.util.Vector;
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
import Navigation.Navigation;
import MediaPlayer.PlayVideo;
import SinglePlayerLevels.SinglePlayerChooseLevel;
import java.util.Random;

public class MediumLevelScreen extends AnchorPane {
    
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
    protected final ImageView logoImage;
    protected final Label labelXText;
    protected final Label playXName;
    protected final Label playerXresult;
    protected final AnchorPane anchorPane2;
    protected final AnchorPane anchorPane3;
    protected final ImageView player2Image;
    protected final Label labelOText;
    protected final Label playerOName;
    protected final Label computerYResult;
    protected final AnchorPane anchorPane4;
    protected final Button backButton;
    protected final ImageView backButtonImage;
    protected final Label GameResultId;
    protected final Button SaveButtonid;
    protected final ImageView savImageIcon;
    protected final AnchorPane saveAchorPane;
    protected final ImageView playAgainIcon;
    private Random rand = new Random();
    Button[] btnList;
    private boolean printRand = true;
    protected final AnchorPane anchorPanePlayAgain;
        
    private int XWins = 0;
    private int OWins = 0;
    private int Draws = 0;
    private int newXResult = 0;
    private int newYResult = 0;
    
    Vector<Integer> vc; 
    ArrayList<Integer> playerXMoves;
    ArrayList<Integer> playerOMoves;
    ArrayList<Integer> moves;
    TicTacToeAIMedium gameManagerHelper;
    Stage stage;
    public MediumLevelScreen(Stage stage,String playerName) {
        //To play video in the center of screen 
        this.stage = stage;
        vc = new Vector();
        playerXMoves = new ArrayList<Integer>();
        playerOMoves = new ArrayList<Integer>();
        moves = new ArrayList<Integer>();
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
        gameManagerHelper = new TicTacToeAIMedium();
        b3 = new Button();
        b6 = new Button();
        b2 = new Button();
        b1 = new Button();
        b5 = new Button();
        b8 = new Button();
        b9 = new Button();
        b4 = new Button();
        b7 = new Button(); 
        btnList = new Button[9];
        addButtonsToArray();
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
                        SaveGame.saveFile(new PlayersNames(playerName,"Computer"),vc);
                        SaveButtonid.setDisable(true);
                  }
        });
       CursorHANDWhenMoveToIntoButton.getCurserOnbutton(SaveButtonid,stage);
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
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(PlayAgainButtonid, stage);
        playAgainIcon = new ImageView();
        playAgainIcon.setFitHeight(54.0);
        playAgainIcon.setFitWidth(62.0);
        playAgainIcon.setLayoutX(13.0);
        playAgainIcon.setLayoutY(11.0);
        playAgainIcon.setOpacity(0.47);
        playAgainIcon.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/refresh.png")));
       
        anchorPane0 = new AnchorPane();
        anchorPane1 = new AnchorPane();
        logoImage = new ImageView();
        labelXText = new Label();
        playXName = new Label();
        playerXresult = new Label();
        anchorPane2 = new AnchorPane();
        anchorPane3 = new AnchorPane();
        player2Image = new ImageView();
        labelOText = new Label();
        playerOName = new Label();
        computerYResult = new Label();
        anchorPane4 = new AnchorPane();
        backButton = new Button();
        backButtonImage = new ImageView();
      
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

        b1.setMnemonicParsing(false);
        b1.setPrefHeight(95.0);
        b1.setPrefWidth(133.0);
        b1.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b1.setFont(new Font("Berlin Sans FB", 42.0));
        b1.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            printXOForEasy(0);
        });
        
        GridPane.setColumnIndex(b2, 1);
        b2.setMnemonicParsing(false);
        b2.setPrefHeight(95.0);
        b2.setPrefWidth(133.0);
        b2.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b2.setFont(new Font("Berlin Sans FB", 42.0));
        b2.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           printXOForEasy(1);
        });
        
        GridPane.setColumnIndex(b3, 2);
        b3.setMnemonicParsing(false);
        b3.setPrefHeight(95.0);
        b3.setPrefWidth(133.0);
        b3.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b3.setFont(new Font("Berlin Sans FB", 42.0));
        b3.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            printXOForEasy(2);
        });
        
        GridPane.setRowIndex(b4, 1);
        b4.setMnemonicParsing(false);
        b4.setPrefHeight(95.0);
        b4.setPrefWidth(133.0);
        b4.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b4.setFont(new Font("Berlin Sans FB", 42.0));
        b4.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            printXOForEasy(3);
        });
        
        GridPane.setColumnIndex(b5, 1);
        GridPane.setRowIndex(b5, 1);
        b5.setMnemonicParsing(false);
        b5.setPrefHeight(95.0);
        b5.setPrefWidth(133.0);
        b5.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b5.setFont(new Font("Berlin Sans FB", 42.0));
        b5.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           printXOForEasy(4);
        });
        
        GridPane.setColumnIndex(b6, 2);
        GridPane.setRowIndex(b6, 1);
        b6.setMnemonicParsing(false);
        b6.setPrefHeight(95.0);
        b6.setPrefWidth(133.0);
        b6.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b6.setFont(new Font("Berlin Sans FB", 42.0));
        b6.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            printXOForEasy(5);
        });
        
        GridPane.setRowIndex(b7, 2);
        b7.setMnemonicParsing(false);
        b7.setPrefHeight(95.0);
        b7.setPrefWidth(133.0);
        b7.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b7.setFont(new Font("Berlin Sans FB", 42.0));
        b7.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            printXOForEasy(6);
        });
        
        GridPane.setColumnIndex(b8, 1);
        GridPane.setRowIndex(b8, 2);
        b8.setMnemonicParsing(false);
        b8.setPrefHeight(95.0);
        b8.setPrefWidth(133.0);
        b8.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b8.setFont(new Font("Berlin Sans FB", 42.0));
        b8.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            printXOForEasy(7);
        });
        
        GridPane.setColumnIndex(b9, 2);
        GridPane.setRowIndex(b9, 2);
        b9.setMnemonicParsing(false);
        b9.setPrefHeight(95.0);
        b9.setPrefWidth(133.0);
        b9.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 13;");
        b9.setFont(new Font("Berlin Sans FB", 42.0));
        b9.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
           printXOForEasy(8);
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
                playAgainFunction(stage);
                 }
        });
        
        gridPane.setPadding(new Insets(10.0, 0.0, 10.0, 10.0));

        anchorPane0.setLayoutX(49.0);
        anchorPane0.setLayoutY(101.0);

        logoImage.setFitHeight(142.0);
        logoImage.setFitWidth(154.0);
        logoImage.setLayoutX(9.0);
        logoImage.setLayoutY(94.0);
        logoImage.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        logoImage.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play1.png")));
       
        labelXText.setLayoutX(144.0);
        labelXText.setLayoutY(222.0);
        labelXText.setText("X");
        labelXText.setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
        labelXText.setFont(new Font("Berlin Sans FB", 68.0));
        
        playXName.setLayoutX(5.0);
        playXName.setPrefHeight(75.0);
        playXName.setPrefWidth(193.0);
        playXName.setText(playerName);
        playXName.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playXName.setFont(new Font("Berlin Sans FB", 36.0));

        playerXresult.setLayoutX(32.0);
        playerXresult.setLayoutY(297.0);
        playerXresult.setPrefHeight(54.0);
        playerXresult.setPrefWidth(109.0);
        playerXresult.setText("0");
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

        player2Image.setFitHeight(142.0);
        player2Image.setFitWidth(154.0);
        player2Image.setLayoutX(9.0);
        player2Image.setLayoutY(94.0);
        player2Image.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        player2Image.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/play2.png")));

        labelOText.setLayoutX(144.0);
        labelOText.setLayoutY(222.0);
        labelOText.setText("O");
        labelOText.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        labelOText.setFont(new Font("Berlin Sans FB", 68.0));

        playerOName.setLayoutX(3.0);
        playerOName.setPrefHeight(64.0);
        playerOName.setPrefWidth(193.0);
        playerOName.setText("Computer");
        playerOName.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        playerOName.setFont(new Font("Berlin Sans FB", 36.0));

        computerYResult.setLayoutX(44.0);
        computerYResult.setLayoutY(294.0);
        computerYResult.setPrefHeight(54.0);
        computerYResult.setPrefWidth(109.0);
        computerYResult.setText("0");
        computerYResult.setTextFill(javafx.scene.paint.Color.valueOf("#edf1f2"));
        computerYResult.setFont(new Font("Berlin Sans FB", 24.0));

        anchorPane4.setLayoutX(29.0);
        anchorPane4.setLayoutY(501.0);

        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(75.0);
        backButton.setPrefWidth(185.0);
        backButton.setStyle("-fx-background-radius: 17;-fx-background-color: #e7ffdb;");
        backButton.setText("       Back");
        backButton.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        backButton.setFont(new Font("Berlin Sans FB", 33.0));
        backButton.addEventHandler(ActionEvent.ACTION ,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    Navigation.navigateTo(stage, new SinglePlayerChooseLevel(stage), "Choose Level");
                 }
        });
        CursorHANDWhenMoveToIntoButton.getCurserOnbutton(backButton, stage);
        backButtonImage.setFitHeight(50.0);
        backButtonImage.setFitWidth(52.0);
        backButtonImage.setLayoutX(16.0);
        backButtonImage.setLayoutY(11.0);
        backButtonImage.setOpacity(0.47);
        backButtonImage.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));

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
        anchorPane1.getChildren().add(logoImage);
        anchorPane1.getChildren().add(labelXText);
        anchorPane1.getChildren().add(playXName);
        anchorPane0.getChildren().add(anchorPane1);
        anchorPane0.getChildren().add(playerXresult);
        getChildren().add(anchorPane0);
        anchorPane3.getChildren().add(player2Image);
        anchorPane3.getChildren().add(labelOText);
        anchorPane3.getChildren().add(playerOName);
        anchorPane2.getChildren().add(anchorPane3);
        anchorPane2.getChildren().add(computerYResult);
        getChildren().add(anchorPane2);
        anchorPane4.getChildren().add(backButton);
        anchorPane4.getChildren().add(backButtonImage);
        getChildren().add(anchorPane4);
        anchorPanePlayAgain.getChildren().add(PlayAgainButtonid);
        anchorPanePlayAgain.getChildren().add(playAgainIcon);
        getChildren().add(anchorPanePlayAgain);   
        getChildren().add(GameResultId);
        
        saveAchorPane.getChildren().add(SaveButtonid);
        saveAchorPane.getChildren().add(savImageIcon);
        getChildren().add(saveAchorPane);

    }
       public void SetCounters(int Num) {
		switch (Num) {
		case GameResult.X_WIN:
			XWins++;
                        newXResult ++;
                       break;
		case GameResult.O_WIN:
                        OWins++;
                        newYResult++;
			break;
		case GameResult.TIE:
			Draws++;
			break;
		}
                hideAllXOButton();
                playerXresult.setText(""+XWins);
                computerYResult.setText(""+OWins);
                if(newXResult > newYResult){
                    GameResultId.setText("Congratulations you won");
                    newXResult = 0;
                    newYResult = 0;
                    PlayVideo.displayVideo("winner",stage);
                }
                else  if(newXResult < newYResult)
                {
                    GameResultId.setText("Unfortunately, the computer won");
                    newXResult = 0;
                    newYResult = 0;
                    PlayVideo.displayVideo("loser",stage);
                }
                else 
                {
                    GameResultId.setText("Game over,no one won");
                    newXResult = 0;
                    newYResult = 0;
                    PlayVideo.displayVideo("draw",stage);
                }
                for(int i=0;i<vc.size();i++)
                {
                    System.out.print(" "+ vc.get(i));
                }
	        
	}
        void hideAllXOButton()
        {
            gridPane.setVisible(false);
            anchorPanePlayAgain.setVisible(true);
            GameResultId.setVisible(true);
            saveAchorPane.setVisible(true);
        }
        void playAgainFunction(Stage stage)
        {
            gridPane.setVisible(true);
            b1.setDisable(false);
            b2.setDisable(false);
            b3.setDisable(false);
            b4.setDisable(false);
            b5.setDisable(false);
            b6.setDisable(false);
            b7.setDisable(false);
            b8.setDisable(false);
            b9.setDisable(false);
            
            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
            vc.clear();
            playerOMoves.clear();
            playerXMoves.clear();
            SaveButtonid.setDisable(false);
            anchorPanePlayAgain.setVisible(false);
            GameResultId.setVisible(false);
            saveAchorPane.setVisible(false);
            stage.getScene().setCursor(Cursor.DEFAULT);
        }
        void addMovesPlayers(int x)
        {
            vc.add(x);
        }
     private void addButtonsToArray() {
        btnList[0] = b1;
        btnList[1] = b2;
        btnList[2] = b3;
        btnList[3] = b4;
        btnList[4] = b5;
        btnList[5] = b6;
        btnList[6] = b7;
        btnList[7] = b8;
        btnList[8] = b9;
    }
    private void printXOForEasy(int i) { 
        if (btnList[i].getText().equals("")) { 
            btnList[i].setText("X");
            btnList[i].setDisable(true);
            btnList[i].setTextFill(javafx.scene.paint.Color.valueOf("#CA2727"));
            addMovesPlayers(i+1);
            playerXMoves.add(i+1);
            int check = gameManagerHelper.detectWin(playerXMoves,playerOMoves); // Check If I Wined !
            if(check == GameResult.CONTINUE_PLAYING) 
            {
                printRand = true;
                computerTurn();
            }
            else
            {
                printRand = false;
                SetCounters(check);
            }
            
        }
    }
    private void computerTurn() {
        if (printRand) {
            int nextMove = gameManagerHelper
                               .detectNextPlay(playerXMoves,moves);
            if( nextMove == -1)
            {

                    while (true) { // Execute This Block Until Pc Fill 1 Gaps By The Random Value 
                        int index = rand.nextInt(9); // Get Random Value Between 0 And 8
                        if (btnList[index].getText().equals("")) {
                            btnList[index].setText("O");
                            btnList[index].setDisable(true);
                            btnList[index].setTextFill(javafx.scene.paint.Color.valueOf("#FFFFFF"));
                            addMovesPlayers(index + 1);
                            playerOMoves.add(index + 1);
                            int check = gameManagerHelper.detectWin(playerXMoves, playerOMoves); // Check If I Wined !
                            if(check == GameResult.CONTINUE_PLAYING) 
                            {
                                printRand = true;

                            }
                            else
                            {
                                printRand = false;
                                SetCounters(check);
                            }
                            break;
                        }
                    }
                }
            else
            {
                moves.add(nextMove);
                nextMove--;
                if (btnList[nextMove].getText().equals("")) {
                    btnList[nextMove].setText("O");
                    btnList[nextMove].setDisable(true);
                    btnList[nextMove].setTextFill(javafx.scene.paint.Color.valueOf("#FFFFFF"));
                    addMovesPlayers(nextMove + 1);
                    playerOMoves.add(nextMove + 1);
                    int check = gameManagerHelper.detectWin(playerXMoves, playerOMoves); // Check If I Wined !
                    if(check == GameResult.CONTINUE_PLAYING) 
                    {
                        printRand = true;

                    }
                    else
                    {
                        printRand = false;
                        SetCounters(check);
                    }
                }
                else
                {
                    computerTurn();
                }
            }
        }
    }
}
