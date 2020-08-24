package aircrafts;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

public class Balloon extends Aircraft implements Flyable {

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub
        System.out.println("hello there");

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub
        
    }
    
}