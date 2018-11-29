package algs11;

/**
 * NAME : LEXUS NGUYEN
 */

import java.util.Arrays;
import stdlib.*;

/**
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may also edit the function "main" to test your code.
 *
 * You must not change the declaration of any method. This will be true of every
 * skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static double minValue (double[] list) {
 * </pre>
 * to something like
 * <pre>
 *     public static void minValue (double[] list) {
 * </pre>
 * or
 * <pre>
 *     public static double minValue (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes. You should not use any HashSets
 * or ArrayLists, or anything else! In addition, each of your functions should go
 * through the argument array at most once. The only exception to this
 * removeDuplicates, which is allowed to call numUnique and then go through the
 * array once after that.
 */
public class CSC300Program2 {

	/**
	 * numUnique returns the number of unique values in an array of doubles.
	 * Unlike the previous questions, the array may be empty and it may contain
	 * duplicate values. Also unlike the previous questions, you can assume the
	 * array is sorted.
	 *
	 * Your solution must go through the array exactly once. Your solution must
	 * not call any other functions. Here are some examples (using "=="
	 * informally):
	 *
	 * <pre>
	 *     0 == numUnique(new double[] { })
	 *     1 == numUnique(new double[] { 11 })
	 *     1 == numUnique(new double[] { 11, 11, 11, 11 })
	 *     8 == numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 })
	 *     8 == numUnique(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88 })
	 * </pre>
	 */
	public static int numUnique (double[] list) {
		int counter = 1;
		if (list.length == 0) {
			return 0;
		}
		for (int i = 1; i < list.length; i++) {
			int check = 0;
			for (int j = 0; j < i; j++) {
				if (list[j] == list[i]) {
					check += 1;
				}
				else {
					check += 0;
				}
			}
			if (check == 0) {
				counter ++;
			}
				
		}
		
		return counter;
		
	}

	/**
	 * removeDuplicates returns a new array containing the unique values in the
	 * array. There should not be any extra space in the array --- there should
	 * be exactly one space for each unique element (Hint: numUnique tells you
	 * how big the array should be). You may assume that the list is sorted, as
	 * you did for numUnique.
	 *
	 * Your solution may call numUnique, but should not call any other
	 * functions. After the call to numUnique, you must go through the array
	 * exactly one more time. Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   new double[] { }
	 *     == removeDuplicates(new double[] { })
	 *   new double[] { 11 }
	 *     == removeDuplicates(new double[] { 11 })
	 *     == removeDuplicates(new double[] { 11, 11, 11, 11 })
	 *   new double[] { 11, 22, 33, 44, 55, 66, 77, 88 }
	 *     == removeDuplicates(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 })
	 *     == removeDuplicates(new double[] { 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88 })
	 * </pre>
	 */
	public static double[] removeDuplicates (double[] list) {
		int rightLength = numUnique(list);
		double[] allUnique = new double[rightLength];
		int counter = 0;
		if (list.length == 0) {
			return allUnique;
		}
		else {
			for (int i = 0; i < list.length; i++) {
				int check = 0;
				for (int j = 0; j < i; j++) {
					if (list[j] == list[i]) {
						check += 1;
					}
					else {
						check += 0;
					}
				}
				if (check == 0) {
					allUnique[counter] = list[i];
					counter ++;
				}
				
			}
		}
		
		return allUnique;
		
	}
/**
 * Objective:  become familiar with the drawing routines in the StdDraw library.  page 43
 * 
 * #1 :  create a cohesive image.  
 */
	public static void drawASimplePicture() {
		// To Do:   remove the code below and replace your code which meets the above spec
		StdDraw.square(.5, .5, .5);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(.1, .4, .9, .4);
		StdDraw.line(.1, .4, .2, .3);
		StdDraw.line(.8, .3, .9, .4);
		StdDraw.line(.2, .3, .8, .3);
		
		StdDraw.line(.2, .3, .3, .4);
		StdDraw.line(.3, .4, .4, .3);
		StdDraw.line(.4, .3, .5, .4);
		StdDraw.line(.5, .4, .6, .3);
		StdDraw.line(.6, .3, .7, .4);
		StdDraw.line(.7, .4, .8, .3);
		
		StdDraw.circle(.3, .65, .1);
		StdDraw.circle(.7, .65, .1);
	}
	/**
	 * A test program, using private helper functions.  See below.
	 * To make typing tests a little easier, I've written a function to convert strings to arrays.  See below.
	 */
	public static void main (String[] args) {		
		// for numUnique: array must be sorted
		testNumUnique (0, new double[] {});
		testNumUnique(1,new double[] {11});
		testNumUnique(1,new double[] {11,11,11,11});
		testNumUnique(4,new double[] {11,21,31,41});
		testNumUnique(4,new double[] {11,11,11,21,31,31,31,31,41});
		testNumUnique(4,new double[] {11,21,21,21,31,41,41,41,41});
		testNumUnique(4,new double[] {11,11,21,21,21,31,31,41,41,41,41});
		testNumUnique(8,new double[] {11,11,11,11,21,31,41,41,41,41,41,51,51,61,71,81,81});
		testNumUnique(8,new double[] {11,21,31,41,41,41,41,41,51,51,61,71,81});
		testNumUnique(7,new double[] {11,11,11,11,21,31,41,41,41,41,41,51,51,61,71});
		testNumUnique(7,new double[] {11,21,31,41,41,41,41,41,51,51,61,71});
		testNumUnique(8,new double[] {-81,-81,-81,-81,-71,-61,-51,-51,-51,-51,-41,-41,-31,-21,-11,-11,-11});

		// for removeDuplicates: array must be sorted
		testRemoveDuplicates (new double[] {}, new double[] {});
		testRemoveDuplicates (new double[] {11}, new double[] {11} );  
		testRemoveDuplicates (new double[] {11}, new double[] {11,11,11,11} );  
		testRemoveDuplicates (new double[] {11,21,31,41}, new double[] {11,21,31,41} ); 
		testRemoveDuplicates (new double[] {11,21,31,41}, new double[] {11,11,11,21,31,31,31,31,41} ); 
		
	
		testRemoveDuplicates(new double[] {11,21,31,41} , new double[] {11,21,21,21,31,41,41,41,41} );
		testRemoveDuplicates(new double[] {11,21,31,41} , new double[] {11,11,21,21,21,31,31,41,41,41,41} );
		testRemoveDuplicates(new double[] {11,21,31,41,51,61,71,81} , new double[] {11,11,11,11,21,31,41,41,41,41,41,51,51,61,71,81,81} );
		testRemoveDuplicates(new double[] {11,21,31,41,51,61,71,81} , new double[] {11,21,31,41,41,41,41,41,51,51,61,71,81} );
		testRemoveDuplicates(new double[] {11,21,31,41,51,61,71} , new double[] {11,11,11,11,21,31,41,41,41,41,41,51,51,61,71} );
		testRemoveDuplicates(new double[] {11,21,31,41,51,61,71} , new double[] {11,21,31,41,41,41,41,41,51,51,61,71} );
		testRemoveDuplicates(new double[] {-81,-71,-61,-51,-41,-31,-21,-11} , new double[] {-81,-81,-81,-81,-71,-61,-51,-51,-51,-51,-41,-41,-31,-21,-11,-11,-11} );
		StdOut.println ("Finished tests");
		
		drawASimplePicture();
	}

	private static void testNumUnique (int expected, double[] list) {
	
		int actual = numUnique (list);

		if (expected != actual) {
			StdOut.format ("Failed numUnique([%s]): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void testRemoveDuplicates (double[] expected, double[] list) {
	
		double[] actual = removeDuplicates (list);

		// != operator does not do what we want on arrays, use   equals   function from Arrays  class
		if (! Arrays.equals (expected, actual)) {
			StdOut.format ("Failed removeDuplicates([%s]): Expecting (%s) Actual (%s)\n", Arrays.toString(list), Arrays.toString (expected), Arrays.toString (actual));
		}
	}

}
