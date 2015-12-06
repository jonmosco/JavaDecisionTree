package TreePackage;

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
		DecisionTree<String> no = new DecisionTree<String>(noAnswer);
		// right node
		DecisionTree<String> yes = new DecisionTree<String>(yesAnswer);
		
		// root node
		tree = new DecisionTree<String>(question, no, yes);
	}

	public void play() {
		
		tree.reset();
		
		while (!tree.isAnswer()) {
			// ask current question
			System.out.println(tree.getCurrentData());
			System.out.println("Inside while loop");
			
			if (Client.isUserResponseYes())
				tree.advanceToYes();
			else
				tree.advanceToNo();
		} // end while
		
		// Assertion: leaf is reached
		assert tree.isAnswer();
		
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
		
		tree.advanceToYes();
		tree.advanceToNo();
		tree.setTree("Is the car a chevy?");
		tree.setTree("Is the car a nissan?");
		
	}

}