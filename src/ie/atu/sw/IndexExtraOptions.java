package ie.atu.sw;

import java.util.*;

/**
 * A class which needs a word/definition index to be used, and provides extra options for manipulating
 * the index such as getting N most frequent/infrequent words or searching for a specific word in the index.
 *
 * @author alex
 */
public class IndexExtraOptions {
    private Map<String, WordDetail> index = null;
    private List<WordDetail> wordDetailsCol = null;
    private List<WordDetail> wordsSorted = null;
    private StringBuilder sb = null;

    /**
     * Constructor with mandatory parameter Map index
     *
     * @param index is a map containing a dictionary index, required to use the methods in the class.
     */
    public IndexExtraOptions(Map<String, WordDetail> index) {
        this.index = index;
        sb = new StringBuilder();
    }

    // Returns total unique words by using keyset.size() on index map.
    // Running time: O(1)
    /**
     * Returns total unique words that exist in the collection
     *
     * @return total unique word count in the collection
     */
    public int getTotalUniqueWords() {
        return index.keySet().size();
    }

    /*
       Takes an n value and boolean inFrequent and returns either n most frequent or n most infrequent words in the index.
       Its implementation is achieved by adding the index map values (WordDetails) to a collection and sorting them.
       Then a for loop adds n sorted objects to a list, which are returned by the method in a collection.
       Running time: O(n) is worst case because it depends on how big the index is, its values are copied to
       a collection so it copies each value n times.
     */
    /**
     * This method returns a list of N most frequent/infrequent words in the index.
     *
     * @param n is the amount of results needed, e.g. 10 most frequent will return top 10 words
     * @param InFrequent if set to true, the method will return most infrequent words, otherwise it will return most frequent
     * @return
     */
    public List<WordDetail> getNFrequentWords(int n, boolean InFrequent) {
        wordDetailsCol = new ArrayList<>(index.values());
        wordsSorted = new ArrayList<>();
        if (n > wordDetailsCol.size()) n = wordDetailsCol.size();

        if (InFrequent) {
            Collections.sort(wordDetailsCol);
        }   else Collections.sort(wordDetailsCol, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            wordsSorted.add(wordDetailsCol.get(i));
        }
        return wordsSorted;
    }

    // Running time: O(1) because the running time of searching a hashmap is very fast = O(1)
    /**
     * Searches for a word in the collection and returns its word details as a string.
     *
     * @param word is searched for in the collection.
     * @return word details if it exists in collection, else return NOT FOUND
     */
    public String searchForWord(String word) {
        if (index.containsKey(word)) {
            return index.get(word).toString();
        }   else return "NOT FOUND";
    }


}
