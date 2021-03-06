package aircrafts;

// import java.io.FileWriter;

import Simulator.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1L;
    protected static String path = "./Simulation.txt";


    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    public long nextId() {
        return idCounter++;

    }

}