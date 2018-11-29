package algs11;
import java.text.DecimalFormat;
import java.util.Arrays;

import stdlib.*;

public class CSC300P5LinkedList {

	/* Version 1.0
	 * 
	 * Lexus Nguyen
	 * 402
	 *   
	 * Does your program have compile errors?     No
	 * 
	 */

	static class Node {
		public Node (double item, Node next) { this.item = item; this.next = next; }
		public double item;
		public Node next;
	}
	int N;       // number of nodes in list
	Node first;  // reference to the first node in the list


	static boolean showMeSuccess = true;   // set to true to also see Success notifications for tests
										  //  set to false to only see Failure notifications for tests


	// llDelete
	//
	// delete the element in position k (where k is between 0 and N-1 inclusive)
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//              :  N >=1 ; list is not empty
	public void llDelete (int k) {
		if (k < 0 || k >= N) throw new IllegalArgumentException ("Invalid positon in LL");
		Node temp = first;
		if (N == 1) {
			first = null;
			return;
		}
		else if (k == 0) {
			first = first.next;
			return;
		}
		else {
			for (int i = 0; temp != null && i < k-1; i++) {
				temp = temp.next;
			}
			Node next = temp.next.next;
			temp.next = next;
			return;
		}
	}
	
	// at
	//
	// return the value in the node at position k
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//              :  N >=1 ; list is not empty
	public double at( int k ) {
		if (k < 0 || k >= N) throw new IllegalArgumentException ("Invalid positon in LL");
		Node temp = first;
		
		if (k == 0) {
			return first.item;
		
		}
		else {
			for (int i = 0; i < k; i ++) {
				temp = temp.next;
			
			}
			return temp.item;
		}
	}
	
	// llInsert
	//
	// insert a new node into the list at position k with value, val
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N
	//               list may be empty
	public void llInsert( double val, int k) {
		Node temp = new Node( val, null);
		Node previous = first;
		if (first == null) {
			first = temp;
		}
		else if ( k == 0) {
			temp.next = first;
			first = temp;
			
		}
		else {
			for ( int i = 0; i < k-1; i++) {
				previous = previous.next;
			}
			
			Node next = previous.next;
			previous.next = null;
			temp.next = next;
			previous.next = temp;
		}
		
	}
	

	// arrayInsert
	//
	// insert the value in the array at position k
	// positions are numbered starting with 0
	// elements k through N-2 are moved 'up' one position to make a space for the new value
	//           i.e.  element k moves to position k+1
	//           the initial value in position N-1 is not preserved
	// preconditions:  0 <= k <= N-1
	//               
	public static void arrayInsert( double[] arr, double value, int k) {
		double next = 0;
		double current = 0;
		int size = arr.length;
		if (size < 3) {
			next = arr[k];
			arr[k] = value;
		}
		else {
			for (int i = 0; i < size; i++) {
				if (k == 0) {
					if (k == i) {
						next = arr[i];
						arr[i] = value;
					}
					else {
						current = arr[i];
						arr[i] = next;
						next = current;
					}
				}
				else if (k > 0){
					next = arr[i];
					if (i < k) {
						
					}
					else if (i == k) {
						current = next;
						arr[i] = value;
					}
					else {
						arr[i] = current;
						current = next;
					}
				}

			}
		}
	}
	
		// arrayDelete
		//
		// delete the value in the array at position k
		// positions are numbered starting with 0
		// elements k+1 through N-1 are moved 'down' one position 
		//       to close the space left by deleting element k
		//       set element N-1  to  -99
		// preconditions:  0 <= k <= N-1
		//  
	public static void arrayDelete( double[] arr, int k) {
		double next = 0;
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			next = arr[i+1];
			if (i == k) {
				arr[i] = next;
			}
			else if (i > k) {
				arr[i] = next;
			}
		}
	}
	
	public static void main (String args[]) {
		runListTests ();
		runArrayTests();
	}

	private static void runListTests () {

		testLLdelete (0, "11", "[ ]");
		testLLdelete (0, "11 21 31 41 51", "[ 21 31 41 51 ]");
		testLLdelete (1, "11 21 31 41 51", "[ 11 31 41 51 ]");
		testLLdelete (2, "11 21 31 41 51", "[ 11 21 41 51 ]");
		testLLdelete (3, "11 21 31 41 51", "[ 11 21 31 51 ]");
		testLLdelete (4, "11 21 31 41 51", "[ 11 21 31 41 ]");

		testLLat (0, "11", 11);
		testLLat (0, "11 21 31 41 51", 11);
		testLLat (1, "11 21 31 41 51", 21);
		testLLat (2, "11 21 31 41 51", 31);
		testLLat (3, "11 21 31 41 51", 41);
		testLLat (4, "11 21 31 41 51", 51);

		testLLinsert (99, 0, "", "[ 99 ]");
		testLLinsert (99, 1, "11", "[ 11 99 ]");
		testLLinsert (99, 0, "11 21 31 41 51", "[ 99 11 21 31 41 51 ]");
		testLLinsert (99, 1, "11 21 31 41 51", "[ 11 99 21 31 41 51 ]");
		testLLinsert (99, 2, "11 21 31 41 51", "[ 11 21 99 31 41 51 ]");
		testLLinsert (99, 3, "11 21 31 41 51", "[ 11 21 31 99 41 51 ]");
		testLLinsert (99, 4, "11 21 31 41 51", "[ 11 21 31 41 99 51 ]");
		testLLinsert (99, 5, "11 21 31 41 51", "[ 11 21 31 41 51 99 ]");

		StdOut.println ("Finished list tests");
	}
	private static void runArrayTests () {
		testArrayInsert (99, 1, "11", "11 99");
		testArrayInsert (99, 0, "11 21 31 41 51", "99 11 21 31 41 51");
		testArrayInsert (99, 1, "11 21 31 41 51", "11 99 21 31 41 51");
		testArrayInsert (99, 2, "11 21 31 41 51", "11 21 99 31 41 51");
		testArrayInsert (99, 3, "11 21 31 41 51", "11 21 31 99 41 51");
		testArrayInsert (99, 4, "11 21 31 41 51", "11 21 31 41 99 51");
		testArrayInsert (99, 5, "11 21 31 41 51", "11 21 31 41 51 99");

		testArrayDelete (0, "11 21 31 41 51", "21 31 41 51");
		testArrayDelete (1, "11 21 31 41 51", "11 31 41 51");
		testArrayDelete (2, "11 21 31 41 51", "11 21 41 51");
		testArrayDelete (3, "11 21 31 41 51", "11 21 31 51");
		testArrayDelete (4, "11 21 31 41 51", "11 21 31 41");

		StdOut.println ("Finished array tests");
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

	/* Method to create lists from a string*/
	public static CSC300P5LinkedList of(String s) {
		int N = 0;
		Node first = null;
		String[] nums = s.split (" ");
		for (int i = nums.length-1; i >= 0; i--) {
			try { 
				double num = Double.parseDouble (nums[i]); 
				first = new Node (num, first);  
				N++;
			} catch (NumberFormatException e) {
				// ignore anything that is not a double
			}
		}
		CSC300P5LinkedList result = new CSC300P5LinkedList ();
		result.first = first;
		result.N = N;
		return result;
	}
	// method to create array of doubles from a string.
	// one extra position is allocated to accommodate a single insertion
	public static double[]  arrayFrom(String s) {
		int N = 0;
		String[] nums = s.split (" ");
		double[] arr  = new double[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			try { 
				double num = Double.parseDouble (nums[i]); 
				arr[i] = num;
			} catch (NumberFormatException e) {
				// ignore anything that is not a double
			}
		}
		arr[nums.length] = -99;

		return arr;
	}
	
	// 'fudged' method to compare partially filled arrays, sort of.
	public static boolean ArraysEquals( double[] a, double[] b, int n) {
		for (int i=0; i < n; i++)
			if ( a[i] != b[i]) return false;
		return true;
	}

	// testing methods,  best left alone
	
	// test the linked list   delete method
	private static void testLLdelete (int k, String list, String expected) {
		CSC300P5LinkedList actual = CSC300P5LinkedList.of (list);

		actual.llDelete (k);

		boolean status = true;
		if (!expected.equals (actual.toString ())) {
			StdOut.println (String.format ("Failure llDelete: expected=%s, actual=%s", expected, actual.toString ()));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success llDelete: delete element %d  Before: %s  after  %s\n", k, list, actual.toString());

	}

	// test the linked list   at method
	private static void testLLat (int k, String list, double expected) {
		CSC300P5LinkedList theList = CSC300P5LinkedList.of (list);

		double	 actual = theList.at(k);

		boolean status = true;
		if (expected != actual) {
			StdOut.println (String.format ("Failure       at: expected=%.0f, actual=%.0f", expected, actual));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success       at:  value at pos %d Expected: %s  actual  %s\n", k, expected, actual);
	}

	// test the linked list   insert method
	private static void testLLinsert (double value, int k, String list, String expected) {
		CSC300P5LinkedList actual = CSC300P5LinkedList.of (list);

		actual.llInsert (value, k);

		boolean status = true;
		if (!expected.equals (actual.toString ())) {
			StdOut.println (String.format ("Failure llInsert: expected=%s, actual=%s", expected, actual.toString ()));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success llInsert:  value %.0f at pos %d  Before: %s  after  %s\n", value, k, list.toString(), actual.toString());

	}

	// test the arrayInsert method
	private static void testArrayInsert (double value, int k, String list, String expected) {

		double[] actual = arrayFrom(list);
		double[] exp = arrayFrom(expected);
		arrayInsert(actual, value, k);

		boolean status = true;

		if( !ArraysEquals(actual,  exp,actual.length)) {
			StdOut.println (String.format ("Failure arrayInsert: expected=%s, actual=%s", expected, Arrays.toString(actual)));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success arrayInsert: %.0f at pos %d  Before: %s  after  %s\n", value, k, list.toString(), Arrays.toString(actual));

	}
	
	// test the arrayDelete method
	private static void testArrayDelete ( int k, String list, String expected) {

		double[] actual = arrayFrom(list);
		double[] exp = arrayFrom(expected);
		arrayDelete(actual, k);

		boolean status = true;

		if( !ArraysEquals(actual,  exp, actual.length-1)) {
			StdOut.println (String.format ("Failure arrayDelete: expected=%s, actual=%s", expected, Arrays.toString(actual)));
			status = false;
		}

		if ( status && showMeSuccess) 
			StdOut.format ("Success arrayDelete: value at pos %d  Before: %s  after  %s\n",  k, list.toString(), 
					Arrays.toString(Arrays.copyOf(actual, actual.length-2)));

	}

}
