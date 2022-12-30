package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TextFileParser implements Parser{
    private int page = 1;
    private int lineNumber = 0;
    private int wordCount = 0;
    private IndexBuilder builder;

    public TextFileParser(ConfigFileParser parser, String outputFile) {
        builder = new IndexBuilder(parser, outputFile);
    }
    public void parseFile(String file) throws IOException {
        Files.lines(Path.of(file))
        .forEach(line -> processLine(line));
        print();
    }

    public void processLine(String line) {
        if (lineNumber % 40 == 0) page++;
        Arrays.stream(line.split("\\s+")).forEach(w -> add(w));
        lineNumber++;
    }

    public void add(String word) {
        builder.addToIndex(word, page);
    }

    public void print() {
        builder.printIndex();
    }





}
