package aircrafts;

import java.io.IOException;
import java.util.HashMap;

import Simulator.Coordinates;
import Simulator.WeatherTower;
import interfaces.Flyable;

///CONCRETE Observer class

public class Balloon extends Aircraft implements Flyable {

    private String weather = "";
    private WeatherTower tower;
    private static HashMap<String, String> message = new HashMap<String, String>();

    Balloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        message.put("RAIN", "its raining, Should've taken a bus");
        message.put("SNOW", "Whoa this feels like I'm in a Regrigirator");
        message.put("FOG", "FOG FOG FOG Everywhere");
        message.put("SUN", "its a shiny day lets take pictures");
        message.put("LAND", "I've got to land this balloon");
    }

    @Override
    public void updateConditions() {
        // TODO Auto-generated method stub
        this.weather = this.tower.getWeather(coordinates);
        Coordinates newCoordinates = null;

        if (this.weather.equals("RAIN")) {
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 5);
        }
        if (this.weather.equals("FOG")) {
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 3);
        }
        if (this.weather.equals("SUN")) {
            newCoordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 4);
        }
        if (this.weather.equals("SNOW")) {
            newCoordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 15);
        }
        this.coordinates = newCoordinates;
        FileHandler.write(Aircraft.path, "Baloon#" + this.name + "(" + this.id + "): " + message.get(this.weather)+"\n");
        if (this.coordinates.getHeight() <= 0) {
            FileHandler.write(Aircraft.path, message.get("LAND")+"\n");
            this.tower.unregister(this);
            FileHandler.write(Aircraft.path, "Tower says: " + "Baloon#"+ this.name + "("+this.id+")"+ " Unregistered from the weather tower\n");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws IOException {
        // TODO Auto-generated method stub
        this.tower = weatherTower;
        this.tower.register(this);
        String temp;
        // System.out.println("Tower says: " + "Baloon#"+ this.name + "("+this.id+")"+ "Registered to the weather tower");
        temp = "Tower says: " + "Baloon#"+ this.name + "("+this.id+")"+ "Registered to the weather tower\n";
        FileHandler.write(Aircraft.path, temp);
    }
    
}