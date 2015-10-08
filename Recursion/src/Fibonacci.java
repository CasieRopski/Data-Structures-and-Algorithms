
/* Data Structures & Algorithms 
 * @version 1.0 10 September 2015
 * @author Casie Ropski
 * @Description:
 * 	 Recursive implementations of
 *   a function to compute Fibonacci numbers.
 */

import java.util.Scanner;

public class Fibonacci 
{
	private static int count = 0;  // Counts the number of recursive
	                               // calls in computing a fibonacci number.
	
	private static int n;          // Which Fibonacci number we're computing
	private static long nth_fib;   // Stores the nth Fibonacci number
	
	private static long[] F = new long[200];  // Stores computed Fibonacci numbers
	                                          // so we don't have to recompute them.
	public static void main(String[] args)
	{
		Scanner keyb = new Scanner(System.in);  // Keyboard scanner.
		
		for (int i = 0; i < 200; i++)  // For fibB algorithm, all fib numbers
			F[i] = -1;                 // are initially not computed.
		
		// Compute a sequence of fibonacci numbers.
		
		// First use the inefficient algorithm with repeated recalculations.
		
		for (int n = 0; n <= 40; n++) {
			
			count = 0;
			nth_fib = fib(n);
			
			System.out.printf("%d   %d  %d\n", n, nth_fib, count);
		}
		
		// Next test the more efficient algorithm, fibB(), using dynamic programming
		// with no recomputations. 
		
		do {
			System.out.println("\nEnter n and I'll compute the nth Fibonocci number.");
			System.out.print("Enter n (-1 to quit): ");
		    n = keyb.nextInt();
			
			if (n != -1) {
				count = 0;
			    nth_fib = fibB(n);
			    System.out.printf("%d   %d   %d\n", n, nth_fib, count);
			}
		} while (n != -1);
	}
		
	public static long fib(int n)
	{
		// return the value of the nth fibonacci number.
        count++; //Add one to count every time fib is called
		
		if (n<=1) {
        	return n;
        } else { 
        	return fib(n-1) + fib(n-2);  }
	}
		
	public static long fibB(int n) 
	{		
		// Return the value of the nth fibonacci number.
		count++; 					//Adds to the count whenever fibB is run.
		if (n<=1){
			return n;
		
		//count is increased by one for each time fib is run.	
		} else if ((F[n-1] == -1) && (F[n-2] == -1)) { //Checks if both previous 
													   // values have been found 	
			F[n-2] = fibB(n-2);						   // before. If not, compute
			F[n-1] = fibB(n-1);						   // both. F[n-2] is first so
													   // fibB(n-2) is not done 2x.
    		
		} else if (F[n-1] == -1) {		//Checks if only F[n-1] is found
	    	
			F[n-1] = fibB(n-1);		    //if not, compute it.
	    	
		} else if (F[n-2] == -1) {		//Checks if only just F[n-2] is found
    		
			F[n-2] = fibB(n-2);			//if not, compute it
		}
		return F[n-1] + F[n-2];		//Sums the two values before n. 
	}
}