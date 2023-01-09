package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * This class offers methods responsible for parsing a text file and it delegates the responsibilty of
 * building an index to a class called IndexBuilder, as a result it depends on an IndexBuilder to work
 * properly.
 *
 *
 * @author alex
 */
public class TextFileParser extends FileParser {
    private int page = 0;
    private int lineNumber = 0;
    private IndexBuilder builder = null;
    private String textFile = null;

    /**
     * A constructor which depends on an IndexBuilder for the object to be created.
     * 
     * @param builder the object needed to execute the tasks within TextFileParser
     */
    public TextFileParser(IndexBuilder builder) {
        this.builder = builder;
    }

    /**
     * A method that inherits the basic implementation of parsing a file that passes each line
     * to processLine()
     *
     * @param file is taken by the method which should be parsed in some way by the method code
     */
    public void parseFile(String file) {
        super.parseFile(file);
    }

    // Processes each line by using a stream, splitting each word by the space and passing it to builder.addToIndex()
    // Running time: Overall depends on the running time of addToIndex but for this method it is O(n) because
    // worst case, the amount of spaces in the line, dictates how many forEach loops occur.
    /**
     *
     *
     * @param line is a string passed in by another method (parseFile) which is then manipulated in some way or added
     *             directly to a collection.
     */
    public void processString(String line) {
        if (lineNumber % 40 == 0) page++;
        Arrays.stream(line.split("\\s+")).forEach(w -> builder.addToIndex(w, page));
        lineNumber++;
    }
}
