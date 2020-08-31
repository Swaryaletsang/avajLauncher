package Simulator;

import java.util.*;

import interfaces.Flyable;

///OBSERVER Subject

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister (Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
    public void checkplanes(){
        conditionsChanged();

        //System.out.println(observers);
    }
}