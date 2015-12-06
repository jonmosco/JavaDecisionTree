package TreePackage;

import java.util.Scanner;

/*
 * @author Jon Mosco
 */

public class PlayGame {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// ask our question
		String question;
		
		Scanner input = new Scanner( System.in );
		
		System.out.println("Is the car foreign?");
		question = input.next();
		
		BinaryTree<String> ourTree = new BinaryTree<String>();
		
		ourTree.setTree(question);
		
		GuessingGame carGame = new GuessingGame("Is it domestic?", "Is the car Foreign", "Is the car a Honda?");
		
		carGame.play();
		
		// test: output our root data
		//System.out.println(ourTree.getRootData());
		

	}

}
