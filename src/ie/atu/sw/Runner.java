package ie.atu.sw;

import java.time.Duration;


public class Runner {
	public static void main(String[] args) throws InterruptedException {
		Menu m = new Menu();
		try {
			m.startMainMenu();
		} catch (Exception e) {
			System.out.println("INVALID INPUT: Enter 1-6 Inclusive");
			Thread.sleep(Duration.ofSeconds(1));
			main(null);
		}
	}


}