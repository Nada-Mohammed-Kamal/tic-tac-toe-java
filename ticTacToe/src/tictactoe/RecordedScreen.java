package tictactoe;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RecordedScreen extends AnchorPane {

    

    ArrayList<String> returnedFilesNames;

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final AnchorPane anchorPane0;
    protected final Button backButtonid;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane1;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;

    public RecordedScreen(Stage stage) {

        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        anchorPane0 = new AnchorPane();
        backButtonid = new Button();
        imageView = new ImageView();
        anchorPane1 = new AnchorPane();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        
        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        anchorPane.setLayoutX(45.0);
        anchorPane.setLayoutY(167.0);

        label.setLayoutX(-8.0);
        label.setLayoutY(167.0);
        label.setPrefHeight(140.0);
        label.setPrefWidth(252.0);
        label.setText("TOE");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 93.0));

        label0.setLayoutX(-11.0);
        label0.setLayoutY(-33.0);
        label0.setPrefHeight(140.0);
        label0.setPrefWidth(216.0);
        label0.setText("TIC");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label0.setFont(new Font("Berlin Sans FB", 100.0));

        label1.setLayoutX(-13.0);
        label1.setLayoutY(67.0);
        label1.setPrefHeight(140.0);
        label1.setPrefWidth(228.0);
        label1.setText("TAC");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label1.setFont(new Font("Berlin Sans FB", 93.0));

        anchorPane0.setLayoutX(8.0);
        anchorPane0.setLayoutY(491.0);
        anchorPane0.setPrefHeight(89.0);
        anchorPane0.setPrefWidth(219.0);

        backButtonid.setLayoutX(4.0);
        backButtonid.setMnemonicParsing(false);
        backButtonid.setPrefHeight(90.0);
        backButtonid.setPrefWidth(219.0);
        backButtonid.setStyle("-fx-background-radius: 17; -fx-background-color: #e7ffdb;");
        backButtonid.setText("       Back");
        backButtonid.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        backButtonid.setFont(new Font("Berlin Sans FB", 33.0));
        backButtonid.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Navigation.navigateTo(stage,new HomeScreen(stage), "Home screen");
                //Navigation.navigateTo(stage,new ReplayingTheChosenRecodrdedGame("kamalVSahmed2022-03-02-18-24-35"),"ReplayingTheChosenRecodrdedGame");
            }
        });
        imageView.setFitHeight(62.0);
        imageView.setFitWidth(62.0);
        imageView.setLayoutX(13.0);
        imageView.setLayoutY(3.0);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));
        
        anchorPane1.setLayoutX(283.0);
        anchorPane1.setLayoutY(29.0);
        anchorPane1.setMinHeight(USE_PREF_SIZE);
        anchorPane1.setMinWidth(USE_PREF_SIZE);
        anchorPane1.setPrefHeight(554.0);
        anchorPane1.setPrefWidth(702.0);
        anchorPane1.setStyle("-fx-background-color: #E9EDF0; -fx-background-radius: 10;");

        scrollPane.setHbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutX(5.0);
        scrollPane.setLayoutY(9.0);
        scrollPane.setPrefHeight(544.0);
        scrollPane.setPrefWidth(699.0);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background-radius: 10;");
        scrollPane.setVbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.ALWAYS);

        vBox.setMinHeight(USE_PREF_SIZE);
        vBox.setMinWidth(USE_PREF_SIZE);
        vBox.setPrefHeight(543.0);
        vBox.setPrefWidth(682.0);

        scrollPane.setContent(vBox);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(backButtonid);
        anchorPane0.getChildren().add(imageView);
        getChildren().add(anchorPane0);
       
        anchorPane1.getChildren().add(scrollPane);
        getChildren().add(anchorPane1);
        
        vBox.setSpacing(8);
        
         returnedFilesNames = new ArrayList<>();
         returnedFilesNames = getRecordedFilesNames();
         for(int i = 0 ; i < returnedFilesNames.size() ; i++)
         {
             addRecordedGame(returnedFilesNames.get(i));
         }
    }
    void addRecordedGame(String fileName)
    {
        Label fileNameLabel = new Label();
        AnchorPane.setLeftAnchor(fileNameLabel, 11.0);
        AnchorPane.setTopAnchor(fileNameLabel, 26.0);
        fileNameLabel.setLayoutX(11.0);
        fileNameLabel.setLayoutY(26.0);
        fileNameLabel.setPrefHeight(23.0);
        fileNameLabel.setPrefWidth(554.0);
        fileNameLabel.setText(fileName);
        fileNameLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        fileNameLabel.setFont(new Font("Arial", 24.0));
        
        Button showRecordedGame = new Button();
        AnchorPane.setRightAnchor(showRecordedGame, 16.0);
        showRecordedGame.setLayoutX(580.0);
        showRecordedGame.setLayoutY(15.0);
        showRecordedGame.setMinHeight(USE_PREF_SIZE);
        showRecordedGame.setMinWidth(USE_PREF_SIZE);
        showRecordedGame.setMnemonicParsing(false);
        showRecordedGame.setPrefHeight(48.0);
        showRecordedGame.setPrefWidth(88.0);
        showRecordedGame.setStyle("-fx-background-color: #1FA4E5;");
        showRecordedGame.setText("Show");
        showRecordedGame.setTextFill(javafx.scene.paint.Color.WHITE);
        showRecordedGame.setFont(new Font("System Bold", 22.0));
        
        AnchorPane UserDetails = new AnchorPane();
        UserDetails.setMinHeight(USE_PREF_SIZE);
        UserDetails.setMinWidth(USE_PREF_SIZE);
        UserDetails.setPrefHeight(78.0);
        UserDetails.setPrefWidth(682.0);
        UserDetails.setStyle("-fx-background-color: #8596A0; -fx-background-radius: 10;");

        UserDetails.getChildren().add(fileNameLabel);
        UserDetails.getChildren().add(showRecordedGame);
        vBox.getChildren().add(UserDetails);
    }
    ArrayList<String> getRecordedFilesNames(){
        File f = new File(System.getProperty("user.dir"));
        ArrayList<String> filesNames = new ArrayList<>();
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] files = f.listFiles(textFilter);
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("directory:");
            } else {
                System.out.print("     file:");
            }
            try {
                System.out.println(file.getCanonicalPath().substring(file.getCanonicalPath().indexOf("VS")+1));
                filesNames.add(file.getCanonicalPath().substring(file.getCanonicalPath().indexOf("VS")+2));
            } catch (IOException ex) {
                Logger.getLogger(RecordedScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filesNames;
    } 
}
   
        
    