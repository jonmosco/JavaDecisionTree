package TreePackage;

import TreePackage.DecisionTreeInterface;

import java.io.File;
import java.io.IOException;
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
		System.out.println("inside play()");
		tree.reset();
		
		while (!tree.isAnswer()) {
			// ask current question
			// test
			//tree.setCurrentData("Is the car domestic?");
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
		
		// read in our file.  Separate the data from the code
		String carFile = "src/TreePackage/CarTree";
		
		try (Scanner scanner = new Scanner(new File(carFile))) {
			while (scanner.hasNext()){
				//System.out.println(scanner.nextLine());
				tree.setCurrentData(scanner.nextLine());
				System.out.println("My guess is " + tree.getCurrentData() + ". Am I right?");
				
				// get our response
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in); 
				System.out.println("Yes or No: ");
				@SuppressWarnings("unused")
				String answer = input.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}