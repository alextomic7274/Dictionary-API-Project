package ie.atu.sw;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IndexBuilder {
    private ConfigFileParser parser = null;
    private WordDetail wordDetail = null;
    private HashMap<String, WordDetail> index = null;
    private String outputFile = null;

    public IndexBuilder(ConfigFileParser parser, String outputFile) {
        index = new HashMap<>();
        this.parser = parser;
        this.outputFile = outputFile;
    }

    public void addToIndex(String word, int page) {
        String wordCleaned = word.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        if (parser.checkStopWords(wordCleaned) || (parser.searchDictionary(wordCleaned) == null)) return;

        if (!index.containsKey(word)) {
            wordDetail = new WordDetail(word, page, parser.searchDictionary(wordCleaned));
            index.put(word, wordDetail);
        }
        wordDetail = new WordDetail(index.get(word));
        wordDetail.add(page);
        index.put(word, wordDetail);
    }

    public HashMap<String, WordDetail> getIndex() {
        HashMap<String, WordDetail> temp = new HashMap<>(index);
        return temp;
    }


}
