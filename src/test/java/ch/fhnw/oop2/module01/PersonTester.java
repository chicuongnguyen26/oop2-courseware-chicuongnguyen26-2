package ch.fhnw.oop2.module01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTester {

    @Test
    void bmiTest(){
        Person p = new Person(23,65,1.78);

        double bmi = p.getBMI();

        Assertions.assertEquals(20.5, bmi, 0.1);
    }
}
