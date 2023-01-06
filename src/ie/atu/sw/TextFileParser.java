package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * <p>This class offers methods responsible for parsing a text file and it delegates the responsibilty of
 * building an index to a class called IndexBuilder, as a result it depends on an IndexBuilder to work
 * properly./p>
 *
 *
 * @author alex
 */
public class TextFileParser implements FileParser {
    private int page = 0;
    private int lineNumber = 0;
    private IndexBuilder builder = null;
    private String textFile = null;

    public TextFileParser(IndexBuilder builder) {
        this.builder = builder;
    }

    public void parseFile(String file) {
        try {
            Files.lines(Path.of(file))
            .forEach(line -> processLine(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
