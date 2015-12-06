package TreePackage;
/*
 * Client Class
 */

public class Client {
	
	/* The public method play uses methods of DecisionTree 
	 * to maintain the tree. Since the game requires user interaction, 
	 * we assume that the client of GuessingGame provides methods that 
	 * communicate with the user. In particular, we assume that a class Client 
	 * has a static method isUserResponseYes that returns true if 
	 * the user responds “yes” to a question.
	 */
	
	public static boolean isUserResponseYes() {
		return true;
	}

}