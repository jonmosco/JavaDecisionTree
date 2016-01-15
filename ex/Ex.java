/* $Id$ */

import java.io.*;

class BinaryTreeNode<T> {
	private T data;

	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public void setLeftChild(BinaryTreeNode node) {
		this.left = node;
	}
	public BinaryTreeNode getLeftChild() {
		return this.left;
	}

	public void setRightChild(BinaryTreeNode node) {
		this.right = node;
	}
	public BinaryTreeNode getRightChild() {
		return this.right;
	}

	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return this.data;
	}
};

public class Ex {
	public static void main(String args[]) {
		BinaryTreeNode<Long> n, root = new BinaryTreeNode(23);

		n = new BinaryTreeNode(8);
		n.setLeftChild(new BinaryTreeNode(56));
		n.setLeftChild(new BinaryTreeNode(2));
		root.setLeftChild(n);

		n = new BinaryTreeNode(7);
		n.setLeftChild(new BinaryTreeNode(24));
		n.setLeftChild(new BinaryTreeNode(3));
		root.setRightChild(n);

		displayTree(System.out, root);
	}

	public static void displayTree(PrintStream out,
	    BinaryTreeNode<Long> node) {
	}

	public static Long sumTree(PrintStream out,
	    BinaryTreeNode<Long> node) {
	    	Long sum = new Long(0);
	    	return sum;
	}

	public static Long minTree(PrintStream out,
	    BinaryTreeNode<Long> node) {
	    	Long min = new Long(0);
	    	return min;
	}

	public static Long maxTree(PrintStream out,
	    BinaryTreeNode<Long> node) {
	    	Long max = new Long(0);
	    	return max;
	}
};
