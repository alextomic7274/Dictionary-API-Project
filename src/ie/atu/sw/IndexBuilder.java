package ie.atu.sw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IndexBuilder {
    private Map<String, WordDetail> index = null;
    private ConfigFileParser parser;

    private IndexFileWriter writer;
    private WordDetail wordDetail;

    public IndexBuilder(ConfigFileParser parser, String outputFile) {
        index = new HashMap<>();
        this.parser = parser;
        writer = new IndexFileWriter(outputFile);
    }

    public void addToIndex(String word, int page) {
        String wordCleaned = word.trim().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        if (parser.checkStopWords(wordCleaned) || (parser.searchDictionary(wordCleaned) == null)) return;

        if (!index.containsKey(word)) {
            wordDetail = new WordDetail(page, parser.searchDictionary(wordCleaned));
            index.put(word, wordDetail);
        }
        wordDetail = new WordDetail(index.get(word));
        wordDetail.add(page);
        index.put(word, wordDetail);

    }

    public Map<String, WordDetail> getIndex() {
        return index;
    }

    public void printIndex() {

        for (Map.Entry<String, WordDetail> entry : index.entrySet()) {
            System.out.println("index "+entry.getKey() + ": " + entry.getValue());
            System.out.println();
        }
        /*
        for (ConcurrentHashMap.Entry<String, String> entry : parser.getDictionary().entrySet()) {
            System.out.println("Dictionary: "+entry.getKey() + ": " + entry.getValue());
            System.out.println();
        }
        */

    }





}
