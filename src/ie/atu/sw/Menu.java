package ie.atu.sw;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ConfigFileParser parser;
    private String textFilePath = null;
    private Map<String, String> dictionary = new HashMap<>();
    private String outputFile = null;
    private Parser textFileParser;

    public Menu() {
        scanner = new Scanner(System.in);
        parser = new ConfigFileParser();
    }

    public void startMainMenu() throws InterruptedException, IOException {
        while(true) {
            TextualGUI.showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> processFile("text file");
                case 2 -> processFile("dictionary");
                case 3 -> processFile("common words");
                case 4 -> processFile("output file");
                case 5 -> execute();
                case 6 -> System.exit(0);
            }
        }
    }

    private void processFile(String type) throws IOException {
        System.out.print("Specify "+type+" path:");
        String filePath = scanner.nextLine();
        switch (type) {
            case "text file" -> this.textFilePath = filePath;
            case "dictionary" -> parser.parseFile(filePath);
            case "common words" -> parser.parseStopWords(filePath);
            case "output file" -> this.outputFile = filePath;
        }
    }

    private void execute() throws IOException {
        textFileParser = new TextFileParser(parser, outputFile);
        textFileParser.parseFile(textFilePath);
    }

}
