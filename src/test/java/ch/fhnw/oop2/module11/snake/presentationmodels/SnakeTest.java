package ch.fhnw.oop2.module11.snake.presentationmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author Dieter Holz
 */
class SnakeTest {

    @Test
    void testInit() {
        //given
        int columns = 20;
        int rows    = 30;

        //when
        Snake snake = new Snake(columns, rows);

        //then
        assertEquals(columns, snake.getColumns());
        assertEquals(rows, snake.getRows());

        assertNotNull(snake.getHead());
        assertNotNull(snake.getBody());
        assertEquals(4, snake.size());

        assertEquals(10, snake.getHead().getX());
        assertEquals(5 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(6 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(7 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(8 , snake.getBody().get(2).getY());
    }

    @Test
    void testGrow(){
        //given
        Snake snake = new Snake(20, 20);
        int   size  = snake.size();
        Slice tail  = snake.getBody().get(snake.getBody().size() - 1);

        //when
        snake.grow();

        //then
        Slice newTail = snake.getBody().get(snake.getBody().size() - 1);

        assertEquals(size + 1, snake.size());
        assertNotSame(tail, newTail);
        assertEquals(tail.getX(), newTail.getX());
        assertEquals(tail.getY(), newTail.getY());
    }

    @Test
    void testMoveUp(){
        //given
        Snake snake = new Snake(20, 20);

        //when
        snake.moveUp();

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(4 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(5 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(6 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(7 , snake.getBody().get(2).getY());

        //when

        do {
            snake.moveUp();
        } while (snake.getHead().getY() > 0); //move to top


        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(0 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(1 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(2 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(3 , snake.getBody().get(2).getY());

        //when
        snake.moveUp();  //move another step up

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(19 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(0 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(1 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(2 , snake.getBody().get(2).getY());

        //when
        snake.moveUp();

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(18, snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(19, snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(0 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(1 , snake.getBody().get(2).getY());
    }

    @Test
    void testMoveDown(){
        //given
        Snake snake = new Snake(20, 20);


        //when
        snake.moveDown();

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(6 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(5 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(6 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(7 , snake.getBody().get(2).getY());


        //when
        do {
            snake.moveDown();
        } while (snake.getHead().getY() < 19); //move to bottom

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(19, snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(18, snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(17, snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(16, snake.getBody().get(2).getY());

        //when
        snake.moveDown();  //move another step down

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(0, snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(19, snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(18, snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(17, snake.getBody().get(2).getY());

        //when
        snake.moveDown();

        //then
        assertEquals(10, snake.getHead().getX());
        assertEquals(1 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(0 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(19, snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(18, snake.getBody().get(2).getY());
    }

    @Test
    void moveRight(){
        //given
        int rows = 20;
        int columns = 20;
        Snake snake = new Snake(columns, rows);

        //when
        snake.moveRight();

        //then
        assertEquals(11, snake.getHead().getX());
        assertEquals(5 , snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(5 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(6 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(7 , snake.getBody().get(2).getY());

        //when
        do {
            snake.moveRight();
        } while (snake.getHead().getX() < columns - 1); //move to right edge

        //then
        assertEquals(columns - 1, snake.getHead().getX());
        assertEquals(5          , snake.getHead().getY());

        assertEquals(columns - 2, snake.getBody().get(0).getX());
        assertEquals(5          , snake.getBody().get(0).getY());

        assertEquals(columns - 3, snake.getBody().get(1).getX());
        assertEquals(5          , snake.getBody().get(1).getY());

        assertEquals(columns - 4, snake.getBody().get(2).getX());
        assertEquals(5          , snake.getBody().get(2).getY());

        //when
        snake.moveRight();

        //then
        assertEquals(0, snake.getHead().getX());
        assertEquals(5, snake.getHead().getY());

        assertEquals(columns - 1, snake.getBody().get(0).getX());
        assertEquals(5          , snake.getBody().get(0).getY());

        assertEquals(columns - 2, snake.getBody().get(1).getX());
        assertEquals(5          , snake.getBody().get(1).getY());

        assertEquals(columns - 3, snake.getBody().get(2).getX());
        assertEquals(5          , snake.getBody().get(2).getY());

        //when
         snake.moveRight();

         //then
         assertEquals(1, snake.getHead().getX());
         assertEquals(5, snake.getHead().getY());

         assertEquals(0, snake.getBody().get(0).getX());
         assertEquals(5, snake.getBody().get(0).getY());

         assertEquals(columns - 1, snake.getBody().get(1).getX());
         assertEquals(5          , snake.getBody().get(1).getY());

         assertEquals(columns - 2, snake.getBody().get(2).getX());
         assertEquals(5          , snake.getBody().get(2).getY());
    }

    @Test
    void moveLeft(){
        //given
        int rows = 20;
        int columns = 20;
        Snake snake = new Snake(columns, rows);

        //when
        snake.moveLeft();

        //then
        assertEquals(9, snake.getHead().getX());
        assertEquals(5, snake.getHead().getY());

        assertEquals(10, snake.getBody().get(0).getX());
        assertEquals(5 , snake.getBody().get(0).getY());

        assertEquals(10, snake.getBody().get(1).getX());
        assertEquals(6 , snake.getBody().get(1).getY());

        assertEquals(10, snake.getBody().get(2).getX());
        assertEquals(7 , snake.getBody().get(2).getY());

        //when
        do {
            snake.moveLeft();
        } while (snake.getHead().getX() > 0); //move to right edge

        //then
        assertEquals(0, snake.getHead().getX());
        assertEquals(5, snake.getHead().getY());

        assertEquals(1, snake.getBody().get(0).getX());
        assertEquals(5, snake.getBody().get(0).getY());

        assertEquals(2, snake.getBody().get(1).getX());
        assertEquals(5, snake.getBody().get(1).getY());

        assertEquals(3, snake.getBody().get(2).getX());
        assertEquals(5, snake.getBody().get(2).getY());

        //when
        snake.moveLeft();

        //then
        assertEquals(columns - 1, snake.getHead().getX());
        assertEquals(5, snake.getHead().getY());

        assertEquals(0, snake.getBody().get(0).getX());
        assertEquals(5, snake.getBody().get(0).getY());

        assertEquals(1, snake.getBody().get(1).getX());
        assertEquals(5, snake.getBody().get(1).getY());

        assertEquals(2, snake.getBody().get(2).getX());
        assertEquals(5, snake.getBody().get(2).getY());

        //when
         snake.moveLeft();

         //then
         assertEquals(columns - 2, snake.getHead().getX());
         assertEquals(5, snake.getHead().getY());

         assertEquals(columns - 1, snake.getBody().get(0).getX());
         assertEquals(5, snake.getBody().get(0).getY());

         assertEquals(0, snake.getBody().get(1).getX());
         assertEquals(5, snake.getBody().get(1).getY());

         assertEquals(1, snake.getBody().get(2).getX());
         assertEquals(5, snake.getBody().get(2).getY());
    }
}