package ch.fhnw.oop2.module11.snake.presentationmodels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dieter Holz
 */
public class Snake {
    private final int columns;
    private final int rows;

    private final List<Slice> body;
    private final Slice       head;

    private double idlePeriod = 0.8;

    public Snake(int columns, int rows) {
        this.columns = columns;
        this.rows    = rows;

        head = new Slice(10, 5);

        body = new ArrayList<>();
        body.add(new Slice(10, 6));
        body.add(new Slice(10, 7));
        body.add(new Slice(10, 8));
    }

    public Slice getHead() {
        return head;
    }

    public List<Slice> getBody() {
        return body;
    }

    public int size(){
        return body.size() + 1;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void grow() {
        Slice lastSlice = body.get(body.size() - 1);
        Slice newSlice  = new Slice(lastSlice.getX(), lastSlice.getY());
        body.add(newSlice);
    }

    public void moveUp() {
        move(0, -1);
    }

    public void moveDown() {
        move(0, 1);
    }

    public void moveLeft() {
        move(-1, 0);
    }

    public void moveRight() {
        move(1, 0);
    }

    private void move(int dx, int dy) {
        for (int i = (body.size() - 1); i > 0; i--) {
            Slice predecessor = body.get(i - 1);
            Slice current     = body.get(i);

            current.setX(predecessor.getX());
            current.setY(predecessor.getY());
        }
        Slice firstBodySlice = body.get(0);
        firstBodySlice.setX(head.getX());
        firstBodySlice.setY(head.getY());

        head.setX(head.getX() + dx);
        head.setY(head.getY() + dy);

        if (head.getX() < 0) {
            head.setX(rows - 1);
        } else if (head.getX() > rows - 1) {
            head.setX(0);
        }

        if (head.getY() < 0) {
            head.setY(columns - 1);
        } else if (head.getY() > columns - 1) {
            head.setY(0);
        }
    }

    public double getIdlePeriod() {
        return idlePeriod;
    }

    public void setIdlePeriod(double idlePeriod) {
        this.idlePeriod = idlePeriod;
    }
}
