package ch.fhnw.oop2.module02.list;

import ch.fhnw.oop2.module01.Person;

import java.util.ArrayList;

/**
 * @author Dieter Holz
 */
public class Family {

    private ArrayList<Person> members = new ArrayList<>();

    public Family(){members = new ArrayList<>();}
    public int size(){
        return members.size();
    }

    public void add(Person p){
        if(isMember(p)){
            return;
        }
        members.add(p);
    }

    public boolean isMember(Person p){
        return members.contains(p);
    }

    public Person getOldest(){
        Person oldest = members.get(0);
        for(Person p : members){
            if(p.getAge() > oldest.getAge()){
                oldest = p;
            }
        }
        return oldest;

    }
}
