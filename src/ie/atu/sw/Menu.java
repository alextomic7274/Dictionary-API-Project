package ie.atu.sw;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>Provides the application with menu functionality by exposing several methods that take
 * the user's choice, it then delegates the job to the relevant object depending on which choice is selected.</p>
 *
 * @author alex
 */
public class Menu {
    private Scanner scanner = null;
    private ConfigFileParser configFileParser = null;
    private String textFilePath = null;
    private Map<String, String> dictionary = new HashMap<>();
    private String outputFile = null;

    // Constructor which instantiates a Scanner and ConfigFileParser objects.
    // Running time: Average O(1) as very little is needed to create the objects but may change of ConfigFileParser implementation changes
    /**
     * <p>Menu constructor that instantiates a Scanner and ConfigFileParser object and stores them at
     * class level, as they may be needed in other methods.</p>
     */
    public Menu() {
        scanner = new Scanner(System.in);
        configFileParser = new ConfigFileParser();
    }

    // Provides menu functionality by using switch statement to interpret user choice, then delegates responsibility.
    // Running time: Difficult to accurately determine, depends on the running time of processing each file and executing the build database, my estimation of worst is O(n)
    /**
     * <p>>Displays the main menu and processes the user's choice</p>
     *
     * @throws Exception if there is an error while processing the user's choice, it is thrown to the caller
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

    /*
    This method takes the fileType as a parameter, it then uses a Scanner object to retrieve a filePath from the user
    where it processes the file depending on the fileType passed in during method call.
    Running time: Depends on running time of parseFile and other code needed in processLine within ConfigFileParser.

     */
    private void processFile(String fileType) {
        try {
            System.out.print("Specify file path:");
            String filePath = scanner.nextLine();
            switch (fileType) {
                case "text file" -> this.textFilePath = filePath;
                case "config" -> configFileParser.parseFile(filePath);
                case "output file" -> this.outputFile = filePath;
            }
        } catch (Exception e) {
            System.out.println("process file failed");
        }
    }

    // Executes the methods required to build and save the index. Requires a textFile and Output file to be specified,
    // plus dictionary and stopWords to be configured.
    // Running time: Hard to determine accurate as it depends on all the called methods beyond this class.
    private void executeBuildIndex() throws Exception {
        TextualGUI.startLoadingBar();
        IndexBuilder builder = new IndexBuilder(configFileParser);
        TextFileParser textFileParser = new TextFileParser(builder);
        textFileParser.parseFile(textFilePath);
        builder.saveIndex(outputFile);
    }

}
