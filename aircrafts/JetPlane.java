package aircrafts;

import java.util.HashMap;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

/**
 * CONCRETE Observer class
 * JetPlane
 */
public class JetPlane extends Aircraft implements Flyable {

    private String weather = "";
    private WeatherTower tower;
    private static HashMap<String, String> message = new HashMap<String, String>();
    
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        // TODO Auto-generated constructor stub
        message.put("RAIN", "Ain't no rain gonna stop my shine");
        message.put("SNOW", "Aircon please I'm feeling cold");
        message.put("FOG", "Okay I'm not sure if I'm in the correct lane");
        message.put("SUN", "Can we go to the beach?? I'm feeling lucky");
        message.put("LAND", "I've got to land this JetPlane");
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub
        this.weather = this.tower.getWeather(coordinates);
        Coordinates newCoordinates = null;

        if(this.weather.equals("RAIN")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
        }
        if(this.weather.equals("FOG")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
        }
        if(this.weather.equals("SUN")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
        }
        if(this.weather.equals("SNOW")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
        }
        this.coordinates = newCoordinates;
        FileHandler.write(Aircraft.path, "JetPlane#"+ this.name + "("+this.id+"): "+ message.get(this.weather)+"\n");
        if (this.coordinates.getHeight() <= 0) {
            FileHandler.write(Aircraft.path, message.get("LAND")+"\n");
            this.tower.unregister(this);
            FileHandler.write(Aircraft.path, "Tower says: " + "JetPlane#"+ this.name + "("+this.id+")"+ " Unregistered from the weather tower\n");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub
        this.tower = weatherTower;
        this.tower.register(this);
        FileHandler.write(Aircraft.path, "Tower says: " + "JetPlane#"+ this.name + "("+this.id+")"+ "Registered to the weather tower\n");
    }

    
}