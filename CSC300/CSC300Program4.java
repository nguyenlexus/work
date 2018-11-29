package algs11;
import java.text.DecimalFormat;
import stdlib.*;
public class CSC300Program4 {

	// this class maintains a linked structure via the instance variable first

	/* 
	 * CSC300Program4  version 1.1
	 *  fixed format specifier in function:
	 *      testPositionOfFirstOccurence
	 * 
	 *   Lexus Nguyen
	 *   402
	 *   
	 *   Does your program have compile errors?     No
	 *   Which TODOs have been completed correctly?   Delete the lines below for TODOs that are NOT correct
	 *   
	 * 
	 * Complete the methods below.
	 * None of the methods should modify the list, unless that is the purpose of the method.
	 * 
	 * You may not add any fields to the node or list classes.
	 * You may not add any methods to the node class.
	 * 
	 * You MAY add private methods to the CSC300Program4 class (helper functions for the recursion). 
	 */
	static boolean showMeSuccess = true;   // set to true to also see Success notifications for tests
										  //  set to false to only see Failure notifications for tests

	static class Node {
		public Node (double item, Node next) { this.item = item; this.next = next; }
		public double item;
		public Node next;
	}

	Node first;

	// a function to compute the size of the list, using a loop
	//  an empty list has size 0
	public int sizeIterative () {
		int size = 0;
		Node temp = first;
		while (temp != null) {
			size ++;
			temp = temp.next;
		}
		return size;
	}


	// a function to compute the size of the list using recursion
	// empty list has size 0
	// You will want to create a helper function to do the recursion
	public int sizeRecursive () {
		return sizeRecursiveHelper(first);
	}
	private int sizeRecursiveHelper(Node n) {
		if (n == null) {
			return 0;
		}
		else {
			return 1 + sizeRecursiveHelper(n.next);
		}
	}


	// a function to compute the position of the first occurrence of NUM in the list, 
	// where NUM is passed as a parameter 
	// and positions are counted as an offset from the beginning.  
	//
	// if NUM is 5.0 and 5.0 is the FIRST element, the position is 0
	// if NUM is 5.0 and it does not appear, return -1
	//
	// you can write this iteratively or recursively,  but you should only have one loop or recursive helper
	// I would expect
	// [0,1,2,5,5,5,5,5,8,9].positionOfFirstNumFromBeginning(5) == 3
	// [0,1,3,4,5,5,2,5,8,9].positionOfFirstNumFromBeginning(2) == 6


	public int positionOfFirstNumOccurrence (double num) {
		int index = -1;
		Node temp = first;
		while (temp != null) {
			index ++;
			if (temp.item == num) {
				return index;
			}
			temp = temp.next;
		}
		return -1;
	}

	// return the second-to-last value in the list,   
	// Precondition:  the list has at least 2 values
	//  you can write this iteratively or recursively,  but you should only have one loop or recursive helper
	//  you may not call any other method (e.g.  size  )
	//
	// [0,1,2,5,5,5,5,5,8,9].secondToLastValue() == 8
	// [0,1].secondToLastValue() == 0
	public double secondToLastValue ( ) {
		Node temp = first;
		Node tempNext = temp.next;
		while (tempNext.next != null) {
			temp = temp.next;
			tempNext = temp.next;
		}
		return temp.item;
		
	}

	// a function to delete the second node if it exists, if not, the list is unchanged
	// [0,1,2,8,9].deleteSecondIfPossible() --> [0,2,8,9]
	// [0,9].deleteSecondIfPossible() --> [0]
	// [].deleteSecondIfPossible() --> []
	public void deleteSecondIfPossible () {
		if (first == null) {
			return;
		}
		else if (first.next == null) {
			return;
		}
		else {
			if (first.next.next == null) {
				first.next = null;
				return;
			}
			else {
				Node temp = first.next;
				first.next = null;
				first.next = temp.next;
				return;
			}
		}
	}

	// for debugging purposes, you may comment/uncomment the two calls in main below 
	// you should restore the calls as below when you submit your solution
	public static void main (String args[]) {
		//mainDebug ();    
		mainRunTests ();
	}
	private static void mainDebug () {
		// Use this for debugging!
		// Add the names of helper functions if you use them.
		Trace.drawStepsOfMethod ("sizeIterative");
		Trace.drawStepsOfMethod ("sizeRecursive");
		Trace.drawStepsOfMethod ("positionOfFirstNumOccurrence");
		Trace.drawStepsOfMethod ("secondToLastValue");
		Trace.drawStepsOfMethod ("deleteSecondIfPossible");
		Trace.run (); 
		// To Use:  Put the test here you want to debug:
		testSizeIterative (4, "11 -21.2 31 41");
	}
	private static void mainRunTests () {
		testSizeIterative (0, "");
		testSizeIterative (1, "11");
		testSizeIterative (2, "11 21");	
		testSizeIterative (4, "11 -21.2 31 41");

		testSizeRecursive (0, "");
		testSizeRecursive (1, "11");
		testSizeRecursive (2, "11 21");	
		testSizeRecursive (4, "11 -21.2 31 41");

		testPositionOfFirstNumOccurrence (-1, 99, "");
		testPositionOfFirstNumOccurrence (-1, 99,  "11");
		testPositionOfFirstNumOccurrence (-1, 99, "11 21 31 41");
		testPositionOfFirstNumOccurrence (0, 11, "11 21 31 41");
		testPositionOfFirstNumOccurrence (3, 11, "5 21 31 11");
		testPositionOfFirstNumOccurrence (0, 11, "11 11 11 11 11");
		testPositionOfFirstNumOccurrence (2, 31, "11 21 31 31 41");

		testSecondToLastValue (31, "11 21 31 41");
		testSecondToLastValue (21, "11 21 31");
		testSecondToLastValue (11, "11 21");
		
		testDeleteSecondIfPossible ("[ ]", "");
		testDeleteSecondIfPossible ("[ 11 ]", "11");
		testDeleteSecondIfPossible ("[ 11 ]", "11 12");
		testDeleteSecondIfPossible ("[ 11 13 ]", "11 12 13");
		testDeleteSecondIfPossible ("[ 11 13 14 ]", "11 12 13 14");
		
		StdOut.println ("Finished tests");
	}


	/* ToString method to print */
	public String toString () { 
		// Use DecimalFormat #.### rather than String.format 0.3f to leave off trailing zeroes
		DecimalFormat format = new DecimalFormat ("#.###");
		StringBuilder result = new StringBuilder ("[ ");
		for (Node x = first; x != null; x = x.next) {
			result.append (format.format (x.item));
			result.append (" ");
		}
		result.append ("]");
		return result.toString ();
	}

	/* Method to create lists */
	public static CSC300Program4 of(String s) {
		Node first = null;
		String[] nums = s.split (" ");
		for (int i = nums.length-1; i >= 0; i--) {
			try { 
				double num = Double.parseDouble (nums[i]); 
				first = new Node (num, first);  
			} catch (NumberFormatException e) {
				// ignore anything that is not a double
			}
		}
		CSC300Program4 result = new CSC300Program4 ();
		result.first = first;
		return result;
	}

	// lots of copy and paste in these test!
	private static void testSizeIterative (int expected, String sList) {
		CSC300Program4 list = CSC300Program4.of (sList);
		String sStart = list.toString ();
		int actual = list.sizeIterative();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sizeIterative(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sizeIterative(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success sizeIterative():  Result: %d  input: %s\n", actual, sStart);
	}	


	private static void testSizeRecursive (int expected, String sList) {
		CSC300Program4 list = CSC300Program4.of (sList);
		String sStart = list.toString ();
		int actual = list.sizeRecursive();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.sizeRecursive(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.sizeRecursive(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess)  
			StdOut.format ("Success sizeRecursive():  Result: %d  input: %s\n", actual, sStart);
	}	


	private static void testPositionOfFirstNumOccurrence (int expected, double num, String sList) {
		CSC300Program4 list = CSC300Program4.of (sList);
		String sStart = list.toString ();
		int actual = list.positionOfFirstNumOccurrence(num);
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.positionOfFirstNumOccurrence(): Expecting [%d] Actual [%d]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.positionOfFirstNumOccurrence(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success positionOfFirstNumOccurrence():  Result: %d  position of first %.0f in %s\n", actual, num , sStart);
	}	

	private static void testSecondToLastValue (double expected, String sList) {
		CSC300Program4 list = CSC300Program4.of (sList);
		String sStart = list.toString ();
		double actual = list.secondToLastValue();
		boolean status = true;
		if (expected != actual) {
			StdOut.format ("Failed %s.secondToLastValue(): Expecting [%f] Actual [%f]\n", sStart, expected, actual);
			status = false;
		}
		String sEnd = list.toString ();
		if (! sStart.equals (sEnd)) {
			StdOut.format ("Failed %s.secondToLastValue(): List changed to %s\n", sStart, sEnd);
			status = false;
		}
		if ( status && showMeSuccess) 
			StdOut.format ("Success secondToLastValue():  Result: %.0f  second to last value in %s\n", actual, sStart);
	}	
	

	private static void testDeleteSecondIfPossible (String expected, String sList) {
		CSC300Program4 list = CSC300Program4.of (sList);
		CSC300Program4 elist = CSC300Program4.of (expected);
		list.deleteSecondIfPossible();
		String actual = list.toString ();
		expected = elist.toString();
		
		boolean status = true;
		if (! expected.equals(actual) ) {
			StdOut.format ("Failed %s.deleteSecondIfPossible(): Expecting [%s] Actual [%s]\n", sList, expected, actual);
			status = false;
		}
	
		if ( status && showMeSuccess) 
			StdOut.format ("Success deleteSecondIfPossible():  Before: %s  after  %s\n", expected, actual);
	}

}
