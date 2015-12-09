package TreePackage;

import java.util.Scanner;

/*
 * Client Class
 */

public class Client {
	
	public static void main(String[] args) {
		
		GuessingGame carGame = new GuessingGame("is the car domestic?", "Is the car Foreign?", "Is the car a sedan?");
		//GuessingGame carGame = new GuessingGame("is the car domestic?", null, null);
		//GuessingGame carGame = new GuessingGame(null, null, null);
		
		carGame.play();		
		
	}

	public static boolean isUserResponseYes() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Yes or No: ");
		String answer = scanner.next();

		if (answer.equals("yes")) {
			return true;
		} else {
			return false;
		}

	}

}