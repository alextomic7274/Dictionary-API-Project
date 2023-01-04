package ie.atu.sw;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ConfigFileParser configFileParser;
    private String textFilePath = null;
    private Map<String, String> dictionary = new HashMap<>();
    private String outputFile = null;
    String dictionaryFile = "./dictionary.csv";
    String commonwords = "./google-1000.txt";

    public Menu() {
        scanner = new Scanner(System.in);
        configFileParser = new ConfigFileParser();
    }

    public void startMainMenu() throws Exception {
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

    private void processFile(String type) throws Exception {
        try {
            System.out.print("Specify "+type+" path:");
            String filePath = scanner.nextLine();
            switch (type) {
                case "text file" -> this.textFilePath = "PrinceMachiavelli.txt";
                case "dictionary" -> configFileParser.parseFile(dictionaryFile);
                case "common words" -> configFileParser.parseStopWords(commonwords);
                case "output file" -> this.outputFile = filePath;
            }
        } catch (IOException e) {
            System.out.println("FILE SELECTION ERROR: TRY AGAIN");
            Thread.sleep(Duration.ofSeconds(1));
            startMainMenu();
        }
    }

        private void execute() throws Exception {
        TextFileParser textFileParser = new TextFileParser(configFileParser, outputFile);
        textFileParser.parseFile(textFilePath);
        textFileParser.saveIndex(outputFile);
    }

}
