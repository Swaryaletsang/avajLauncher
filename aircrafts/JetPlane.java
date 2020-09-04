package aircrafts;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

/**
 * CONCRETE Observer class
 * JetPlane
 */
public class JetPlane extends Aircraft implements Flyable {
    
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub
        System.out.println("Tower says: " + "JetPlane#"+ this.name + "("+this.id+")"+ "Registered to the weather tower");

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub

    }

    
}