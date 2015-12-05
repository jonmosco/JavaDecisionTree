package TreePackage;

import java.util.Scanner;
import TreePackage.DecisionTreeInterface;
import TreePackage.DecisionTree;

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

	// The private method learn asks the user for a question 
	// that distinguishes between two guesses. Using this information,
	// the method adds nodes to the decision tree
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