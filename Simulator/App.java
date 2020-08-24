package Simulator;

import aircrafts.*;
import interfaces.Flyable;

public class App {
    public static void main(final String[] args) throws Exception {
        //From the txt file
        Flyable x = AircraftFactory.newAircraft("Balloon", "B1", 2, 3, 20);
       x.updateConditions();
       System.out.println("Hi");
    }
}
