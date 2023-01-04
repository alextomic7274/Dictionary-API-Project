package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TextFileParser {
    private int page = 0;
    private int lineNumber = 0;
    private IndexBuilder builder = null;
    private String textFile = null;

    public TextFileParser(String textFile) {
        this.textFile = textFile;
    }

    public TextFileParser(ConfigFileParser parser, String outputFile) {
        builder = new IndexBuilder(parser, outputFile);
    }

    public void parseFile(String file) throws Exception {
        Files.lines(Path.of(file))
        .forEach(line -> processLine(line));
    }

    public void processLine(String line) {
        if (lineNumber % 40 == 0) page++;
        Arrays.stream(line.split("\\s+")).forEach(w -> builder.addToIndex(w, page));
        lineNumber++;
    }

    public void saveIndex(String outputFile) {
        IndexFileWriter.save(builder.getIndex(), outputFile);
    }

}
