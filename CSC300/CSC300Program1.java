package algs11;

import java.util.Arrays;
import stdlib.*;

/**
 * CSC300Program1  version 1.0
 * 
 *   Lexus Nguyen
 *   402
 *   
 *   Does your program have compile errors?     Yes
 *   Which TODOs have NOT been completed correctly?   Delete the lines below for TODOs that are correct

 * 
 * This is a skeleton file for your programming assignment. Edit the sections marked TODO. 
 *
 * Unless specified otherwise, you must not change the declaration of any method. 
 * This will be true of every skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static double valRange (double[] list)
 * </pre>
 * to something like
 * <pre>
 *     public static void valRange (double[] list)
 * </pre>
 * or
 * <pre>
 *     public static double valRange (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes.  You should not use any HashSets
 * or ArrayLists, or anything else! Exception: You may use Math.abs  (look it up)
 * In addition, each of your functions should go through the argument array at most once. 
 */
public class CSC300Program1 {

	/**
	 * valRange returns the difference between the maximum and minimum values
	 * in the array; Max-Min.  You can assume the array is nonempty. Your solution must go
	 * through the array exactly once.  Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *    0  == valRange (new double[] { -7 })
	 *    10 == valRange (new double[] { 1, 7, 8, 11 })
	 *    10 == valRange (new double[] { 11, 7, 8, 1 })
	 *    18 == valRange (new double[] { 1, -4, -7, 7, 8, 11 })
	 *    24 == valRange (new double[] { -13, -4, -7, 7, 8, 11 })
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static double valRange (double[] list) { 

		double min = list[0];
		double max = list[0];
		for (int i = 0; i < list.length; i++) {
			if (min > list[i]) {
				min = list[i];
			}
		}
		for (int i = 0; i < list.length; i++) {
			if (max < list[i]) {
				max = list[i];
			}
		}
		return max - min;
	}
	/**
	 * distanceBetweenMinAndMax returns difference between the minPosition and
	 * the maxPosition in an array of doubles.
	 *
	 * You can assume the array is nonempty and all elements are unique.
	 * Your solution must go through the array exactly once.  Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   0 == distanceBetweenMinAndMax(new double[] { -7 })                      // -7,-7 are the min and max
	 *   3 == distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11 }),    // -7,11
	 *   5 == distanceBetweenMinAndMax(new double[] { -13, -4, -7, 7, 8, 11 })   // -13,11
	 *   1 == distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 }) // -9,11
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int distanceBetweenMinAndMax (double[] list) {
		int max = 0;
		int min = 0;
		if (list.length < 2) {
			return 0;
		}
		else {
			for (int i = 1; i < list.length;i++) {
				if (list[min] > list[i]) {
					min = i;
				}
				else if (list[min] < list[i]) {
					if (list[i] > list[max]) {
						max = i;
					}
				}
				
			}
		}
		return Math.abs(max - min);
	}
	/**
	 * posOfElementClosestTo returns the position of the element in the array that is
	 * closest to the theVal parameter, in the absolute value sense. 
	 * In the event of a tie, return the position of the first value found 
	 * (starting from 0) 
	 *
	 * You can assume the array is nonempty and all values are unique. Your solution
	 * must go through the array exactly once. Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   0 == posOfElementClosestTo(3, new double[] { -7 })                      // -7 is closest to 3, it's in pos 0
	 *   5 == posOfElementClosestTo(3, new double[] { 11, -4, -7, 7, 8, 1 }),    // 1 is closest to 3, it's in pos 5
	 *   2 == posOfElementClosestTo(-6, new double[] { 1, -4, -7, 7, 8, 11 }),   // -7 is closest to -6, it's in pos 2
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int posOfElementClosestTo( double theVal, double[] list) {
		int index = 0;
		double closeDiff = Math.abs(list[0] - theVal);
		for (int i = 1; i < list.length; i++) {
			if (Math.abs(list[i] - theVal) < closeDiff) {
				closeDiff = Math.abs(list[i] - theVal);
				index = i;
			}
		}
		return index;

	}
	/**
	 * A test program, using private helper functions.  See below.
	 */
	public static void main (String[] args) {
		// for ValRange: array must be nonempty
		testValRange (0, new double[] {11} );
		testValRange (0, new double[] { 11,11,11,11,11} );
		testValRange (10, new double[] {11, 1} );
		testValRange (10, new double[] {1,11} );
		testValRange (32, new double[] {11, 21, 9, 31, 41});
		testValRange (32, new double[] {41, 21, 9, 31, 11});
		testValRange (32, new double[] {11, 41, 9, 31, 21});
		testValRange (32, new double[] {-41, -21, -11, -31, -9});
		testValRange (32, new double[] {-9, -21, -11, -31, -41});
		testValRange (32, new double[] {-41, -11, -9, -31, -21});
		testValRange (32, new double[] {-11, -21, -41, -31, -9});		
		testValRange (0.7, new double[] { 0.2, -0.5, -0.1});
		StdOut.println();

		// for distanceBetweenMinAndMax: array must be nonempty with unique elements
		testDistanceBetweenMinAndMax (0, new double[] {11});
		testDistanceBetweenMinAndMax (0, new double[] {-11});
		testDistanceBetweenMinAndMax (4, new double[] {9, 11, 21, 31, 41});
		testDistanceBetweenMinAndMax (3, new double[] {11, 9, 21, 31, 41});
		testDistanceBetweenMinAndMax (1, new double[] {11, 21, 9, 3, 41});
		testDistanceBetweenMinAndMax (1, new double[] {11, 21, 31, 9, 41});
		testDistanceBetweenMinAndMax (1, new double[] {11, 21, 31, 41, 9});
		testDistanceBetweenMinAndMax (4, new double[] {9, -11, -21, -31, -41});
		testDistanceBetweenMinAndMax (3, new double[] {-11, 9, -21, -31, -41});
		testDistanceBetweenMinAndMax (2, new double[] {-11, -21, 9, -31, -41});
		testDistanceBetweenMinAndMax (1, new double[] {-11, -21, -31, 9, -41});
		testDistanceBetweenMinAndMax (1, new double[] {-11, -21, -31, -41, 9});
		testDistanceBetweenMinAndMax (3, new double[] {1, -4, -7, 7, 8, 11, 9, -5});
		testDistanceBetweenMinAndMax (3, new double[] {0.1, -0.4, -0.7, 0.7, 0.8, 1.1, 0.9, -0.5});
		
		StdOut.println();
		// for posOfElementClosestTo: array must be nonempty with unique elements
		testPosOfElementClosestTo( 0, 3 , new double[] {4});      
		testPosOfElementClosestTo( 2, 3 , new double[] {1,2,3,4}); 
		testPosOfElementClosestTo( 2, 7 , new double[] {2,3,5,4,9});
		testPosOfElementClosestTo( 3, 1 , new double[] {6,8,7,2,4});
		testPosOfElementClosestTo( 1, 2 , new double[] {9,1,5});
		StdOut.println ("Finished tests");
	}
	
	/* Test functions --- lot's of similar code! */
	private static void testValRange (double expected, double[] list) {
		double actual = valRange (list);
		if (expected != actual) {
			StdOut.format ("Failed valRange(%s): Expecting (%.1f) Actual (%.1f)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void testDistanceBetweenMinAndMax (int expected, double[] list) {
		
		int actual = distanceBetweenMinAndMax (list);
		
		if (expected != actual) {
			StdOut.format ("Failed distanceBetweenMinAndMax(%s): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}	
	
	private static void testPosOfElementClosestTo (int expected, double theVal, double[] list) {
	
		int actual = posOfElementClosestTo (theVal,list);
		
		if (expected != actual) {
			StdOut.format("Failed posOfElementsclosestTo(%s): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
		}
}