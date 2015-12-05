package TreePackage;
public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T> {

	public void setTree(T rootData);

	/**
	 * Sets this binary tree to a new binary tree.
	 * 
	 * @param rootData
	 *        an object that is the data in the new tree’s root 
	 * @param leftTree 
	 *        the left subtree of the new tree
	 * @param rightTree
	 *        the right subtree of the new tree
	 */
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}