package SnakeGame;

import javafx.scene.paint.Color;
public class SnakePart {

    public SnakePart() {
    }

    public SnakePart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;
    private static Color color = new Color(1, 0, 0, 1);

    private static int width;
    private static int height;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Color getColor() {
        return color;
    }

    public static void setColor(Color color) {
        SnakePart.color = color;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        SnakePart.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        SnakePart.height = height;
    }
}
