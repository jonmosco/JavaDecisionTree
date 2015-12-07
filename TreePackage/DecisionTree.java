package TreePackage;
/*
 * @author Jon Mosco
 */

import java.util.Iterator;

public class DecisionTree<T> implements DecisionTreeInterface<T> {

	private T data;
	private BinaryTreeInterface<T> left;
	private BinaryTreeInterface<T> right;

	public DecisionTree(String noAnswer) {
		//left = noAnswer;
	}

	public DecisionTree(String question, DecisionTree<String> no, DecisionTree<String> yes) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setTree(T rootData) {
		data = rootData;
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		data = rootData;
		left = leftTree;
		right = rightTree;
		
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<T> getPreorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	// Gets the data in the current nod
	public T getCurrentData() {
		return data;
	}

	// Sets the data in the current node
	public void setCurrentData(T newData) {
		data = newData;
	}

	// Sets the data in the children of the current node,
    // creating them if they do not exist
	public void setAnswers(T answerForNo, T answerForYes) {

	}

	// Sees whether the current node contains an answer
	public boolean isAnswer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void advanceToNo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void advanceToYes() {
		// TODO Auto-generated method stub
		
	}
	
	/** Makes the root of the tree the current node.*/
	public void reset() {
		
	}

	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}