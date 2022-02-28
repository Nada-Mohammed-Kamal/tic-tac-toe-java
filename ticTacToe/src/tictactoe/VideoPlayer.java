/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
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
                try{
            
           // File file = new File("/tictactoe/video/1.mp4");//Video Folder Should Be in the Same Of .java File path
            
                File mediaUrl = new File("C:/Users/Esraa/Documents/GitHub/tic-tac-toe-java/ticTacToe/src/tictactoe/video/1.mp4");
                System.out.println(""+mediaUrl);
                //mediaUrl="/tictactoe/video/1.mp4";
                if(mediaUrl !=null){
                    
                    media = new Media(mediaUrl.toURI().toString());
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
           
        }catch(Exception ex){
            System.out.println("File Not Found");
        }

        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    
}
