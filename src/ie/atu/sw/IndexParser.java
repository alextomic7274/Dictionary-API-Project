package ie.atu.sw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class IndexParser{
    private Map<String, WordDetail> index = null;
    private ArrayList<WordDetail> wordDetails = null;
    ArrayList<WordDetail> wordsSorted = null;
    private StringBuilder sb = new StringBuilder();

    public IndexParser(Map<String, WordDetail> index) {
        this.index = index;
    }

    public int getTotalUniqueWords() {
        return index.keySet().size();
    }

    public ArrayList<WordDetail> getNFrequentWords(int n, boolean isReverse) {
        wordDetails = new ArrayList<>(index.values());
        wordsSorted = new ArrayList<>();
        if (isReverse) {
            Collections.sort(wordDetails, Collections.reverseOrder());
        }   else Collections.sort(wordDetails);

        for (int i = 0; i < n; i++) {
            wordsSorted.add(wordDetails.get(i));
        }
        return wordsSorted;
    }





}
