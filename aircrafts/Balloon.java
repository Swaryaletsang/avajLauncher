package aircrafts;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

///CONCRETE Observer class

public class Balloon extends Aircraft implements Flyable {

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub
        System.out.println("Tower says: " + "Baloon#"+ this.name + "("+this.nextId()+")"+ "Registered to the weather tower");
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub
        // System.out.println("Tower says: " + "Baloon#"+ this.name + "("+this.nextId()+")"+ "Registered to the weather tower");
        //weatherTower.getWeather(coordinates); //trying my luck
    }
    
}