/*
 *   class QueueCirc
 *   
 *   A Circular Implementation of the generic QueueInterface.
 */

public class QueueCirc<T> implements QueueInterface<T>
{
	private int front = 0;   // Index of the front item in the queue.
	private int rear = -1;   // Index of the rear item in the queue.
	
	T[] A = (T[]) new Object[20];  // Generic arrays cannot be constructed in Java.
	                               // A solution is to create an array of Object
	                               // and type cast as an array of a generic type.
	                               // Ignore any warnings the compiler generates.
	/*
	 *    The Queue constructor.
	 */
	
	public QueueCirc()
	{
		
	}

	/*
	 *    enqueue() - add an item to the rear of the queue.
	 *                Do nothing if the queue is full.
	 */
	
	public void enqueue(T item)
	{
		if (!isFull()){			//Checks if it's full		
			rear++;				//Increment rear
			if (rear == A.length-1){ //Checks if rear is now in last
				rear = 0; 	   	//array position, sets it to the next
				A[rear] = item;  //section, which is one.
			}	
			A[rear]=item;		//Set item into new rear position.
		}
		
	}
	
    /*
     *   dequeue() - delete and return the front item
     *               in the queue. Return null if 
     *               the queue is empty.
     */
	
	public T dequeue()		//gets error in line 103 in circtest
	{
		front++;		 //increment front
		return A[front]; //print new front value
	}
	
	/*
	 *    front() - Return (but do not delete) the item
	 *              at the front of the queue.
	 */
	
    public T front()
    {
    	return A[front]; //return front item
    }
    
    /*
     *    isEmpty() - returns true if the queue is empty 
     *                else returns false.
     */
    
    public boolean isEmpty()
    {
    	if ((front-1)==rear){	//If front is greater than
    		return true;		//rear by one, it is empty
    	} else {			 
    		return false;	
    	}
    }
    
    /*
     *    isFull() - returns true if the queue is empty 
     *               else returns false.
     */
    
    public boolean isFull()
    {
    	if ((front-2)==rear){		
    		return true;		
    	} else {				
    		return false;
    	}
    }
    
    /*
     *  toString() - return a printable display of
     *               the items in the queue.
     */
    
    public String toString()	
    {
    	String result = "Array is Empty";
    	String value = "";
    	
    	if (isEmpty()){		//If array is empty, return 
    		return result;	//a statement saying that.
    	}
    	
    	int i = front;
    	while (i <(A.length-1)){ //run through array 
    		i++;				  //and print each value
    		value += A[i] +", ";  //starting at front.
    	}
    	
    	return value;				//return all value
    	}
}
