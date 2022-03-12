
package SnakeGame;

import java.util.ArrayList;

/**
 *
 * @author nada
 */
public class Snake {

    public Snake() {
        SnakePart.setWidth(20);
        SnakePart.setHeight(20);
        SnakePart head = new SnakePart(200, 200);
        snake.add(head);
    }

    private ArrayList<SnakePart> snake = new ArrayList<>();
    private int direction;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (snake.size() >= 2) {
            switch (direction) {
                case Directions.RIGHT:
                    if (snake.get(0).getX() + 20 != snake.get(1).getX()) {
                        this.direction = direction;
                    }
                    break;
                case Directions.UP:
                    if (snake.get(0).getY() - 20 != snake.get(1).getY()) {
                        this.direction = direction;
                    }
                    break;
                case Directions.LEFT:
                    if (snake.get(0).getX() - 20 != snake.get(1).getX()) {
                        this.direction = direction;
                    }
                    break;
                case Directions.DOWN:
                    if (snake.get(0).getY() + 20 != snake.get(1).getY()) {
                        this.direction = direction;
                    }
                    break;

            }
        } else {
            this.direction = direction;
        }
    }

    public ArrayList<SnakePart> getSnake() {
        return snake;
    }

    public boolean isConflicted(double x, double y) {
        //snake with it self 
        for (int j = snake.size() - 1; j > 0; --j) {
            if (snake.get(0).getX() == snake.get(j).getX()
                    && snake.get(0).getY() == snake.get(j).getY()) {
                return true;
            }
        }
        //screen
        return 
                snake.get(0).getX() == x
                || snake.get(0).getX() == (0 - SnakePart.getWidth())
                || snake.get(0).getY() == y
                || snake.get(0).getY() == (0 - SnakePart.getHeight());
    }

    public boolean update(Food food, double x, double y) {
        for (int i = snake.size() - 1; i >= 0; --i) {
            if (i == 0) {
                switch (direction) {
                    case Directions.RIGHT:
                        snake.get(0).setX(snake.get(0).getX() + 20);
                        break;
                    case Directions.UP:
                        snake.get(0).setY(snake.get(0).getY() - 20);
                        break;
                    case Directions.LEFT:
                        snake.get(0).setX(snake.get(0).getX() - 20);
                        break;
                    case Directions.DOWN:
                        snake.get(0).setY(snake.get(0).getY() + 20);
                        break;        
                }
                
                if (isConflicted(x, y))
                    return false;
                
                if (snake.get(i).getX() == food.getX()
                        && snake.get(i).getY() == food.getY()) {
                    food.setEated(true);
                    SnakePart newSnakePart = new SnakePart
                    (snake.get(snake.size() - 1).getX(),
                     snake.get(snake.size() - 1).getY());
                    snake.add(newSnakePart);
                }
            } else {
                snake.get(i).setX(snake.get(i - 1).getX());
                snake.get(i).setY(snake.get(i - 1).getY());
            }
        }
        return true;
    }
}
