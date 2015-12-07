package TreePackage;
/*
 * @author Jon Mosco
 */

import java.util.Iterator;

public class DecisionTree<T> implements DecisionTreeInterface<T> {

	private T root;
	private T data;
	private BinaryTreeInterface<T> left;
	private BinaryTreeInterface<T> right;

	public DecisionTree() {
		root = null;
	}
	
	public DecisionTree(String noAnswer) {
		//left = noAnswer;
	}
	
	public DecisionTree(String question, DecisionTree<String> no, DecisionTree<String> yes) {
		setTree(root, (BinaryTree<T>) left, (BinaryTree<T>) right);
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

	public void advanceToNo() {
		//left = (BinaryNode < T > ) leftChild;
	}

	public void advanceToYes() {
		// TODO Auto-generated method stub
		//right = (BinaryNode < T > ) rightChild;
	}
	
	/** Makes the root of the tree the current node.*/
	public void reset() {
		System.out.println("inside reset()");
		//getRootData();
		setTree(data);
		//root = data;
	}

	@Override
	public void setTree(T rootData) {
		//data = rootData;
		//root.setData(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		//data = rootData;
		//left = leftTree;
		//right = rightTree;
		
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