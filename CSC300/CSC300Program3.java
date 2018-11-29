package algs11;
import java.util.Arrays;
import stdlib.*;

/**
CSC300Program3  version 1.0
 * 
 *   Lexus Nguyen
 *   402
 *   
 *   Does your program have compile errors?     Yes / No
 *   Which TODOs have been completed correctly?   Delete the lines below for TODOs that are NOT correct
 *   
 *   
 *  
 *  
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may add new functions. You may also edit the function "main" to test your
 * code.
 *
 * You must not add static variables. You MAY add static functions, just not
 * static variables.
 *
 * It is okay to add functions, such as
 *
 * <pre>
 *     public static double sumHelper (double[] list, int i, double sumSoFar) {
 * </pre>
 *
 * but it is NOT okay to add static variables, such as
 *
 * <pre>
 * public static int x;
 * </pre>
 *
 * As in homework 1,2 you must not change the declaration of any method.
 * 
 * You can edit the main function all you want. I will not run your main
 * function when grading. For example, you can "comment out" calls to other
 * functions when doing TODO 3 or testing your other functions
 */
public class CSC300Program3 {

	/**
	 * As a model, here is a minValue function, both iteratively and recursively
	 *
	 * precondition:   list is not empty
	/** iterative version */
	public static double minValueIterative (double[] list) {
		double result = list[0];
		int i = 1;
		while (i < list.length) {
			if (list[i] < result) result = list[i];
			i = i + 1;
		}
		return result;
	}

	/** recursive version 
	 * Find minimum of a list of size N starting at location 0
	 * Smaller problem is :  Find minimum of list of size N-1, starting at 0
	 * 
	 * precondition:   list is not empty
	 */
	public static double minValueRecursive (double[] list) {
		return minValueHelper (list, list.length);  
	}
	private static double minValueHelper (double[] list, int n) {
		if (n == 1)           // the list of size 1 is the single element list[0]
			return list[0];   //  the minimum of this list is just that element.
			
		//  else:  find minimum of smaller list
		
		double minOfSmallerList = minValueHelper( list, n-1);  // recursive call, 'smaller' list

			//  now compare min of smaller list to 'last' element of this list
			//  the list is of size n, the 'last' element is at position n-1
			//    because indexes start at 0.
		double theMin;

		if ( list[n-1] < minOfSmallerList)
			theMin = list[n-1];
		else
			theMin = minOfSmallerList;

		return theMin;
	}

	/**
	 * PROBLEM 1: Translate the following sum function from iterative to
	 * recursive.
	 *
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 * 
	 * Precondition:  a list of doubles, - maybe empty!
	 */
	public static double sumIterative (double[] a) {
		double result = 0.0;
		int i = 0;
		while (i < a.length) {
			result = result + a[i];
			i = i + 1;
		}
		return result;
	}
	
	public static double sumRecursive (double[] a) {
		return sumRecursiveHelper( a, a.length);
		
	}
	private static double sumRecursiveHelper(double[] a, int listLength) {
		if (listLength == 0) {
			return 0;
		}
		else {
			return a[listLength - 1] + sumRecursiveHelper( a , listLength - 1);
		}
		
		
	}

	/**
	 * PROBLEM 2: Do the same translation for this in-place reverse function
	 * 
	 * in-place means:  you may not create an extra array
	 *
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 * 
	 * Your helper function must be parameterized to allow a smaller problem to
	 * be specified.  How do you reverse an array of size N?
	 * (the answer is NOT: reverse an array of size N-1 ! )
	 */
	public static void reverseIterative (double[] a) {
		int hi = a.length - 1;
		int lo = 0;
		while (lo < hi) {
			double loVal = a[lo];
			double hiVal = a[hi];
			a[hi] = loVal;
			a[lo] = hiVal;
			lo = lo + 1;
			hi = hi - 1;
		}
	}

	public static void reverseRecursive (double[] a) {
		int low = 0;
		int high = a.length - 1;
		a = reverseRecursiveHelper( a, low, high);
	}
	private static double[] reverseRecursiveHelper (double[] a, int lo, int hi) {
		if ( lo > hi) {
			return a;
		}
		else {
			double lowValue;
			double highValue;
			lowValue = a[lo];
			highValue = a[hi];
			a[hi] = lowValue;
			a[lo] = highValue;
			return reverseRecursiveHelper( a, lo + 1, hi - 1);
		}
	}
	
	/**
	 * PROBLEM 3: Run runTerribleLoop for one hour. You can stop the program using
	 * the red "stop" square in eclipse. Fill in the OUTPUT line below with the
	 * numbers you saw LAST --- edit the line, replacing the two ... with what
	 * you saw:
	 *
	 * OUTPUT: terribleFibonacci(56)=225851433717
	 *
	 * Comment: the code uses "long" variables, which are like "int", but
	 * bigger. It's because fibonacci numbers get really big really fast.
	 */
	public static void runTerribleLoop () {
		for (int N = 0; N < 100; N++)
			StdOut.format ("terribleFibonacci(%2d)=%d\n", N, terribleFibonacci (N));
	}
	
	public static void runTerribleSomeValues () {
		StdOut.format ("terribleFibonacci(%2d)=%d\n", 13, terribleFibonacci (13));
		StdOut.format ("terribleFibonacci(%2d)=%d\n", 7,  terribleFibonacci (7));
		StdOut.format ("terribleFibonacci(%2d)=%d\n", 21, terribleFibonacci (21));
	}
	public static long terribleFibonacci (int n) {
		if (n <= 1) return n;
		return terribleFibonacci (n - 1) + terribleFibonacci (n - 2);
	}

	/**
	 * PROBLEM 4: The implementation of terribleFibonacci is TERRIBLE! Write a
	 * more efficient version of fibonacci. Do not change runFibonacciLoop or
	 * runFibonacciSomeValues.
	 *
	 * To make fibonacci run faster, you want it so that each call to
	 * fibonacci(n) computes the fibonacci numbers between 0 and n once, not
	 * over and over again.
	 *
	 * Comment: You will want to use a local variable of type "long" rather than
	 * type "int", for the reasons discussed above.
	 *
	 * Comment: At some point, your fibonacci numbers might become negative.
	 * This is normal and expected.
	 * http://en.wikipedia.org/wiki/Integer_overflow We discuss this at length
	 * in our systems classes.
	 *
	 * You may not use any "fields" to solve this problem (a field is a variable
	 * that is declared "outside" of the function declaration --- either before
	 * or after).
	 */
	public static void runFibonacciLoop () {
		for (int N = 0; N < 100; N++)
			StdOut.format ("fibonacci(%2d)=%d\n", N, fibonacci (N));
	}
	public static void runFibonacciSomeValues () {
		StdOut.format ("fibonacci(%2d)=%d\n", 13, fibonacci (13));
		StdOut.format ("fibonacci(%2d)=%d\n", 7,  fibonacci (7));
		StdOut.format ("fibonacci(%2d)=%d\n", 21, fibonacci (21));
	}
	public static long fibonacci (int n) {
		long nValue , total;
		nValue = 0;
		total = 1;
		if (n <= 1) {
			total = n;
		}
		else {
			for (int i = 1; i < n; i++) {
				long nSum = nValue + total;
				nValue = total;
				total = nSum;
			}
		}
		return total;
	}

	public static void main (String[] args) {
		double[] list0 = new double[] {};
		double[] list1 = new double[] { 5 };
		double[] list2 = new double[] { -3, 5 };
		double[] list3 = new double[] { 2, -3, 5 };
		double[] list4 = new double[] { -1, 2, -3, 5 };
		double[] list5 = new double[] { 0, -1, 2, -3, 5 };
		
		StdOut.println (sumRecursive (list0));
		StdOut.println (sumRecursive (list1));
		StdOut.println (sumRecursive (list2));
		StdOut.println (sumRecursive (list3));
		StdOut.println (sumRecursive (list4));
		StdOut.println (sumRecursive (list5));
		
		reverseRecursive (list1);
		StdOut.println (Arrays.toString (list1));
	
		reverseRecursive (list2);
		StdOut.println (Arrays.toString (list2));
		
		reverseRecursive (list3);
		StdOut.println (Arrays.toString (list3));
		
		reverseRecursive (list4);
		StdOut.println (Arrays.toString (list4));
		
		reverseRecursive (list5);
		StdOut.println (Arrays.toString (list5));

// unComment the lines below as needed to test your code
		
		//runTerribleSomeValues ();   
		runTerribleLoop ();
		//runFibonacciSomeValues ();
		//runFibonacciLoop();
	}

}
