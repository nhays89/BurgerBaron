import java.util.EmptyStackException;

/**
 * Provides a structure to store data.
 * @author Nicholas Hays
 */
public class MyStack<T> {
	Node myHead;
	boolean myIsEmpty;
	int mySize;
	public MyStack() {
		this.myIsEmpty = true;
	}
	
	public boolean isEmpty () {
		return myIsEmpty;
	}
	
	public void push(T item) {
		if(myIsEmpty) {
			myHead = new Node(null,null,item);
			myIsEmpty = false;
			mySize++;
			return;
		}
		
		Node node = new Node(null,myHead, item);
		node.myPrev = myHead;
		myHead.myNext = node;
		myHead = node;
		mySize++;
		
	}
	public T peek() {
		return myHead.myData;
	}
	
	public T pop() throws EmptyStackException {
		if(myHead ==  null) {
			throw new EmptyStackException();
		}
		T theHead = null;
		if(!myIsEmpty) {
			theHead = myHead.myData;
			if(myHead.myPrev == null) {
				myIsEmpty = true;
				myHead = null;
				mySize--;
				return theHead;
			}
			mySize--;
			myHead.myPrev.myNext = null; 
			myHead = myHead.myPrev;
			
		}
		return theHead;
	}
	public int size() {
		return mySize;
	}
	public String toString() {
		Node hasNext = this.myHead;
		StringBuilder sb = new StringBuilder();
		while(hasNext != null) {
			sb.append(hasNext.myData);
			hasNext = hasNext.myPrev;
		}
		return sb.toString();
	}
	
	class Node {
		Node myNext;
		Node myPrev;
		T myData;
		public Node(Node next, Node prev, T data) {
			myPrev = prev;
			myNext = next;
			myData = data;
		}
	}
}
