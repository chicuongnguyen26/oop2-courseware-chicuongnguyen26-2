package ch.fhnw.oop2.module11.snake.presentationmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dieter Holz
 */
class TerrariumTest {

    @Test
    void testInit(){
        //given
        int columns = 30;
        int rows    = 20;

        //when
        Terrarium terrarium = new Terrarium(columns, rows);

        //then
        assertEquals(columns, terrarium.getColumns());
        assertEquals(rows, terrarium.getRows());
        assertNotNull(terrarium.getSnake());

        assertNotNull(terrarium.getFood());
        assertEquals(15, terrarium.getFood().getX());
        assertEquals(15, terrarium.getFood().getY());

        assertEquals(columns, terrarium.getSnake().getColumns());
        assertEquals(rows, terrarium.getSnake().getRows());
    }

    @Test
    public void testSnakeFoundSomeFood(){
        //given
        Terrarium terrarium = new Terrarium(20, 20);
        Slice     snakeHead = terrarium.getSnake().getHead();
        Slice     food      = terrarium.getFood();

        //when
        food.setX(snakeHead.getX());
        food.setY(snakeHead.getY());

        //then
        assertTrue(terrarium.snakeFoundSomeFood());

        //when
        food.setX(snakeHead.getX() + 1);
        food.setY(snakeHead.getY());

        //then
        assertFalse(terrarium.snakeFoundSomeFood());

        //when
        food.setX(snakeHead.getX());
        food.setY(snakeHead.getY() + 1);

        //then
        assertFalse(terrarium.snakeFoundSomeFood());
    }

}