/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This is the class that I have created my own
 * Node using the interface Node.
 * 
 * It does not have a specific data type allowing me to 
 * store any type of data (whether a string or integer) in it
 * 
 */

//importing necessary imports
import interfaces.Node;

public class MyNode<T> implements Node<T>{
	//current node value
	private T data;
	
	//addresses to the next and previous nodes
	private Node<T> next;
	private Node<T> prev;
	
	//constructor method for node
	public MyNode(T n)
	{
		data = n;
	}

	//get value of node
	@Override
	public T getValue() {
		return data;
	}

	//set value of node
	@Override
	public void setValue(T n) {
		data = n;
	}

	//set node value of the next node
	@Override
	public void setNext(Node<T> n) {
		next = n;
	}

	//set node value of the previous node
	@Override
	public void setPrev(Node<T> n) {
		prev = n;
	}

	//get the next node value
	@Override
	public Node<T> getNext() {
		return next;
	}

	//get the previous node value
	@Override
	public Node<T> getPrev() {
		return prev;
	}

	//returning node value as string
	public String toString()
	{
		return data.toString();
	}
}