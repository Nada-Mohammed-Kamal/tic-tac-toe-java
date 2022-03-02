package MediaPlayer;

import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoFXMLBase extends AnchorPane {

    protected final VBox vBox;
    protected final MediaView mediaView;
    
    Stage thisStage;
    private String typePlayer;
    public static MediaPlayer mp;

    public VideoFXMLBase() {

        vBox = new VBox();
        mediaView = new MediaView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        vBox.setLayoutY(-1.0);
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(600.0);

        mediaView.setFitHeight(400.0);
        mediaView.setFitWidth(400.0);

        vBox.getChildren().add(mediaView);
        getChildren().add(vBox);

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
