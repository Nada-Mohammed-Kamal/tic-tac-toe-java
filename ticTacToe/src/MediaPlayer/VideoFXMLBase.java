package MediaPlayer;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoFXMLBase extends AnchorPane {

    protected final MediaView mediaView;
    private String typePlayer;
    public static MediaPlayer mp;

    public VideoFXMLBase(String stringTypePlayer) {

        mediaView = new MediaView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(400.0);

        mediaView.setFitHeight(400.0);
        mediaView.setFitWidth(400.0);

        getChildren().add(mediaView);
        setType(stringTypePlayer);

    }
    
    private void displayVideo() {

        if (typePlayer.equals("winner")) {
            //get video file and set it to media
            setMedia("/videos/winner.mp4");
        } else if (typePlayer.equals("loser")) {
            setMedia("/videos/loser.mp4");
        }else if (typePlayer.equals("draw")) {
            setMedia("/videos/draw.mp4");
        }
    }
    
    private void setMedia(String videoPath) {
        Media media = new Media(getClass().getResource(videoPath).toExternalForm());

        mp = new MediaPlayer(media);
        mediaView.setMediaPlayer(mp);
        DoubleProperty width =  mediaView.fitWidthProperty();
        DoubleProperty height =  mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble( mediaView.parentProperty(), "width"));
        height.bind(Bindings.selectDouble( mediaView.parentProperty(), "height"));
        mediaView.setPreserveRatio(true);
        Platform.runLater(() -> {
            mp.play();
        });
        
                        
                      
    }

    public void setType(String stringTypePlayer) {
        typePlayer = stringTypePlayer;
        System.out.println(typePlayer);
        displayVideo();
    }
}
