package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	// default constructor
	// create an empty tree
	public BinaryTree() {
		root = null;
	}

	// create a tree of a single node
	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	} // end constructor

	// set data in the root node, and in the left and right subtrees
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	} // end setTree

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		/* FIRST DRAFT - See Segments 24.5 - 24.8 for improvements. */

		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} // end if
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	} // end privateSetTree

	public T getRootData() {
		// T rootData = null;
		// if (root != null)
		// rootData = root.getData();
		// return rootData;

		if (isEmpty()) {
			return null;
			// throw new EmptyTreeException();
		} else {
			return root.getData();
		}

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

	protected void setRootNode(BinaryNode<T> rootNode) {
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
		// return new InorderIterator();
		return null;
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		// TODO Auto-generated method stub
		return null;
		// return new LevelOrderTraversal();
	}

	public void LevelOrderTraversal() {
		LevelOrderTraversal(root);
	}
	
	private void LevelOrderTraversal(BinaryNodeInterface<T> node) {
		if (node != null) {
			System.out.println(node.getData());
			inorderTraverse(node.getLeftChild());
			inorderTraverse(node.getRightChild());
		} 
	}

	public void inorderTraverse() {
		inorderTraverse(root);
	} // end inorderTraverse

	private void inorderTraverse(BinaryNodeInterface<T> node) {
		if (node != null) {
			inorderTraverse(node.getLeftChild());
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild());
		}
	}
	
	private class InorderIterator implements Iterator < T >
	{
	    private StackInterface < BinaryNodeInterface < T >> nodeStack;
	    private BinaryNodeInterface < T > currentNode;
	    public InorderIterator ()
	    {
	        nodeStack = new LinkedStack < BinaryNodeInterface < T >> ();
	        currentNode = root;
	    } // end default constructor


	    public boolean hasNext ()
	    {
	        return !nodeStack.isEmpty () || (currentNode != null);
	    } // end hasNext


	    public T next ()
	    {
	        BinaryNodeInterface < T > nextNode = null;
	        // find leftmost node with no left child
	        while (currentNode != null)
	        {
	            nodeStack.push (currentNode);
	            currentNode = currentNode.getLeftChild ();
	        } // end while
	        // get leftmost node, then move to its right subtree
	        if (!nodeStack.isEmpty ())
	        {
	            nextNode = nodeStack.pop ();
	            assert nextNode != null; // since nodeStack was not empty
	            // before the pop
	            currentNode = nextNode.getRightChild ();
	        }
	        else
	            throw new NoSuchElementException ();
	        return nextNode.getData ();
	    } // end next


	    public void remove ()
	    {
	        throw new UnsupportedOperationException ();
	    } // end remove
	    
	} // end InorderIterator
}
