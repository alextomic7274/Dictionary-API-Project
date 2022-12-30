package ie.atu.sw;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConfigFileParser implements Parser{
    private ConcurrentSkipListSet<String> stopWords = null;

    private ConcurrentHashMap<String, String> dictionary = null;
    private StringBuffer tempDefinition;

    public void parseFile(String filePath) throws IOException {
        dictionary = new ConcurrentHashMap<>();
        Files.lines(Path.of(filePath))
            .forEach(line -> Thread.startVirtualThread(() -> processLine(line))
            );
        }

    public void processLine(String line) {
        add(line);
    }

    // Separates each dictionary line into two strings by the comma and adds string 1 as the key and string 2 as the value to a map.
    // Removes non-alphabetical characters from word and casts to lower case.
    public void add(String line) {
        String[] tempArray = line.split(",");
        String word = tempArray[0].toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "");
        String def = tempArray[1];
        dictionary.put(word, def);
    }

    // Parses a file and adds each line to a concurrent skip list set.
    // 0(n) time complexity to search for a word but satisfactory as the word list is fixed at 1000 words.
    public void parseStopWords(String filePath) throws IOException {
        stopWords = new ConcurrentSkipListSet<>();
        Files.lines(Path.of(filePath))
                .forEach(line -> Thread.startVirtualThread(() -> stopWords.add(line))
                );
    }

    public boolean checkStopWords(String word) {
        return stopWords.contains(word);
    }

    public String searchDictionary(String word) {
        tempDefinition = new StringBuffer();
        if (dictionary.containsKey(word)){
            return tempDefinition.append(word+", "+dictionary.get(word)).toString();
        }   return null;
    }

    public ConcurrentHashMap<String, String> getDictionary() {
        return dictionary;
    }


}

