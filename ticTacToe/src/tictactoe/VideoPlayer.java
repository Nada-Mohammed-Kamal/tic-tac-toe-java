/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/*
 *
 * @author a
 */
public class VideoPlayer extends Application {
    static Media m;
    static MediaPlayer mediaPanel;
    MediaPlayer player;
    Media media;
    MediaView MV;
    Thread t;
    Stage pr;
    @Override
    public void start(Stage primaryStage){
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                createScene(primaryStage);
            }
        });
    }

       private void createScene(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
                try{
            
            File file = new File("1.mp4");//Video Folder Should Be in the Same Of .java File path
            if(file != null){
                String mediaUrl = file.toURI().toString();
                System.out.println(""+mediaUrl);
                mediaUrl="/tictactoe/1.mp4";
                if(mediaUrl !=null){
                    
                    media = new Media(mediaUrl);
                    player = new MediaPlayer(media);
                    MV=new MediaView(player);
                    StackPane root=new StackPane();
                    root.getChildren().add(MV);
                    primaryStage.setScene(new Scene(root,480,294));
                    primaryStage.setMaxHeight(294);
                    primaryStage.setMaxWidth(480);
                    primaryStage.setTitle("Congratulations For Wining");  
                    primaryStage.show(); 
                    player.play();
                   
                   
                   
                    
                
                }else{
                    System.out.println("File Not Found");
                }
            }else{
                System.out.println("File Not Found");
            }
        }catch(Exception ex){
            System.out.println("File Not Found");
        }

        
    }
     private void stopmyPro() {
           pr.close();                
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    
}