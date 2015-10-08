import java.util.Scanner;

/* Data Structures & Algorithms 
 * @version 1.0 06 September 2015
 * @author Victor Lora and Casie Ropski
 * @Description: A program that implements a recursive function
 *    to compute the number of cannon balls in
 *    a pyramid.
 */

public class CannonBall {

	public static void main (String [] args) {

		Scanner keyb = new Scanner(System.in);  // Keyboard scanner.
		int cannonBalls;                        // Number of cannonballs
		                                        //    in the pyramid.
		int layers;                             // Number of layers in
		                                        //    the pyramid.

		do {
			// Prompt for and read the number of layers of
			// cannonballs in the pyramid.

		    System.out.println("\nNumber of layers (-1 to quit): ");
		    layers = keyb.nextInt();

		    if (layers != -1) {
		    	cannonBalls = cannon(layers);  // Determine and report the
		    	                               // number of cannonballs.
		    	System.out.printf("There are %d cannonballs in the %d layers.\n",
		    			                                  cannonBalls, layers);
		    }
		} while (layers != -1);
	}


	public static int cannon(int n)
	{
		int retVal = 0; // Initialize return value.
		if (n==1){		// Base step, if layers is == 1, return 1.
			return 1;
		} else {
			retVal += (n*n) + cannon(n-1); // Inductive step, square n and add 
										   // it to the layer above it.
			return retVal;		// Returns the number of cannonballs as they total. 		
		}
		
	}
}
