package interfaces;

import java.io.IOException;

import Simulator.WeatherTower;

//OBSERVER CLASS

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower) throws IOException;
}