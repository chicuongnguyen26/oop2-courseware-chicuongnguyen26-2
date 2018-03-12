package ch.fhnw.oop2.module03.cage;

public class Cage<T extends Animal> {
    private T content;

    public void add(T content){
        this.content = content;
    }
    public boolean isInCage(Animal animal){
        return content.equals(animal);
    }
}
