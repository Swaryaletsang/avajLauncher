package interfaces;

import Simulator.WeatherTower;

//OBSERVER CLASS

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}