package ch.fhnw.oop2.module03.cage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CageTest<T extends Animal> {
    @Test
    void testInit(){
        //given


        //when
        Cage<Lion> cage = new Cage<>();
        //then
    }

    @Test
    void testAdd(){
        //given
        Cage<Bird> cage = new Cage<>();
        Bird b = new Bird();
        Lion l = new Lion();
        //when
        cage.add(b);
        //then
        Assertions.assertTrue(cage.isInCage(b)); // b im Cage??
        Assertions.assertFalse(cage.isInCage(l)); // l nicht im Cage
    }
}
