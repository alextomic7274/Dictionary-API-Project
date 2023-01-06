package ie.atu.sw;

import java.util.*;

/**
 * A class which needs a word/definition index to be used, which provides extra options for manipulating
 * the index such as getting N most frequent/infrequent words or searching for a specific word in the index.
 *
 * @author alex
 */
public class IndexExtraOptions {
    private Map<String, WordDetail> index = null;
    private List<WordDetail> wordDetailsCol = null;
    private List<WordDetail> wordsSorted = null;
    private StringBuilder sb = null;

    public IndexExtraOptions(Map<String, WordDetail> index) {
        this.index = index;
        sb = new StringBuilder();
    }

    public int getTotalUniqueWords() {
        return index.keySet().size();
    }

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

    public String searchForWord(String word) {
        if (index.containsKey(word)) {
            return index.get(word).toString();
        }   else return "NOT FOUND";
    }


}
