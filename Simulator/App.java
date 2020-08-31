package Simulator;

import aircrafts.*;
import interfaces.Flyable;

import java.io.*;
import java.util.*;

public class App {

    public static void main(final String[] args) throws IOException {
        if (args.length == 1) {
            FileReader fileReader = new FileReader(args[0]);
            fileReader.fileContents();

            if (fileReader.verifyContent() == 1){
                Flyable x = null;
               // int run = Integer.parseInt(fileReader.fileContent.get(0));
                String[] planes = {};
                for (int i = 1; i < fileReader.fileContent.size(); i++) {
                    planes = fileReader.fileContent.get(i).split(" ", 5);
                    
                    //Simulate
                    x = AircraftFactory.newAircraft(planes[0], planes[1],Integer.parseInt(planes[2]),Integer.parseInt(planes[3]), Integer.parseInt(planes[4]));
                    System.out.println(Integer.parseInt(planes[3]));
                    if (x == null)
                        System.out.println("X is null for some reason");
                }
            }else{
                //Error Message
                System.out.println("Scenario file content error: Unexpected input");
            }   
        }else{
            System.out.println("Come on dude you didnt give me a scenario file as an argument");
        }
    }
}

/**
 * FileReader
 */
class FileReader {
    File file;
    ArrayList<String> fileContent = new ArrayList<String>();
    FileReader(String file){
        this.file = new File(file);
    }

    public void fileContents() {
        if (getExtention(this.file) == 1) {
            try {
                Scanner scan = new Scanner(this.file);
                
                while (scan.hasNextLine()){
                    this.fileContent.add(scan.nextLine());
                }
                scan.close();    
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }else{
            System.out.println("Invalid file, .txt file required!!!");
        }
    }

    public static int getExtention(File f){
        String ext;
        if (f.getName().indexOf(".") == -1){
            ext = "";
        }else {
            ext = (f.getName().substring(f.getName().length() - 3, f.getName().length()));
        }

        if (ext.equals("txt")) {
            return 1;
        }
        return 0;
    }
    public int verifyContent() {

    String[] array = { "Baloon", "JetPlane", "Helicopter"};
    String[] newArr = {};
    int index = 0;
    String line1 = this.fileContent.get(0);
    if (Integer.parseInt(line1) > 0) {
        for (int i = 1; i < this.fileContent.size(); i++) {

            newArr = this.fileContent.get(i).split(" ", 5);
            index = Arrays.binarySearch(array, newArr[0]); //come back and review the binary search BUG!!!

            if (index == -1 || (Integer.parseInt(newArr[2]) < 0) || (Integer.parseInt(newArr[3]) < 0) || (Integer.parseInt(newArr[4]) < 0)){
                return (0);
            }
                
        }   
    }else{
        return (0);
    }
    return (1);
}
}
