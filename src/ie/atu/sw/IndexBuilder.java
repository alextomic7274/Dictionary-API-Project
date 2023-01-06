package ie.atu.sw;

import java.util.*;

/**
 * The IndexBuilder class provides methods for building an index from a text file.
 * The Index is a Map that stores the word as key and WordDetail (containing pages, defintion etc.) as value.
 *
 * @author alex
 */
public class IndexBuilder {
    private ConfigFileParser configParser = null;
    private WordDetail wordDetail = null;
    private Map<String, WordDetail> index = null;

    /**
     * <p>Constructs a new instance of the class, using the specified ConfigParser as a parameter.</p>
     *
     * @param configParser The object to use as a parameter
     */
    public IndexBuilder(ConfigFileParser configParser) {
        index = new HashMap<>();
        this.configParser = configParser;
    }

    // Takes a word and page it is found on, strips the word of white space, non-alphanumeric characters
    // then adds to the index if the word is not on the most common words list or if the definition is not found in the dictionary.
    // Running time: O(n) is the worst case of the entire method, for example, checking stop words or searching the dictionary hash map
    // in ConfigFileParser could take n tries.
    /**
     * Adds the specified word and page to the index. The word is stripped of leading and trailing white space,
     * converted to lowercase and any non-alphanumeric characters are removed before it is added.
     * <p>
     * If the word is already present in the index, the page is added to the list of the WordDetail corresponding to that word.
     *
     * @param word The word to add to the index
     * @param page The page on which the word is found
     */
    public void addToIndex(String word, int page) {
        String wordStripped = word.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        if ((configParser.checkStopWords(wordStripped)) || (configParser.searchDictionary(wordStripped) == null)) return;

        if (!index.containsKey(wordStripped)) {
            wordDetail = new WordDetail(wordStripped, page, configParser.searchDictionary(wordStripped));
            index.put(wordStripped, wordDetail);
            return;
        }
        wordDetail = new WordDetail(index.get(wordStripped));
        wordDetail.addPage(page);
        index.put(wordStripped, wordDetail);
    }

    // Returns a copy of the index, caller does not directly access the index map thus it is encapsulated.
    // Running time: O(n) because the getIndex method creates a new HashMap object and copies all elements from the index HashMap into the new object.
    // Copying all the elements from the index HashMap into the new object has a running time of O(n).
    /**
     *  Returns a copy of the index map.
     *
     * @return a new HashMap containing the same key-value pairs as the original index map.
     */
    public HashMap<String, WordDetail> getIndex() {
        HashMap<String, WordDetail> temp = new HashMap<>(index);
        return temp;
    }

    // Composes an IndexFileWriter and delegates the task of saving the index to save()
    // Running time: O(n) because it depends on the running time of save(), which is O(n)
    /**
     * Saves the current index to a file by delegating the task to a method in IndexFileWriter.
     *
     * @param outputFile the file path where the index will be saved to
     */
    public void saveIndex(String outputFile) {
        IndexFileWriter indexFileWriter = new IndexFileWriter();
        indexFileWriter.save(index, outputFile);
    }


}
