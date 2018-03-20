package ch.fhnw.oop2.module04.countries;

import java.util.Comparator;

public class CompareByArea implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2) {
       return (int) o1.getArea() - (int)o2.getArea();
       /*
        if(o1.getArea() < o2.getArea()){
            return -1;
        }else if(o1.getArea() > o2.getArea()){
            return 1;
        }else{
            return 0;
        }
        */
    }
}
