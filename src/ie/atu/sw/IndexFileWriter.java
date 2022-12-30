package ie.atu.sw;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IndexFileWriter {
    private String outputFile = null;

    public IndexFileWriter(String outputFile) {
        this.outputFile = outputFile;
    }

    // Takes collection which stores word details and outputs them to a text file or csv file.

    public static void save(HashMap<String, WordDetail> map, String fileName) {
        try {
            // create a FileWriter object
            FileWriter writer = new FileWriter(fileName);
            // iterate over the map and write each key-value pair to the file
            for (Map.Entry<String, WordDetail> entry : map.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            // close the writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, WordDetail> cleanIndex() {
        //TODO
        return null;
    }

}
