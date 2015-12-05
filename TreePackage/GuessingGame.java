package TreePackage;

import java.util.Scanner;

/*
 * @author Jon Mosco
 */

public class GuessingGame {
	private DecisionTreeInterface<String> tree;

	// default constructor
	public GuessingGame(String question, String noAnswer, String yesAnswer) {
		// left node
		DecisionTree<String> no = new DecisionTree<>(noAnswer);
		// right node
		DecisionTree<String> yes = new DecisionTree<>(yesAnswer);
		
		// root node
		tree = new DecisionTree<String>(question, no, yes);
	}

	public void play() {
		
		tree.reset();
		
		while (!tree.isAnswer()) {
			// ask current question
			System.out.println(tree.getCurrentData());
			
			if (Client.isUserResponseYes())
				tree.advanceToYes();
			else
				tree.advanceToNo();
		} // end while
		assert tree.isAnswer(); // Assertion: leaf is reached
		// make guess
		System.out.println("My guess is " + tree.getCurrentData() + ". Am I right?");
		if (Client.isUserResponseYes())
			System.out.println("I win.");
		else
			learn();
	}

	private void learn() {
		
		// create a scanner
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		// ask the user for a question
		System.out.println("Is your car foreign?");
		String answer = input.nextLine();
		
		if (answer == "Yes") {
		} else {
		}
		
	}

}