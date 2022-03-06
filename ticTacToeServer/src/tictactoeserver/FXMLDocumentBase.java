package tictactoeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import serverdao.ConnectionDB;
import serverdao.PlayerManager;
import serverdao.PlayerManagerImpl;

public class FXMLDocumentBase extends AnchorPane implements OnPlayerCountChangeListener {

    protected final ColorAdjust colorAdjust;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane0;
    protected final Button btnStop;
    protected final Button btnStart;
    protected final Label txtFieldServerState;
    protected final Label txtFieldOnlineNumber;
    protected final Label txtFieldOffilneNumber;
    protected final AnchorPane anchorPane1;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final AnchorPane UserDetails;
    protected final Label label2;
    protected final ImageView imageView0;
    protected final Label statusOfUserOnButton;
    private PlayerManager playerManager;
    ServerSocket serverSocket;
    private boolean turnServerOn = false;
    Thread thread;
    
    public FXMLDocumentBase(Stage stage) {
        
        colorAdjust = new ColorAdjust();
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        imageView = new ImageView();
        anchorPane0 = new AnchorPane();
        btnStop = new Button();
        btnStart = new Button();
        txtFieldServerState = new Label();
        txtFieldOnlineNumber = new Label();
        txtFieldOffilneNumber = new Label();
        anchorPane1 = new AnchorPane();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        UserDetails = new AnchorPane();
        
        label2 = new Label();
        imageView0 = new ImageView();
        statusOfUserOnButton = new Label();
        playerManager = PlayerManagerImpl.getInstance(ConnectionDB.getInstance());
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        setEffect(colorAdjust);

        anchorPane.setLayoutX(66.0);
        anchorPane.setLayoutY(164.0);

        label.setLayoutY(-29.0);
        label.setPrefHeight(140.0);
        label.setPrefWidth(216.0);
        label.setText("TIC");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 100.0));

        label0.setLayoutY(166.0);
        label0.setPrefHeight(140.0);
        label0.setPrefWidth(252.0);
        label0.setText("TOE");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label0.setFont(new Font("Berlin Sans FB", 100.0));

        label1.setLayoutY(66.0);
        label1.setPrefHeight(140.0);
        label1.setPrefWidth(228.0);
        label1.setText("TAC");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label1.setFont(new Font("Berlin Sans FB", 100.0));

        imageView.setFitHeight(188.0);
        imageView.setFitWidth(307.0);
        imageView.setLayoutX(357.0);
        imageView.setLayoutY(36.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoeserver/Images/XOLogo.jfif")));
        anchorPane0.setLayoutX(770.0);
        anchorPane0.setLayoutY(48.0);

        btnStop.setLayoutX(290.0);
        btnStop.setLayoutY(390.0);
        btnStop.setMnemonicParsing(false);
        btnStop.setPrefHeight(84.0);
        btnStop.setPrefWidth(356.0);
        btnStop.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        btnStop.setText("Stop");
        btnStop.setTextFill(javafx.scene.paint.Color.WHITE);
        btnStop.setFont(new Font("Comic Sans MS Bold", 40.0));
        btnStop.setOnAction((action) -> {
            if (turnServerOn) {
                turnServerOn = false;
                txtFieldServerState.setText("Server is offline");
                txtFieldServerState.setTextFill(javafx.scene.paint.Color.valueOf("#FF0000"));
                btnStart.setDisable(false);
                thread.stop();
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        btnStop.setOnMouseEntered((event) -> {
            stage.getScene().setCursor(Cursor.HAND);
        });
        btnStop.setOnMouseExited((event) -> {
            stage.getScene().setCursor(Cursor.DEFAULT);
        });

        btnStart.setLayoutX(290.0);
        btnStart.setLayoutY(258.0);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(84.0);
        btnStart.setPrefWidth(356.0);
        btnStart.setStyle("-fx-background-color: #1db2ca; -fx-background-radius: 45;");
        btnStart.setText("Start");
        btnStart.setTextFill(javafx.scene.paint.Color.WHITE);
        btnStart.setFont(new Font("Comic Sans MS Bold", 40.0));
        btnStart.setOnAction((action) -> {
            
            turnServerOn = true;
            btnStart.setDisable(true);
            try {
                serverSocket = new ServerSocket(5555);
                System.out.println("Server started");
                System.out.println("Waiting for a client ...");
                
                txtFieldServerState.setText("Server is online");
                txtFieldServerState.setTextFill(javafx.scene.paint.Color.valueOf("#22bd62"));
                
                thread = new Thread() {
                    @Override
                    public void run() {
                        playerManager.setOnPlayerCountChangeListener(FXMLDocumentBase.this);
                        while (turnServerOn) {
                            Socket accept;
                            try {
                                accept = serverSocket.accept();
                                System.out.println("Client accepted");
                                new GameHandler(accept, stage);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentBase.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                thread.start();
            } catch (IOException ex) {
                try {
                    serverSocket.close();
                } catch (IOException ex1) {
                    Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
        btnStart.setOnMouseEntered((event) -> {
            stage.getScene().setCursor(Cursor.HAND);
        });
        btnStart.setOnMouseExited((event) -> {
            stage.getScene().setCursor(Cursor.DEFAULT);
        });

        txtFieldServerState.setLayoutX(66.0);
        txtFieldServerState.setLayoutY(470.0);
        txtFieldServerState.setPrefHeight(140.0);
        txtFieldServerState.setPrefWidth(252.0);
        txtFieldServerState.setText("Server is offline");
        txtFieldServerState.setTextFill(javafx.scene.paint.Color.valueOf("#FF0000"));
        txtFieldServerState.setFont(new Font("Berlin Sans FB", 38.0));

        txtFieldOnlineNumber.setLayoutX(787.0);
        txtFieldOnlineNumber.setLayoutY(-22.0);
        txtFieldOnlineNumber.setPrefHeight(140.0);
        txtFieldOnlineNumber.setPrefWidth(252.0);
        txtFieldOnlineNumber.setText("Online: 0");
        txtFieldOnlineNumber.setTextFill(javafx.scene.paint.Color.valueOf("#22bd62"));
        txtFieldOnlineNumber.setFont(new Font("Berlin Sans FB", 36.0));

        txtFieldOffilneNumber.setLayoutX(787.0);
        txtFieldOffilneNumber.setLayoutY(36.0);
        txtFieldOffilneNumber.setPrefHeight(140.0);
        txtFieldOffilneNumber.setPrefWidth(252.0);
        txtFieldOffilneNumber.setText("Offline: 0");
        txtFieldOffilneNumber.setTextFill(javafx.scene.paint.Color.valueOf("#bd2227"));
        txtFieldOffilneNumber.setFont(new Font("Berlin Sans FB", 38.0));

        anchorPane1.setLayoutX(717.0);
        anchorPane1.setLayoutY(149.0);
        anchorPane1.setMinHeight(USE_PREF_SIZE);
        anchorPane1.setMinWidth(USE_PREF_SIZE);
        anchorPane1.setPrefHeight(420.0);
        anchorPane1.setPrefWidth(258.0);
        anchorPane1.setStyle("-fx-background-color: #E9EDF0; -fx-background-radius: 10;");

        scrollPane.setHbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setLayoutX(5.0);
        scrollPane.setLayoutY(9.0);
        scrollPane.setPrefHeight(402.0);
        scrollPane.setPrefWidth(252.0);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background-radius: 10;");
        scrollPane.setVbarPolicy(javafx.scene.control.ScrollPane.ScrollBarPolicy.ALWAYS);

        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(236.0);

        UserDetails.setPrefHeight(53.0);
        UserDetails.setPrefWidth(207.0);
        UserDetails.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 10;");
        
        label2.setLayoutX(54.0);
        label2.setLayoutY(13.0);
        label2.setText("Esraa");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Arial", 20.0));

        imageView0.setFitHeight(30.0);
        imageView0.setFitWidth(27.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(13.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResourceAsStream("/tictactoeserver/Images/arrow.png")));
       
        statusOfUserOnButton.setLayoutX(144.0);
        statusOfUserOnButton.setLayoutY(25.0);
        statusOfUserOnButton.setPrefHeight(30.0);
        statusOfUserOnButton.setPrefWidth(62.0);
        statusOfUserOnButton.setText("offline");
        statusOfUserOnButton.setTextFill(javafx.scene.paint.Color.WHITE);
        statusOfUserOnButton.setFont(new Font("Arial", 16.0));
        scrollPane.setContent(vBox);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        getChildren().add(anchorPane);
        getChildren().add(imageView);
        getChildren().add(anchorPane0);
        getChildren().add(btnStop);
        getChildren().add(btnStart);
        getChildren().add(txtFieldServerState);
        getChildren().add(txtFieldOnlineNumber);
        getChildren().add(txtFieldOffilneNumber);
        UserDetails.getChildren().add(label2);
        UserDetails.getChildren().add(imageView0);
        UserDetails.getChildren().add(statusOfUserOnButton);
        
        vBox.setSpacing(8);
        
//         addNewRow("Esraa", "Offline");
//         addNewRow("Ahmed", "Online");
//         addNewRow("Nada", "Offline");
//         addNewRow("Esraa", "Offline");
                 
        anchorPane1.getChildren().add(scrollPane);
        getChildren().add(anchorPane1);
        
    }
    
    void addNewRow(String name,String onlineOrOffline) {
        Label label2 = new Label();
        label2.setLayoutX(54.0);
        label2.setLayoutY(13.0);
        label2.setText(name);
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("Arial", 20.0));
        
        Label statusOfUserOnButton = new Label();
        statusOfUserOnButton.setLayoutX(144.0);
        statusOfUserOnButton.setLayoutY(25.0);
        statusOfUserOnButton.setPrefHeight(30.0);
        statusOfUserOnButton.setPrefWidth(62.0);
        statusOfUserOnButton.setText(onlineOrOffline);
        statusOfUserOnButton.setTextFill(javafx.scene.paint.Color.WHITE);
        statusOfUserOnButton.setFont(new Font("Arial", 16.0));
        
        ImageView imageView0 = new ImageView();
        imageView0.setFitHeight(30.0);
        imageView0.setFitWidth(27.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(13.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResourceAsStream("/tictactoeserver/Images/arrow.png")));
       
        
        AnchorPane UserDetails = new AnchorPane();
        UserDetails.setPrefHeight(53.0);
        UserDetails.setPrefWidth(207.0);
        UserDetails.setStyle("-fx-background-color: #1FA4E5; -fx-background-radius: 10;");
        UserDetails.getChildren().add(label2);
        UserDetails.getChildren().add(imageView0);
        UserDetails.getChildren().add(statusOfUserOnButton);
        vBox.getChildren().add(UserDetails);
    }

    @Override
    public void onPlayerCountChange(List<String> onlinePlayers, int allUsersCount) {
        
        txtFieldOnlineNumber.setText("Online: "+ onlinePlayers.size());
        txtFieldOffilneNumber.setText("Offline: "+(allUsersCount-onlinePlayers.size()));
        for(int i = 0;i < onlinePlayers.size(); i++){
            
            addNewRow(onlinePlayers.get(i),"Online");
        }
    }
}
