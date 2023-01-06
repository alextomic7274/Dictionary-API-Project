package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * <p>An implementation of the interface Parser, the role of ConfigFileParser is to provide methods that can configure the files needed
 * to build a word/definition/pages index. It also provides methods that can be used to search the dictionary
 * and check if a word is in a common words list.
 * </p>
 *
 * @author alex
 */
public class ConfigFileParser extends FileParser {
    private Set<String> stopWords = null;
    private Map<String, String> dictionary = null;
    private StringBuffer tempDefinition;
    private boolean isParsingDictionary = false;

    /**
     * <p>Constructor which instantiates collections that store stopWords and dictionary.</p>
     */
    public ConfigFileParser() {
        stopWords = new ConcurrentSkipListSet<>();
        dictionary = new ConcurrentHashMap<>();
    }

    /*
    Takes a String filePath as a parameter, utilses an if-else block and
    if filePath contains "dictionary" then it passes each line of the file to a distinct virtual thread that delegates the responsibility
    of adding each line to the dictionary collection, else: it starts a virtual thread for each line of a file and adds each file to a collection.
    Running time: O(n) if processing dictionary, O(1) if processing stopWords.
     */
    /**
     * <p>Parses the file path which virtual threads, if filepath contains "dictionary" then it
     * processes it accordingly, if anything else, it treats it as a stopWords file and adds each line to
     * a set.</p>
     *
     * @param filePath the string of the filepath from a visible directory which is to be parsed
     */
    public void parseFile(String filePath) {
        try {
            if (filePath.contains("dictionary")) {
                Files.lines(Path.of(filePath))
                        .forEach(line -> Thread.startVirtualThread(() -> processString(line))
                        );
            } else {
                Files.lines(Path.of(filePath))
                        .forEach(line -> Thread.startVirtualThread(() -> stopWords.add(line))
                        );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Separates each dictionary line into two strings by comma and adds string 1 as the key and string 2 as the value to a HashMap.
        Removes non-alphabetical characters from word and casts to lower case.
        Running time: Depends on length of string line, O(n) is worst case if split, trim, toL and replaceAll need to traverse the entire string.
     */
    /**
     * <p>Takes a string and splits it into two by regex: "," then adds the first string to a hash map
     * as a key and the second as a value. It is implemented to specifically add dictionary lines that separate the word and
     * definition with a comma. </p>
     *
     * @param line the string to be processed and added to a data structure
     */
    public void processString(String line) {
        String[] tempArray = line.split(",");
        String s = "";
        String word = tempArray[0].trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        String def = tempArray[1].trim();
        dictionary.put(word, def);
    }

           /*
    Checks if a word exists in the set by using contains().
    Running time: O(n) where n is the number of elements in the set.
     */
    /**
     * <p>Takes in a string and returns boolean value based on the strings presence in a set</p>
     *
     * @param word is the string which is checked against the set
     * @return true if word exists in the set, false otherwise
     */
    public boolean checkStopWords(String word) {
        return stopWords.contains(word);
    }

    /*
    This method takes a String word, searches the dictionary map for the word and
    if it exists, it returns the word's definition, otherwise it returns null.
    Running time: O(n) worst case overall, as the map might need to be fully searched in the absolute worst case before finding the key.
    */
    /**
     * <p>Searches the data structure storing a dictionary and returns the definition as a string.</p>
     *
     * @param word the word which a definition is needed for
     * @return a word's definition if the collection contains the specified word
     */
    public String searchDictionary(String word) {
        StringBuilder tempDefinition = new StringBuilder();
        if (dictionary.containsKey(word)) {
            return tempDefinition.append(dictionary.get(word)).toString();
        }
        return null;
    }
}

