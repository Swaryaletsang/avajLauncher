package aircrafts;

import java.io.FileWriter;

import Simulator.Coordinates;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 1L;
    protected static FileWriter writer;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
        try {
            writer = new FileWriter("./Simulation.txt"); 
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public long nextId() {
        return idCounter++;

    }

}