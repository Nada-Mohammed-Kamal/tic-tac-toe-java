package tictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

public class SignUp extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final AnchorPane anchorPane0;
    protected final Button btnBack;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane1;
    protected final Button btnRegister;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final TextField txtFieldName;
    protected final TextField txtFieldPassword;
    protected final TextField txtFieldEmail;
    protected final TextField txtFieldRePassword;
    protected final AnchorPane anchorPane2;
    protected final Label label2;
    protected final Button btnLogin;
    
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
    Thread thread;
    
    boolean openedConnectionStream = false;

    public SignUp() {

        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        anchorPane0 = new AnchorPane();
        btnBack = new Button();
        imageView = new ImageView();
        anchorPane1 = new AnchorPane();
        btnRegister = new Button();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        txtFieldName = new TextField();
        txtFieldPassword = new TextField();
        txtFieldEmail = new TextField();
        txtFieldRePassword = new TextField();
        anchorPane2 = new AnchorPane();
        label2 = new Label();
        btnLogin = new Button();

        setId("AnchorPane");
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        setStyle("-fx-background-color: #072a40;");

        anchorPane.setLayoutX(79.0);
        anchorPane.setLayoutY(164.0);

        label.setLayoutY(132.0);
        label.setPrefHeight(140.0);
        label.setPrefWidth(252.0);
        label.setText("Toe");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label.setFont(new Font("Berlin Sans FB", 100.0));

        label0.setLayoutY(-29.0);
        label0.setPrefHeight(140.0);
        label0.setPrefWidth(216.0);
        label0.setText("Tic");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label0.setFont(new Font("Berlin Sans FB", 100.0));

        label1.setLayoutX(3.0);
        label1.setLayoutY(52.0);
        label1.setPrefHeight(140.0);
        label1.setPrefWidth(228.0);
        label1.setText("Tac");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label1.setFont(new Font("Berlin Sans FB", 100.0));

        anchorPane0.setLayoutX(39.0);
        anchorPane0.setLayoutY(504.0);

        AnchorPane.setBottomAnchor(btnBack, 21.0);
        AnchorPane.setLeftAnchor(btnBack, 0.0);
        AnchorPane.setRightAnchor(btnBack, 0.0);
        AnchorPane.setTopAnchor(btnBack, 0.0);
        btnBack.setLayoutY(4.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(75.0);
        btnBack.setPrefWidth(185.0);
        btnBack.setStyle("-fx-background-radius: 17;");
        btnBack.setText("       Back");
        btnBack.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        btnBack.setFont(new Font("Berlin Sans FB", 30.0));

        imageView.setFitHeight(48.0);
        imageView.setFitWidth(62.0);
        imageView.setLayoutX(13.0);
        imageView.setLayoutY(17.0);
        imageView.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/backbutton.jfif")));

        AnchorPane.setBottomAnchor(anchorPane1, 21.0);
        AnchorPane.setLeftAnchor(anchorPane1, 396.0);
        AnchorPane.setRightAnchor(anchorPane1, 404.0);
        AnchorPane.setTopAnchor(anchorPane1, 504.0);
        anchorPane1.setLayoutX(396.0);
        anchorPane1.setLayoutY(504.0);
        anchorPane1.setPrefHeight(75.0);
        anchorPane1.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(btnRegister, 0.0);
        AnchorPane.setLeftAnchor(btnRegister, 0.0);
        AnchorPane.setRightAnchor(btnRegister, 0.0);
        AnchorPane.setTopAnchor(btnRegister, 0.0);
        btnRegister.setLayoutX(-4.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(75.0);
        btnRegister.setPrefWidth(200.0);
        btnRegister.setStyle("-fx-background-radius: 17;");
        btnRegister.setText("        Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.valueOf("#011317"));
        btnRegister.setFont(new Font("Berlin Sans FB", 30.0));

        imageView0.setFitHeight(48.0);
        imageView0.setFitWidth(62.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(14.0);
        imageView0.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/signup.png")));
       
        imageView1.setFitHeight(185.0);
        imageView1.setFitWidth(338.0);
        imageView1.setLayoutX(419.0);
        imageView1.setLayoutY(29.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResourceAsStream("/tictactoe/Images/XOLogo.jfif")));

        gridPane.setLayoutX(313.0);
        gridPane.setLayoutY(213.0);
        gridPane.setVgap(12.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        txtFieldName.setPrefHeight(56.0);
        txtFieldName.setPrefWidth(556.0);
        txtFieldName.setPromptText("Name");
        txtFieldName.setStyle("-fx-background-color: trancperant; -fx-border-radius: 20; -fx-border-color: #99a7b0; -fx-border-width: 0.5; -fx-text-fill: #99a7b0;");
        txtFieldName.setFont(new Font("Berlin Sans FB", 25.0));

        GridPane.setRowIndex(txtFieldPassword, 2);
        txtFieldPassword.setPrefHeight(56.0);
        txtFieldPassword.setPrefWidth(563.0);
        txtFieldPassword.setPromptText("Password");
        txtFieldPassword.setStyle("-fx-background-color: trancperant; -fx-border-radius: 20; -fx-border-color: #99a7b0; -fx-border-width: 0.5; -fx-text-fill: #99a7b0;");
        txtFieldPassword.setFont(new Font("Berlin Sans FB", 25.0));

        GridPane.setRowIndex(txtFieldEmail, 1);
        txtFieldEmail.setPrefHeight(56.0);
        txtFieldEmail.setPrefWidth(563.0);
        txtFieldEmail.setPromptText("email");
        txtFieldEmail.setStyle("-fx-background-color: trancperant; -fx-border-radius: 20; -fx-border-color: #99a7b0; -fx-border-width: 0.5; -fx-text-fill: #99a7b0;");
        txtFieldEmail.setFont(new Font("Berlin Sans FB", 25.0));

        GridPane.setRowIndex(txtFieldRePassword, 3);
        txtFieldRePassword.setPrefHeight(56.0);
        txtFieldRePassword.setPrefWidth(564.0);
        txtFieldRePassword.setPromptText("re-Password");
        txtFieldRePassword.setStyle("-fx-background-color: trancperant; -fx-border-radius: 20; -fx-border-color: #99a7b0; -fx-border-width: 0.5; -fx-text-fill: #99a7b0;");
        txtFieldRePassword.setFont(new Font("Berlin Sans FB", 25.0));

        anchorPane2.setLayoutX(689.0);
        anchorPane2.setLayoutY(477.0);
        anchorPane2.setPrefHeight(133.0);
        anchorPane2.setPrefWidth(292.0);

        label2.setPrefHeight(89.0);
        label2.setPrefWidth(353.0);
        label2.setText("Have an account?");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        label2.setFont(new Font("Berlin Sans FB", 30.0));

        btnLogin.setLayoutX(-58.0);
        btnLogin.setLayoutY(45.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(89.0);
        btnLogin.setPrefWidth(293.0);
        btnLogin.setStyle("-fx-background-radius: 17; -fx-background-color: tranceparent;");
        btnLogin.setText("login here");
        btnLogin.setTextFill(javafx.scene.paint.Color.valueOf("#e7ffdb"));
        btnLogin.setFont(new Font("Berlin Sans FB Bold", 33.0));

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(btnBack);
        anchorPane0.getChildren().add(imageView);
        getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(btnRegister);
        anchorPane1.getChildren().add(imageView0);
        getChildren().add(anchorPane1);
        getChildren().add(imageView1);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(txtFieldName);
        gridPane.getChildren().add(txtFieldPassword);
        gridPane.getChildren().add(txtFieldEmail);
        gridPane.getChildren().add(txtFieldRePassword);
        getChildren().add(gridPane);
        anchorPane2.getChildren().add(label2);
        anchorPane2.getChildren().add(btnLogin);
        getChildren().add(anchorPane2);

        
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            
            thread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String s = dis.readLine();
                            System.out.println("respond: " + s);
                            
                            if ("success".equals(s)) {
                                //JOptionPane.showMessageDialog(rootPane, "Registered Successfully.", "TicTacToe", JOptionPane.INFORMATION_MESSAGE);

                                /*Login frame = new Login();
                                frame.setVisible(true);
                                Signup.this.setVisible(false);*/
                                thread.stop();
                            } else {
                                //JOptionPane.showMessageDialog(rootPane, "Username is taken before, choose another username!");
                            }
                        }
                    } catch (IOException ex) {
                        thread.stop();
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            thread.start();
            openedConnectionStream = true;
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Server is not found or turned off.\nTurn server on first.", "Error", JOptionPane.ERROR_MESSAGE);
            showAlertMessage("Error", "Server is not found or turned off.\nTurn server on first.", Alert.AlertType.ERROR);
        }
    }
    
    private void showAlertMessage(String header, String msg, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setHeaderText(header);
        a.setContentText(msg);
        a.show();
    }
}