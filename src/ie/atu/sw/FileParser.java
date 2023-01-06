package ie.atu.sw;

import java.util.Collection;

/**
 * This interface should be implemented by a class that parses a file. The methods should be implemented in a way
 * where they can parse the desired file type and add it to a data structure if needed.
 *
 * @author alex
 */
public interface FileParser {
    /**
     * The implementation of this method should involve parsing a file of some sort, it should then ideally parse the
     * element (line, string etc.) and delegate a task for the element by passing it to another method.
     *
     * @param filePath is taken by the method which should be parsed in some way by the method code
     */
    void parseFile(String filePath);

    /**
     * This method implementation should manipulate a String line if desired, or add the line directly to a collection
     * in the implementing class.
     *
     * @param line is a string passed in by another method (parseFile) which is then manipulated in some way or added
     *             directly to a collection.
     */
    void processLine(String line);
}
