package Simulator;
/////SINGLETON
public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;

    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        //still to coded
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
            return weatherProvider;
        }
        return weatherProvider;

    }

    public String getCurrentWeather(Coordinates coordinates) {
        return "";
    }
}