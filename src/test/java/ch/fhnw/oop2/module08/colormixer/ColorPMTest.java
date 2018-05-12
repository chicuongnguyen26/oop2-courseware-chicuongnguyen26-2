package ch.fhnw.oop2.module08.colormixer;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorPMTest {
    @Test
    void testMischMasch(){
        //given
        ColorPM pm = new ColorPM();

        //when
        pm.setGreen(0);
        pm.setBlue(0);
        pm.setRed(255);

        //then
        assertEquals(Color.rgb(255,0,0), pm.getMischMasch());
    }

}