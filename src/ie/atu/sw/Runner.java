package ie.atu.sw;

/**
 * The class Runner is a basic class that implements a main method which starts the application.
 * @author alex
 */
public class Runner {
	// Starts the application by creating an instance of Menu and calls startMainMenu()
	// Running time: O(1)

	/**
	 * Starts the application at run-time by instantiating a Menu object and calling startMainMenu().
	 * @param args
	 */
	public static void main(String[] args) {
		Menu m = new Menu();
		try {
			m.startMainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}