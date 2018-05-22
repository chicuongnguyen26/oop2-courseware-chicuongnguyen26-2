package ch.fhnw.oop2.module11.snake.presentationmodels;

/**
 * @author Dieter Holz
 */
public class Terrarium {
    private Slice food;
    private Snake snake;

    private int columns;
    private int rows;

    public Terrarium(int columns, int rows) {
        this.columns   = columns;
        this.rows      = rows;
        this.snake     = new Snake(columns, rows);
        this.food      = new Slice(15, 15);
    }

    public boolean snakeFoundSomeFood(){
        return food.getX() == snake.getHead().getX() &&
               food.getY() == snake.getHead().getY();
    }

    public void nextStep(Direction direction) {
        if (snakeFoundSomeFood()) {
            snake.grow();
            food.setX((int) (Math.random() * rows));
            food.setY((int) (Math.random() * columns));
            snake.setIdlePeriod(Math.max(0.1, snake.getIdlePeriod() - 0.1));
        }

        switch (direction) {
            case UP:
                snake.moveUp();
                break;
            case DOWN:
                snake.moveDown();
                break;
            case LEFT:
                snake.moveLeft();
                break;
            case RIGHT:
                snake.moveRight();
                break;
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public Slice getFood() {
        return food;
    }

    public Snake getSnake() {
        return snake;
    }

}

