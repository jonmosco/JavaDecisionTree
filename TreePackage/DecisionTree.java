package TreePackage;
/*
 * @author Jon Mosco
 */

import java.util.Iterator;

public class DecisionTree<T> implements DecisionTreeInterface<T> {
	
	private T root;
	private T data;
    private DecisionTree<String> left;
    private DecisionTree<String> right;
	
    public DecisionTree() {
    	this (null);
    }
    
	public DecisionTree(T question, DecisionTree<String> no, DecisionTree<String> yes) {
		data = question;
		left = no;
		right = yes;
	}

	public DecisionTree(String yesAnswer) {
	}

	public void setTree(T rootData) {
		root = rootData;
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		data = rootData;
		
	}

	public T getCurrentData() {
		if (data != null) {
			return data;
		} else {
			return null;
		}
	}

	@Override
	public void setCurrentData(T newData) {
		data = newData;
	}

	@Override
	public void setAnswers(T answerForNo, T answerForYes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAnswer() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void advanceToNo() {
		// TODO Auto-generated method stub
		data = (T) left;
	}

	@SuppressWarnings("unchecked")
	@Override
	/** Sets the current node to its right child.
    If the child does not exist, sets the current node to null.
    Precondition: The current node is not null. */
	public void advanceToYes() {
		data = (T) right;
	}

	@Override
	public void reset() {
		System.out.println("inside reset()");
		data = root;
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

}