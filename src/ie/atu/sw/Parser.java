package ie.atu.sw;

/**
 * An Abstraction of a parser, it provides the blueprint for methods in need of implementation when parsing a file
 * and processing the contents.
 *
 * @author alex
 */
public interface Parser {
    /**
     * This method must be implemented in a way that takes a string file as a parameter traverses the file in some way.
     *
     * @param file is the file to be parsed
     */
    void parseFile(String file);

    /**
     * This method must be implemented in a way that takes a string as a parameter and manipulates it in some way,
     * or adds it to a collection.
     *
     * @param string
     */
    void processString(String string);
}
