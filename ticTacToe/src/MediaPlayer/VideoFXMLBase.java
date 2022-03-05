package MediaPlayer;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public class VideoFXMLBase extends BorderPane {

    protected final MediaView mediaView;
    private String typePlayer;
    public static MediaPlayer mp;
    protected final Label label;
    public VideoFXMLBase(String stringTypePlayer,String playerWinName) {

        mediaView = new MediaView();
        label = new Label();
        setMaxHeight(USE_COMPUTED_SIZE);
        setMaxWidth(USE_COMPUTED_SIZE);
        setMinHeight(USE_COMPUTED_SIZE);
        setMinWidth(USE_COMPUTED_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(400.0);
        if(!playerWinName.isEmpty())
        {
            BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
            label.setText(playerWinName + " wins");
            label.setTextFill(javafx.scene.paint.Color.valueOf("#287149"));
            label.setFont(new Font("Berlin Sans FB Demi Bold", 40.0));
            setTop(label);
        }
        
        BorderPane.setAlignment(mediaView, javafx.geometry.Pos.CENTER);
        mediaView.setFitHeight(USE_COMPUTED_SIZE);
        mediaView.setFitWidth(USE_COMPUTED_SIZE);
        setCenter(mediaView);
        setType(stringTypePlayer);

    }
    
    private void displayVideo() {

        if (typePlayer.equals("winner")) {
            //get video file and set it to media
            setMedia("/videos/win.mp4");
        } else if (typePlayer.equals("loser")) {
            setMedia("/videos/win.mp4");
        }else if (typePlayer.equals("draw")) {
            setMedia("/videos/win.mp4");
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
