
/* Authors: Jalal Kahn & Casie Ropski
 * Date: 1 October 2015
 * Class: Data Structures and Algorithms
 * Description:  
 *   An implementation of the Map interface.
 *   
 *   A doubly linked list implementation is used.
 *   Front and rear sentinel nodes are used.
 */

public class Map <K, V> implements MapInterface<K, V>
{
	private Node header;   // Pointer to the first item in the Map.
	
	
	// The Constructor sets up the sentinel nodes with
	// header pointing to the front.
	
	public Map()
	{
		Node front = new Node();   // Construct the sentinel
		Node rear = new Node();    // nodes.
		
		front.prev = null;   // Link the sentinels.  All map
		front.next = rear;   // items will be between the sentinels
		rear.prev  = front;  // so each items is assured to have 
		rear.next  = null;   // a node in front and in back.
		
		header = front;  // The header points to the front node.
	}
	
	
	public int getSize()
	{
		Node check = header.next;		
		if (check == null){			//Checks if header.next is
			return 0;				// null.
		}
									// Implements a count integer
		int count = 0;				// that increases by 1 for
									// every node in map.
		while (check.next != null){	
			check = check.next;
			count++;
		}	
		
		return count;				// Return count.
	}
	
	public void makeEmpty()
	{
		Node front = new Node();   // Construct the sentinel
		Node rear = new Node();    // nodes.
		
		front.prev = null;   // Link the sentinels.  All map
		front.next = rear;   // items will be between the sentinels
		rear.prev  = front;  // so each items is assured to have 
		rear.next  = null;   // a node in front and in back.
		
		header = front;  // The header points to the front node.
	}
	
	
	public void insert(K key, V value)
	{
		Node temp = new Node(); 	// Create new node with key
		temp.key = key;				// and value
		temp.value = value;
		
		Node check = header.next;							
									
		while (check != null        // Checks if key is already
				&& check.next != null){ // present in Map as long 
			if(check.key.equals(key)) { // as map isn't empty.
				return;
			} else {
				check = check.next; 
			}
		}	
		
		temp.prev = header;			// Points header.next to 
		temp.next = header.next;	// temp Node. 
		
		if (header.next != null){  // Checks if next Node is 
			temp.next.prev = temp; // null. If not, set pointer
			temp.prev.next = temp; // to temp Node and next Node
		} else {
			header.next = temp; 
		}
		
	}
		
	
	
	
	public void remove(K key)
	{
		Node check = header.next;
		
		if (check == null){			//Checks if header.next is
			return;					// null.
		}
		
		Node toRemove = null;
		
		while (check.next != null){	// Search through map for key.
			if(check.key.equals(key)){	// Save reference Node if
				toRemove = check;	// found.
				break;
			} else {
				check = check.next; 
			}
		}
		
		if (toRemove == null){		// Check if key exists
			return;
		} else {					// Change pointers to remove
			toRemove.prev.next = toRemove.next;	// node. 
			toRemove.next.prev = toRemove.prev; 
		}
		
	}
	
	
	public V getValue(K key)
	{
		Node check = header.next;
		
		if (check == null){			//Checks if header.next is
			return null;			// null.
		}
		
		
		while (check.next != null){	// Search through map for key.
			if(check.key.equals(key)){	// Return value if key is 
				return check.value; // found.
			} else {
				check = check.next; 
			}
		}
		
		return null;				// Return null if key isn't
									// found.
	}
	
	public boolean isEmpty()
	{
		if(getSize() > 0) {    //If size of map is greater than
			return false;	   // 0, return false. Else return 
		} else {			   // true. 
			return true;
		}
	}
	
	/*
	 *   toString() - return a String representation
	 *                of the map.
	 */
	
	public String toString()
	{
		String str = "The Map\n--------------\n";
		
		Node ptr = header.next;
		
		if (ptr == null){			//Checks if header.next is
			System.out.println("Map is empty.");	// null.
			return null;
		}
		
		while (ptr.next != null) {   // For each item ...
			str = str + "key: ";              // use the toString()
		    str = str + ptr.key.toString();   // method for each key
		    str = str + "   ";                // and value to append
			str = str + "value: ";            // its String  
			str = str + ptr.value.toString(); // representation to
			str = str + "\n";                 // the Map's String
			ptr = ptr.next;                   // representation.
		}
		
		str = str + "--------------\n";
		
		return str;
	}
	
	/*
	 *    Inner Class - Node objects for Map items
	 *                  in a doubly linked list.
	 *    
	 */

	private class Node
	{
		public K key;       // The item's key.
		public V value;     // The item's value.
		public Node prev;   // Pointer to the previous Node.
		public Node next;   // Pointer to the next node.
	}

}
