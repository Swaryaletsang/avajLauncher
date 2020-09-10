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
        message.put("RAIN", "its raining");
        message.put("SNOW", "its snowy");
        message.put("FOG", "its forgy");
        message.put("SUN", "its hot");
        message.put("LAND", "I've got lo land this Helicopter");
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
        System.out.println("Helicopter#"+ this.name + "("+this.id+"): "+ message.get(this.weather));
        if (this.coordinates.getHeight() <= 0) {
            System.out.println(message.get("LAND"));
            this.tower.unregister(this);
            System.out.println("Tower says: " + "Helicopter#"+ this.name + "("+this.id+")"+ " Unregistered from the weather tower");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        // TODO Auto-generated method stub
        this.tower = weatherTower;
        this.tower.register(this);
        System.out.println("Tower says: " + "Helicopter#"+ this.name + "("+this.id+")"+ "Registered to the weather tower");

    }
    
}