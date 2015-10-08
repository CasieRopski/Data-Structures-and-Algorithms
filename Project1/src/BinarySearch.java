
/*
 *    A comparison of iterative vs recursive
 *    binary search algorithms. Requires a sorted array.
 */

import java.util.*;

public class BinarySearch{
//checks whether an int is prime or not.
boolean isPrime(int n) {
  for(int i=2;i<n;i++) {
      if(n%i==0)
          return false;
  }
  return true;
}
}