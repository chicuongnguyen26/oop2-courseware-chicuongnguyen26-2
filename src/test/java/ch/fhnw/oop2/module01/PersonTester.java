package ch.fhnw.oop2.module01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTester {

    @Test
    void bmiTest(){
        //given
        Person p = new Person(23,65,1.78);
        //when
        double bmi = p.getBMI();
        //then
        Assertions.assertEquals(20.5, bmi, 0.1);
    }
}
