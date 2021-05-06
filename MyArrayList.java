/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This is the class that I have created my own
 * Array List using the interface ArrayList.
 * 
 * It does not have a specific data type allowing me to 
 * store both planets and the identification number in another class.
 * 
 */

//importing necessary imports
import interfaces.ArrayList;
import interfaces.Node;

public class MyArrayList<T> implements ArrayList<T>{

	//data needed for the arraylist
    private T data;
    private int size = 10;
    private int length = 0;
    private MyNode[] array = new MyNode[size];

    //add node to the end
    @Override
    public void addNode(Node n){
    	if ((length+1)==size) {
    		MyNode[] tempArray = new MyNode[size*2];
    		for (int i = 0; i < array.length; i++) {
    			tempArray[i] = array[i];
    		}
    		array = tempArray;
    	}
        array[length++] = new MyNode(n);
    }

    //insert node at i-th position
    @Override
    public void insertNode(Node n, int i){
    	if (i>length) 
    		i = length;
    	else {
    		for (int j = length; j > i; j--)
    			array[j] = array[j-1];
    	}
    	
    	if (i==size) {
    		MyNode[] tempArray = new MyNode[size*2];
    		for (int i2 = 0; i2 < array.length; i2++) {
    			tempArray[i2] = array[i2];
    		}
    		array = tempArray;
    	}
		
        array[i] = new MyNode(n);
        length++;
    }

    //remove node
    @Override
    public void removeNode(Node n){
        int index = -1;
        for (int i = 0; i < length; i++){
            if (array[i].equals(new MyNode(n))) index = i;
        }
        if (index == -1) return;
        for (int loop = index; loop < length - 1; loop++) array[loop] = array[loop + 1];
        length = Math.max(length - 1, 0);
    }

    //remove node at i-th position
    @Override
    public Node<T> removeNode(int i){
        for (int loop = i; loop < length - 1; loop++) array[loop] = array[loop + 1];
        length = Math.max(length - 1, 0);
        return null; 
    }

    //get node at i-th list
    @Override
    public Node getNode(int i){
        return array[i];
    }

    //returns first node
    @Override
    public Node getFirstNode(){
        return array[0];
    }

    //returns last node
    @Override
    public Node getLastNode(){
        if (length == 0) return null;
        return array[length-1];
    }

    //returns size of arraylist
    @Override
    public int size(){
        return length;
    }
    
    /*
	 * Returns a String representation of this array list, each node is separated by a space
	 */
	public String toString() {
		String str = "";
		if (length > 0) {
			for (int i = 0; i < length-1; i++) str += array[i] + ", ";
			str += array[length-1];
		}
		return str;
	}
    
}
