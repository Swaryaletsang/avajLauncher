package Simulator;

import java.util.*;

import interfaces.Flyable;

///OBSERVER Subject

public class Tower {
    private List<Flyable> aircrafts = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        aircrafts.add(flyable);
    }

    public void unregister (Flyable flyable) {
        aircrafts.remove(flyable);  
    }

    protected void conditionsChanged(){
        for (int i = 0; i < aircrafts.size(); i++) {
            int size = this.aircrafts.size();
            try {
                aircrafts.get(i).updateConditions();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
            if (this.aircrafts.size() < size)
                i--;
        }
        // APARENTLY ITS A BAD IDEA TO USE A FOR EACH TO ITERATE AN ARRAYLIST
        // for (Flyable flyable : observers) {
        //     flyable.updateConditions();
        // }
    }
}