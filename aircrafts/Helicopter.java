package aircrafts;

import java.util.HashMap;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

///CONCRETE Observer class

public class Helicopter extends Aircraft implements Flyable {

    private String weather = "";
    private WeatherTower tower;
    private static HashMap<String, String> message = new HashMap<String, String>();

    Helicopter(final String name, final Coordinates coordinates) {
        super(name, coordinates);
        // TODO Auto-generated constructor stub
        message.put("RAIN", "Oh look its raining");
        message.put("SNOW", "Wow I'm seeing cocane but its cold");
        message.put("FOG", "Crap I can't see!!! the world is defrosting");
        message.put("SUN", "Summer is to die for");
        message.put("LAND", "I've got to land this Helicopter");
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub
        this.weather = this.tower.getWeather(coordinates);
        Coordinates newCoordinates = null;

        if(this.weather.equals("RAIN")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
        }
        if(this.weather.equals("FOG")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
        }
        if(this.weather.equals("SUN")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
        }
        if(this.weather.equals("SNOW")){
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
        }
        this.coordinates = newCoordinates;
        FileHandler.write(Aircraft.path, "Helicopter#"+ this.name + "("+this.id+"): "+ message.get(this.weather)+"\n");
        if (this.coordinates.getHeight() <= 0) {
            FileHandler.write(Aircraft.path, message.get("LAND")+"\n");
            this.tower.unregister(this);
            FileHandler.write(Aircraft.path, "Tower says: " + "Helicopter#"+ this.name + "("+this.id+")"+ " Unregistered from the weather tower\n");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub
        this.tower = weatherTower;
        this.tower.register(this);
        String temp;
        // System.out.println("Tower says: " + "Helicopter#"+ this.name + "("+this.id+")"+ "Registered to the weather tower");
        temp = "Tower says: " + "Helicopter#"+ this.name + "("+this.id+")"+ "Registered to the weather tower\n";
        FileHandler.write(Aircraft.path, temp);
    }
    
}