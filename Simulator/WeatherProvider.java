package Simulator;
/////SINGLETON
public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;

    }

    public String getCurrentWeather(Coordinates coordinates) {
        int gen = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();

        return weather[gen % 4];
    }
}