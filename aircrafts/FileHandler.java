package aircrafts;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileHandler {
    private static HashMap<String, FileHandler> m_handlers = new HashMap<>();


    public static FileWriter m_writer;
    // private final BufferedReader m_reader; this one is optional, and I did not instantiate in this example.

    public FileHandler (String path) {
        try {
            m_writer = new FileWriter(path);
        } catch (Exception e) {
            m_writer = null;
            System.out.println(e.getMessage());
            // some exception handling here...
        }            
    }

    public void write(String toWrite) {
        if (m_writer != null) {
            try {
                m_writer.write(toWrite);
                // m_writer.close();
            } catch (IOException e) {
                // some more exception handling...
                System.out.println(e.getMessage());
            }
        }
    }

    public static synchronized void write(String path, String toWrite) {
        FileHandler handler = m_handlers.get(path);
        if (handler == null) {
            handler = new FileHandler(path);
            m_handlers.put(path, handler);
        }

        handler.write(toWrite);

    }
}
