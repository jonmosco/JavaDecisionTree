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
		this (null);
		//root = null;
	}
	
	public DecisionTree(String noAnswer) {
		this (noAnswer, null, null);
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
	@SuppressWarnings("unchecked")
	public void setAnswers(T answerForNo, T answerForYes) {
		left = (BinaryTreeInterface<T> ) answerForNo;
		right = (BinaryTreeInterface<T> ) answerForYes;
		
	}

    /** Sees whether the current node contains an answer.
    @return true if the current node is a leaf, or
    false if it is a nonleaf */
	public boolean isAnswer() {
		return true;
	}

    /** Sets the current node to its left child.
    If the child does not exist, sets the current node to null.
    Precondition: The current node is not null. */
	public void advanceToNo() {
		getInorderIterator();
	}

    /** Sets the current node to its right child.
    If the child does not exist, sets the current node to null.
    Precondition: The current node is not null. */
	public void advanceToYes() {
		//getInorderIterator();
		setTree(root);
	}
	
	/** Makes the root of the tree the current node.*/
	public void reset() {
		//System.out.println("inside reset()");
		//getRootData();
		setTree(data);
		//root = data;
	}

	@Override
	public void setTree(T rootData) {
		data = rootData;
		//root.setData(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		data = rootData;
		left = leftTree;
		right = rightTree;
		
	}

	@Override
	public int getNumberOfNodes() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
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
		return root;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}