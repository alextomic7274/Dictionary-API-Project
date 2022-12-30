package ie.atu.sw;

import java.io.IOException;

public interface Parser {
    public void parseFile(String filePath) throws IOException;

    public void processLine(String line);

    public void add(String input);
}
