package TreePackage;
/*
 * @author Jon Mosco
 */

import java.util.Iterator;

public class DecisionTree<T> implements DecisionTreeInterface<T> {
	
	private DecisionTree<T> root;
	
	//private T data;
	//private String no;
	
	// no arg constructor
	public DecisionTree() {
		root = null;
	}
	
	public DecisionTree(T rootData) {
		root = new DecisionTree<>(rootData);
	}
	
	// default constructor
	public DecisionTree(String noAnswer) {
		//no = noAnswer;
	}

	public DecisionTree(String question, DecisionTree<String> no, DecisionTree<String> yes) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setTree(T rootData) {
		root = new DecisionTree<>(rootData);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getCurrentData() {
		//return data;
		return null;
	}

	@Override
	public void setCurrentData(T newData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnswers(T answerForNo, T answerForYes) {
		// TODO Auto-generated method stub
		
	}

	@Override
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

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
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
