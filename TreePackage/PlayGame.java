package TreePackage;
/*
 * @author Jon Mosco
 */

public class PlayGame {

	public static void main(String[] args) {
		
		GuessingGame carGame = new GuessingGame(null, null, null);
		
		//carGame.play();
		
		// generate our tree
		DecisionTree<String> newGame = new DecisionTree<String>();
		
		newGame.setTree("Is it a Car?");
		
		System.out.println(newGame.getNumberOfNodes());
		
		// System.out.println(newGame);
		
		// newGame.advanceToYes();
		
		BinaryTreeInterface<String> aTree = new BinaryTree<String>();
		
		BinaryTreeInterface<String> bTree = new BinaryTree<String>();
		
		BinaryTreeInterface<String> cTree = new BinaryTree<String>();
		
		aTree.setTree("A", bTree, cTree);
		
		//bTree.setTree("B");
		cTree.setTree("C");

		bTree.setTree("B", cTree, bTree);
		//aTree.setTree("Car");

		System.out.println(aTree.getNumberOfNodes());

	}

}
