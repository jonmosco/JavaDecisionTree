package TreePackage;

import TreePackage.DecisionTreeInterface;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

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
		System.out.println("inside play()");
		
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
	@SuppressWarnings("resource")
	private void learn() {
		
		String question;
		
		Scanner input = new Scanner( System.in );
		
		System.out.println("Is the car foreign?");
		question = input.next();
		tree.setCurrentData(question);
		
		tree.advanceToYes();
		tree.setTree("Is the car a chevy?");
		System.out.println(tree.getCurrentData());
		tree.advanceToNo();
		tree.setTree("Is the car a nissan?");
		System.out.println(tree.getCurrentData());
		tree.advanceToYes();
		Client.isUserResponseYes();
		
	}

}