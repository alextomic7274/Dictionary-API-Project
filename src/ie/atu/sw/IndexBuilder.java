package ie.atu.sw;

import java.util.*;

public class IndexBuilder {
    private ConfigFileParser configParser = null;
    private WordDetail wordDetail = null;

    private Map<String, WordDetail> index = null;
    private String outputFile = null;

    public IndexBuilder(ConfigFileParser configParser) {
        index = new HashMap<>();
        this.configParser = configParser;
    }


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




    public HashMap<String, WordDetail> getIndex() {
        HashMap<String, WordDetail> temp = new HashMap<>(index);
        return temp;
    }


}
