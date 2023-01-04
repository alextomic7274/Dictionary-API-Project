package ie.atu.sw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class CodeStubs {
    private Map<String, WordDetail> map = new ConcurrentSkipListMap();
    private Collection<String> avoidWords = new ConcurrentSkipListSet<>(); // Read word list into memory and store here, should i load dictionary first?
    private int lineNumber = 0;
    private int page = 1;
    private static Map<Integer, String> m = new HashMap<>();

    // 1. Build stopwords concurrent skiplistset
    // 2. Build the index from the dictionary
    // 3. Add page indices from a book
    // 4. Purge the map from blanks, words that arent being used.

    // Do for parse google words and dictionary
    private void parse(String file) throws Exception {
        Files.lines(Path.of(file))
                .forEach(text -> Thread.startVirtualThread(() -> processLine(text, page))
        );
    }
    // Do this for actual book
    private void parseBook(String file) throws IOException {
        //Files.lines(Path.of(file))
               // .forEach(line -> processLineFromBook(line));
    }
    // Takes in a
    public int processLine(String text, int lineNumber){
        final int lineNo = lineNumber;
        Arrays.stream(text.split("\\s+")).forEach(w -> appendWord(w));
        lineNumber++;
        if (lineNumber % 40 == 0) page++;
        return lineNumber;
    }

    public void appendWord(String word){
        if (avoidWords.contains(word)) return;


    }


/*
    public static void main(String[] args) throws Exception {
        try {
            CodeStubs cs = new CodeStubs();
            String file = "./test.txt";
            cs.parse(file);
        } catch (Exception e) {
            System.out.println("Cannot find file");
        }
        m.forEach((i, s) -> System.out.println(i + s));

    }
*/
}