package ie.atu.sw;

/**
 * The class Runner is a basic class that implements a main method which starts the application.
 * @author alex
 */
public class Runner {
	// Starts the application by creating an instance of Menu and calls startMainMenu()
	// Running time: Not possible to determine accurate running time as it depends on running time of every method in the call stack started by startMainMenu()
	/**
	 * Starts the application at run-time by instantiating a Menu object and calling startMainMenu().
	 * @param args is the command line argument, entered at run time
	 */
	public static void main(String[] args) throws Exception {
		Menu m = new Menu();
		try {
			m.startMainMenu();
		} catch (Exception e) {
			System.out.println("Application failed - try again");
			m.startMainMenu();
		}
	}


}