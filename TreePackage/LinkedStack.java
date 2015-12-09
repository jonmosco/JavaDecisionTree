package TreePackage;

public class LinkedStack<T> implements StackInterface<T> {
	
	private Node topNode; // references the first node in the chain

	public LinkedStack() {
		topNode = null;
	}

	private class Node {
		private T data;

		public Node(T newEntry, LinkedStack<T>.Node topNode) {
			// TODO Auto-generated constructor stub
		}

		public T getData() {
			// TODO Auto-generated method stub
			return null;
		}

		public LinkedStack<T>.Node getNextNode() {
			// TODO Auto-generated method stub
			return null;
		} 
	} // end Node

	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
        topNode = newNode;	
	}

	@Override
	public T pop() {
		 T top = peek();
		 if (topNode != null)
		 topNode = topNode.getNextNode();
		 return top;
	}

	public T peek() {
		T top = null;
		if (topNode != null)
			top = topNode.getData(); return top;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		topNode = null;
		
	}
}