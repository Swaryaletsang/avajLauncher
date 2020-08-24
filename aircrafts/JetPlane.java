package aircrafts;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

/**
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

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub

    }

    
}