package ie.atu.sw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>Provides the application with menu functionality by exposing several methods that take
 * the user's choice, it then delegates the job depending on which choice is selected.</p>
 *
 * @author alex
 * @version 1.0
 */
public class Menu {
    private Scanner scanner = null;
    private ConfigFileParser configFileParser = null;
    private String textFilePath = null;
    private Map<String, String> dictionary = new HashMap<>();
    private String outputFile = null;

    // Constructor which instantiates a Scanner and ConfigFileParser objects.
    // Running time: O(1)
    /**
     * <p>Menu constructor that instantiates a Scanner and ConfigFileParser object and stores them at
     * class level, as they may be needed in other methods.</p>
     */
    public Menu() {
        scanner = new Scanner(System.in);
        configFileParser = new ConfigFileParser();
    }

    // Provides menu functionality by using switch statement to interpret user choice, then delegates responsibility.
    // Running time: O(1)
    /**
     * <p>>Asks user for choice and delegates responsibility based on int entered.</p>
     *
     * @throws Exception
     */
    public void startMainMenu() throws Exception {
        while(true) {
            TextualGUI.showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> processFile("text file");
                case 2, 3 -> processFile("config");
                case 4 -> processFile("output file");
                case 5 -> executeBuildIndex();
                case 6 -> System.exit(0);
            }
        }
    }

    private void processFile(String type) {
        try {
            System.out.print("Specify file path:");
            String filePath = scanner.nextLine();
            switch (type) {
                case "text file" -> this.textFilePath = filePath;
                case "config" -> configFileParser.parseFile(filePath);
                case "output file" -> this.outputFile = filePath;
            }
        } catch (Exception e) {
            System.out.println("process file failed");
        }
    }

        private void executeBuildIndex() throws Exception {
        IndexBuilder builder = new IndexBuilder(configFileParser);
        TextFileParser textFileParser = new TextFileParser(builder);
        textFileParser.parseFile(textFilePath);
        textFileParser.saveIndex(outputFile);
    }

}
