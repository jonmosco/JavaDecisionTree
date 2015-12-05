package TreePackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNodeInterface<T> root;

	// default constructor
	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	} // end setTree

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		/* FIRST DRAFT - See Segments 24.5 - 24.8 for improvements. */

		root = new BinaryNode<T>(rootData);
		if (leftTree != null)
			root.setLeftChild(leftTree.root);
		if (rightTree != null)
			root.setRightChild(rightTree.root);
	} 

	public T getRootData() {
		T rootData = null;
		if (root != null)
			rootData = root.getData();
		return rootData;
	} // end getRootData

	public boolean isEmpty() {
		return root == null;
	} // end isEmpty

	public void clear() {
		root = null;
	} // end clear

	protected void setRootData(T rootData) {
		root.setData(rootData);
	} // end setRootData

	protected void setRootNode(BinaryNodeInterface<T> rootNode) {
		root = rootNode;
	} // end setRootNode

	protected BinaryNodeInterface<T> getRootNode() {
		return root;
	} // end getRootNode

	public int getHeight() {
		return root.getHeight();
	} // end getHeight

	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	} // end getNumberOfNodes

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

	public Iterator<T> getInorderIterator() {
		//return new InorderIterator();
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
		//return new LevelOrderTraversal();
	}
	
	public void LevelOrderTraversal() {
	}
}
