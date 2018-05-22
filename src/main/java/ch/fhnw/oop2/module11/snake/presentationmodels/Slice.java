package ch.fhnw.oop2.module11.snake.presentationmodels;

/**
 * @author Dieter Holz
 */
public class Slice {
    private int x;
    private int y;

    public Slice(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
}
