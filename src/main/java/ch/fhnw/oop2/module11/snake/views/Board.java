package ch.fhnw.oop2.module11.snake.views;

import java.util.Arrays;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import ch.fhnw.oop2.module11.snake.presentationmodels.Direction;
import ch.fhnw.oop2.module11.snake.presentationmodels.Slice;
import ch.fhnw.oop2.module11.snake.presentationmodels.Snake;
import ch.fhnw.oop2.module11.snake.presentationmodels.Terrarium;

/**
 * @author Dieter Holz
 */
public class Board extends StackPane implements ViewMixin {
    private static final int BOARD_WIDTH  = 400;
    private static final int BOARD_HEIGHT = 400;

    private static final List<Direction> CLOCKWISE         = Arrays.asList(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP);
    private static final List<Direction> COUNTER_CLOCKWISE = Arrays.asList(Direction.UP, Direction.LEFT, Direction.DOWN, Direction.RIGHT, Direction.UP);

    private final Terrarium terrarium;

    private Canvas canvas;

    private Direction currentDirection;
    private Color     currentGridColor;
    private boolean   snakeIsMoving;
    private int       gridWidth;
    private int       gridHeight;

    private AnimationTimer timer = new AnimationTimer() {
        private long lastTimerCall;
        @Override
        public void handle(long now) {
        if(now > lastTimerCall + (terrarium.getSnake().getIdlePeriod() * 1_000_000_000L)){
            //todo
            //something is missing
            lastTimerCall = now;
        }
        }
    };

    public Board(Terrarium terrarium) {
        this.terrarium = terrarium;
        init();

        toggleSnakeMoving();
        redraw();

        timer.start();
    }

    @Override
    public void initializeSelf() {
        gridWidth = BOARD_WIDTH / terrarium.getColumns();
        gridHeight = BOARD_HEIGHT / terrarium.getRows();

        currentDirection = Direction.UP;
        currentGridColor = Color.rgb(60, 60, 60);
        snakeIsMoving = false;
    }

    @Override
    public void initializeControls() {
        canvas = new Canvas(BOARD_WIDTH, BOARD_HEIGHT);
        canvas.setFocusTraversable(true);
        canvas.requestFocus();
    }

    @Override
    public void layoutControls() {
        getChildren().add(canvas);
    }

    @Override
    public void setupEventHandlers() {
        canvas.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    currentDirection = COUNTER_CLOCKWISE.get(COUNTER_CLOCKWISE.indexOf(currentDirection) + 1);
                    event.consume();
                    break;
                case RIGHT:
                    currentDirection = CLOCKWISE.get(CLOCKWISE.indexOf(currentDirection) + 1);
                    event.consume();
                    break;
                case SPACE:
                    toggleSnakeMoving();
                    event.consume();
                    break;
            }
        });

        canvas.setOnMouseClicked(event -> {
            terrarium.nextStep(currentDirection);
            redraw();
        });

    }

    private void toggleSnakeMoving() {
        if(snakeIsMoving){
            timer.start();
        }
        else{
            timer.stop();
        }
        snakeIsMoving = !snakeIsMoving;
    }

    private void redraw() {
        drawBackground();
        drawSnake();
        drawFood();
    }

    private void drawBackground() {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        int newRed = Math.max(0, 100 - (terrarium.getSnake().size() * 10));
        if (((int) (currentGridColor.getRed() * 255)) > newRed) {
            currentGridColor = Color.rgb(newRed, newRed, newRed);
        }
        context.setStroke(currentGridColor);
        context.strokeRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
        for (int i = 1; i < terrarium.getColumns(); i++) {
            context.strokeLine(i * gridWidth, 0, i * gridWidth, BOARD_HEIGHT);
        }
        for (int i = 1; i < terrarium.getRows(); i++) {
            context.strokeLine(0, i * gridHeight, BOARD_WIDTH, i * gridWidth);
        }
    }

    private void drawFood() {
        Slice food = terrarium.getFood();
        if (food != null) {
            fillBox(food.getX(), food.getY(), Color.RED);
        }
    }

    private void drawSnake() {
        Snake snake = terrarium.getSnake();
        if (snake != null && snake.getBody() != null && snake.getHead() != null) {
            for (Slice slice : snake.getBody()) {
                fillBox(slice.getX(), slice.getY(), Color.CYAN);
            }
            fillBox(snake.getHead().getX(), snake.getHead().getY(), Color.GREEN);
        }
    }

    private void fillBox(int x, int y, Color color) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(color);
        context.fillRect(x * gridWidth + 1, y * gridHeight + 1, gridWidth - 2, gridHeight - 2);
    }
}
