package TreePackage;

class BinaryNode<T> implements BinaryNodeInterface<T> {
	
	private T data;
    private BinaryNode < T > left;
    private BinaryNode < T > right;
    
    public BinaryNode ()
    {
        this (null); // call next constructor
    } // end default constructor


    public BinaryNode (T dataPortion)
    {
        this (dataPortion, null, null); // call next constructor
    } // end constructor


    public BinaryNode (T dataPortion, BinaryNode < T > leftChild,
            BinaryNode < T > rightChild)
    {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    } // end constructor


    public T getData ()
    {
        return data;
    } // end getData


    public void setData (T newData)
    {
        data = newData;
    } // end setData


    public BinaryNodeInterface < T > getLeftChild ()
    {
        return left;
    } // end getLeftChild


    public void setLeftChild (BinaryNodeInterface < T > leftChild)
    {
        left = (BinaryNode < T > ) leftChild;
    } // end setLeftChild


    public boolean hasLeftChild ()
    {
        return left != null;
    } // end hasLeftChild


    public boolean isLeaf ()
    {
        return (left == null) && (right == null);
    } // end isLeaf

    public BinaryNodeInterface <T> copy()
    {
        BinaryNode < T > newRoot = new BinaryNode < T > (data);
        if (left != null)
            newRoot.left = (BinaryNode < T > ) left.copy ();
        if (right != null)
            newRoot.right = (BinaryNode < T > ) right.copy ();
        return newRoot;
    } // end copy


    private void privateSetTree (T rootData, BinaryTree <T> leftTree, BinaryTree <T> rightTree) {
    	
        root = new BinaryNode<T> (rootData);
    
        if ((leftTree != null) && !leftTree.isEmpty ())
            root.setLeftChild (leftTree.root.copy ());
        if ((rightTree != null) && !rightTree.isEmpty ())
            root.setRightChild (rightTree.root.copy ());
    
    } 

    public int getHeight ()
    {
        return getHeight (this); // call private getHeight
        //return root.getHeight();
    } // end getHeight


    private int getHeight (BinaryNode < T > node)
    {
        int height = 0;
        if (node != null)
            height = 1 + Math.max (getHeight (node.left),
                    getHeight (node.right));
        return height;
    } // end getHeight


    public int getNumberOfNodes ()
    {
        int leftNumber = 0;
        int rightNumber = 0;
        if (left != null)
            leftNumber = left.getNumberOfNodes ();
        if (right != null)
            rightNumber = right.getNumberOfNodes ();
        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes


	@Override
	public BinaryNodeInterface<T> getRightChild() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return false;
	}
}
