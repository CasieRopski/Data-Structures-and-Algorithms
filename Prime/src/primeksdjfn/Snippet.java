package primeksdjfn;

public class Snippet {
	//checks whether an int is prime or not.
	boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}

