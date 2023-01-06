package ie.atu.sw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IndexFileWriter {
    // Takes collection which stores word details and outputs them to a text file or csv file.
    public static void save(HashMap<String, WordDetail> map, String outputFile) {
        IndexExtraOptions extraOptions = new IndexExtraOptions(map);
        try (FileWriter writer = new FileWriter(outputFile)){
            writer.write("Word Definition & Page Index\r\n-----------------------------------------------------------------");
            writer.write(System.getProperty( "line.separator" ));
            for (Map.Entry<String, WordDetail> entry : map.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue().toString() + "\n");
                writer.write(System.getProperty( "line.separator" ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
