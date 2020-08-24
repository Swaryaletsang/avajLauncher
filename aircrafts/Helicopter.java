package aircrafts;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable {

    Helicopter(final String name, final Coordinates coordinates) {
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