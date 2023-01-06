package ie.atu.sw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method for writing the index hashmap to a file.
 *
 * @author alex
 */
public class IndexFileWriter {
    private Map<String, WordDetail> map = null;

    // Takes collection which stores word details and outputs them to a text file or csv file.
    // Running time: O(n) because the worst case would entail looping over the entire hashmap n times.
    /**
     * Saves the given map to the specified output file.
     *
     * @param map the map to be saved
     * @param outputFile the file to write the map to
     */
    public void save(Map<String, WordDetail> map, String outputFile) {
        HashMap<String, WordDetail> index = new HashMap<>(map);
        try (FileWriter writer = new FileWriter(outputFile)){
            writer.write("Word Definition & Page Index\r\n-----------------------------------------------------------------");
            writer.write(System.getProperty( "line.separator" ));
            for (Map.Entry<String, WordDetail> entry : index.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue().toString() + "\n");
                writer.write(System.getProperty( "line.separator" ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
