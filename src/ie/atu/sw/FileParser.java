package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This abstract class provides basic implementation to parse a file.
 *
 * @author alex
 */
public abstract class FileParser implements Parser{
    /*
    Parses a file, each line is passed to processString()
    Running time: Overall O(n) worst case, where n is the number of lines in the file, assuming that the processString method has a running time of O(1).
    If the processString method has a worse running time, for example O(n),
    then the overall running time of the parseFile method would also be O(n).
     */
    /**
     * Provides basic functionality that parses a file and delegates each line to processLine()
     * Override this if custom parsing is needed. It should parse the
     * element (line, string etc.) and delegate a task for the element by passing it to another method.
     *
     * @param file is taken by the method which should be parsed in some way by the method code
     */
    public void parseFile(String file) {
        try {
            Files.lines(Path.of(file))
                    .forEach(line -> processString(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Abstract method that should be implemented to process a string of text in some way.
     *
     * @param line is a string passed in by another method (parseFile) which is then manipulated in some way or added
     *             directly to a collection.
     */
    public abstract void processString(String line);
}
