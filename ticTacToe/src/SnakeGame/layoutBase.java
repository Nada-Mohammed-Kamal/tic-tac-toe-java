package SnakeGame;

import Navigation.Navigation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class layoutBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final Menu menu0;
    protected final MenuItem menuItem1;
    protected final HBox hBox;
    protected final Pane pane;
    protected final Text text;
    protected final Canvas canvas;
    private Game game;
    private Timeline timeline;
    public layoutBase(Stage stage) {

        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menu0 = new Menu();
        menuItem1 = new MenuItem();
        hBox = new HBox();
        pane = new Pane();
        text = new Text();
        canvas = new Canvas();

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        menuBar.setStyle("-fx-background-color: #828270;");

        menu.setMnemonicParsing(false);
        menu.setText("Game");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("New Game");
        menuItem.setOnAction((value)->{
            game = new Game();
            repaint();
        });
        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Exit");
        menuItem0.setOnAction((value)->{
            Navigation.navigateToHome(stage);
        });
        menu0.setMnemonicParsing(false);
        menu0.setText("Edit");
        menu0.setOnAction((value)->{
            showColorPicker();
        });
        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Set snake color");
        setTop(menuBar);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);

        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);
        pane.setStyle("-fx-background-color: #072a40;");

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(40.0);
        text.setLayoutY(47.0);
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(100.0);
        text.setFont(new Font("Arial", 20.0));

        canvas.setFocusTraversable(true);
        canvas.setHeight(400.0);
        canvas.setOnKeyPressed(this::keyHandler);
        canvas.setWidth(400.0);
        setCenter(hBox);

        menu.getItems().add(menuItem);
        menu.getItems().add(menuItem0);
        menuBar.getMenus().add(menu);
        menu0.getItems().add(menuItem1);
        menuBar.getMenus().add(menu0);
        pane.getChildren().add(text);
        hBox.getChildren().add(pane);
        hBox.getChildren().add(canvas);

    }

   private void keyHandler(KeyEvent e) {
        if (e.getCode() == KeyCode.RIGHT) {
            game.snake.setDirection(Directions.RIGHT);
        }
        else if(e.getCode() == KeyCode.UP) {
            game.snake.setDirection(Directions.UP);
        }
        else if(e.getCode() == KeyCode.LEFT) {
            game.snake.setDirection(Directions.LEFT);
        }
        else if(e.getCode() == KeyCode.DOWN) {
            game.snake.setDirection(Directions.DOWN);
        }
    }
  private void showColorPicker() {
        VBox box = new VBox();
        ColorPicker colorPicker = new ColorPicker();
        Button ok = new Button("Ok");
        
        box.getChildren().addAll(colorPicker, ok);
        Scene scene = new Scene(box);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        ok.setOnMouseClicked((MouseEvent event1) -> {
            SnakePart.setColor(colorPicker.getValue());
            stage.close();
        });
        
    }
    public void repaint() {
        Duration duration = Duration.millis(250);
        timeline = new Timeline(new KeyFrame(duration, (ActionEvent event) -> {
            Paint paint = Paint.valueOf("white");
            text.setFill(paint);
            text.setText("Your score: "+String.valueOf(game.getScore()));
            GraphicsContext context = canvas.getGraphicsContext2D();
            if ( !game.isGameOver() ) {
                Paint paint1 = Paint.valueOf("gray");
                //Color blue = new Color(0.7,0.42,0.64,1);
                context.setFill(paint1);
                context.fillRect(0, 0, 400, 400);
                game.snake.getSnake().stream().forEach((part) -> {
                    context.setFill(SnakePart.getColor());
                    context.fillRect(part.getX(), part.getY(), SnakePart.getWidth(), SnakePart.getHeight());
                });
                context.setFill(Food.getColor());
                context.fillRect(game.food.getX(), game.food.getY(), SnakePart.getWidth(), SnakePart.getHeight());
            }
            else {
                Paint paint1 = Paint.valueOf("white");
                Paint paint2 = Paint.valueOf("gray");
                context.setFill(paint1);
                context.fillRect(0, 0, 400, 400);
                context.setFill(paint2);
                context.setFont(new Font(24));
                context.setTextAlign(TextAlignment.CENTER);
                context.fillText("Game Over!", 200, 200);
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
