package TreePackage;

//import java.util.Scanner;

/*
 * @author Jon Mosco
 */

public class PlayGame {

	public static void main(String[] args) {
		
		GuessingGame carGame = new GuessingGame("is the car domestic?", "Is the car foreign?", "Is the car a sedan?");
		
		carGame.play();		
		
	}

}
