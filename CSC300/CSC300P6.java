package algs11;
import stdlib.*;
// version 1.0

public class CSC300P6  {

	/* Lexus Nguyen
	 * 402
	 *   
	 * Complete the ToDos:
	 *  
	 * You may not add any fields to the node or list classes.
	 * You may not add any methods to the node class.
	 * 
	 * You MAY add additional instance and static methods to assist in carrying out
	 *     the experiments
	 * 
	 */

	static class Node {
		public Node (double item, Node next) { this.item = item; this.next = next; }
		public double item;
		public Node next;
	}
	int N;       // number of nodes in list
	Node first;  // reference to the first node in the list

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
	
	//  fill the array arr with random values
	public static void fillArrayWithData( double[] arr ) {
		int N = arr.length;
		for (int  i=0; i < N; i++) {
			arr[i] = StdRandom.uniform(0, N);
		}
	}
	
	//  find the maximum in the array arr
	public static double arrayMax(double[] arr) {
		int size = arr.length;
		double max = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	public double llMax( double[] arr ) {
		int size = arr.length;
		Node temp = first;
		double maxValue = first.item;
		
		for (int i = 0;temp.next != null || i < size; i++) {
			temp = temp.next;
			if (temp.item > maxValue) {
				maxValue = temp.item;
			}
		}
		
		return maxValue;
	}
	
	// fill the list instance with the values from the array arr
	public void fillWithData(double[] arr) {
		int N = arr.length;
		Node  cur = new Node(arr[N-1],null);
	
		for ( int i=N-2; i >= 0; i--) {
			cur = new Node(arr[i],cur);
		}
		first = cur;
		this.N = N;
	}
	public static void main (String args[]) {
	
		// comment/uncomment these to run the various experiments
		
		//runTimingExperiment0(1024);     
		
		/*runTimingExperiment1(1024);   
		runTimingExperiment1(2048);
		runTimingExperiment1(4096);
		runTimingExperiment1(8192);
		runTimingExperiment1(32768);
		
		runTimingExperiment2(1024);   
		runTimingExperiment2(2048);
		runTimingExperiment2(4096);
		runTimingExperiment2(8192);
		runTimingExperiment2(32768);*/
		
		runTimingExperiment3(1024);   
		runTimingExperiment3(2048);
		runTimingExperiment3(4096);
		runTimingExperiment3(8192);
		runTimingExperiment3(32768); 
	}

	private static void runTimingExperiment0(int N) {
	
		// This is an example of the testing framework to use.
		// for this example, we are simply determining the running time of:
		// creating and filling an array and a linked list.
		// Note:  for timing purposes & for the operations we are performing,
		//        it does not matter what values are actually stored in the array
		//        in other contexts, it might.
		//        In the code below, the array and linked list are filled with exactly the 
		//        same data in the same order.
		// 
		// It's possible that the Create & fill could be pretty quick, so to allow the
		//    slow system clock to tick, we will perform the desired operations a bunch of times.
		//    the variable, 'repetitions' will dictate how many times to repeat the operation.
		//    You can just choose a really high number - but your program may take a long time.
		//    OR you can do trial and error.  Start small - maybe 10 and increase by a factor of 10.
		//    keep going until the average converges to something.
		//    The number needed could very well depend on the value of N
		
		double[] data = new double[0];	// the array to hold the data
		double avergeCreateAndFillTime;	
	
		int repetitions = 10000;
		// Start a timer, then create and fill the array  'repetitions'  times
	
		//  determine running time to create and fill an array of N values
		Stopwatch arrayCreateAndFillTimer = new Stopwatch();
		for (int i=1; i < repetitions; i++ ) {
			data = new double[N];
			fillArrayWithData( data);
		}
		avergeCreateAndFillTime = arrayCreateAndFillTimer.elapsedTime() / repetitions;
		StdOut.format("Array size: %d  Average time to create and fill %8.4e \n", N, avergeCreateAndFillTime);
	
	    //  determine running time to create and fill a list of N values
		// Note the code below uses the data array that was filled in the above loop
		Stopwatch listCreateAndFillTimer = new Stopwatch();
		for (int i=1; i < repetitions; i++ ) {
			CSC300P6 llOfData = new CSC300P6();  // llOfData *is a* linked list of data values
			llOfData.fillWithData( data);
		}
		avergeCreateAndFillTime = listCreateAndFillTimer.elapsedTime() / repetitions;
		StdOut.format("List size: %d  Average time to create and fill %8.4e \n", N, avergeCreateAndFillTime);

	}
	
	//
	// Experiment 1.   Determine the running time to access a random element, k, 
	//                 in an array and in a linked list.
	//          
	//			       this experiment tests:
	//						the array []  operator
	//                      the list  at  function  
	//					with random integers from [0, N).  Hint: StdRandom.uniform(N)
	//
	//				  for a user defined number of repetitions.
	//
	//  	An array and linked list of size N are created/filled for you, just add
	//      the code to do the timing tests
	//
	
	private static void runTimingExperiment1(int N) {
		double[] data;
		
		// create an array and linked list of size N, fill them with random data
		
		data = new double[N];
		CSC300P6 llOfData = new CSC300P6();
		fillArrayWithData( data);
		llOfData.fillWithData( data);
		int repetitions = 10000;
		
		// suggestion:  use StdRandom.uniform(0, N)  to generate a random position in [0,N)
		
		// TODO 1a)   
		//          Start a timer, 
		//			then inside a loop (repetitions) 
		//               access random locations in the array. 
		//              you can just assign the accessed value to a local variable
		//          after loop: print the average time to access a random array location
		//         
		//			you will need to do trial and error on the repetitions to
		//          get the average time to converge 
		
		Stopwatch randomSpotTimer = new Stopwatch();
		double averageRandomSpotTime;
		for (int i = 0; i < repetitions; i++) {
			int randomSpot = StdRandom.uniform(0,N);
			double random = data[randomSpot];
		}
		averageRandomSpotTime = randomSpotTimer.elapsedTime() / repetitions;
		StdOut.format("Array size: %d  Average time to find random spot %8.4e \n", N, averageRandomSpotTime);
		
		
		// TODO 1b)   
		//          Start a timer, 
		//          then inside a loop (repetitions) 
		//          	access random locations in the list using the 'at' function
		//              you can just assign the accessed value to a local variable
		//          after the loop: print the average time to access a random list location
		//         
		//			you will need to do trial and error on the repetitions to
		//          get the average time to converge 
		
		Stopwatch randomLocationTimer = new Stopwatch();
		double averageRandomLocationTime;
		for (int i = 0; i < repetitions; i++) {
			int randomLocation = StdRandom.uniform(0,N);
			double random = llOfData.at(randomLocation);
		}
		averageRandomLocationTime = randomLocationTimer.elapsedTime() / repetitions;
		StdOut.format("Linked List size: %d  Average time to find random location %8.4e \n", N, averageRandomLocationTime);
		
	}
	//
	// Experiment 2.   Determine the running time to do both:
	//						delete a random element and then 
	//						insert an element in a random location 
	//                 in an array and in a linked list.
	//          
	//			       this experiment tests:
	//						the functions:  arrayDelete, arrayInsert 
	//                      the functions:  llDelete, llInsert  
	//					with random locations from [0, N).  Hint: StdRandom.uniform(N)
	//
	//				  for a user defined number of repetitions.
	//
	//  	An array and linked list of size N are created/filled for you, just add
	//      the code to do the timing tests
	//
	
	private static void runTimingExperiment2(int N) {
		double[] data;
		
		// create an array and linked list of size N, fill them with random data
		
		data = new double[N];
		CSC300P6 llOfData = new CSC300P6();
		fillArrayWithData( data);
		llOfData.fillWithData( data);
		int repetitions = 10000;
		
		// TODO 2a)   
		//          Start a timer, 
		//			then inside a loop (repetitions) 
		//               delete a value at a random location in the array. 
		//               then insert a value at a random location in the array
		//          after loop: print the average time to perform the two operations
		//
		//		    doing a delete and then an insert means the array will
		//          stay the same 'size' between iterations
		//         
		//			you will need to do trial and error on the repetitions to
		//          get the average time to converge 
		
		Stopwatch deleteInsertArrayTimer = new Stopwatch();
		double averageDeleteInsertArrayTime;
		for (int i = 0; i < N; i++) {
			
			int randomDelete = StdRandom.uniform(0,N);
			int randomInsert = StdRandom.uniform(0,N);
			double randomValue = StdRandom.uniform();
			arrayDelete(data, randomDelete);
			arrayInsert(data, randomValue, randomInsert);
			
		}
		
		averageDeleteInsertArrayTime = deleteInsertArrayTimer.elapsedTime() / repetitions;
		StdOut.format("Array size: %d  Average time to insert and delete in array %8.4e \n", N, averageDeleteInsertArrayTime);
		
	
		// TODO 2b)   
		//          Start a timer, 
		//          then inside a loop (repetitions) 
		//               delete a value at a random location in the list. 
		//               then insert a value at a random location in the list
		//          after loop: print the average time to perform the two operations
		//
		//		    doing a delete and then an insert means the list will
		//          stay the same 'size' between iterations
		//         
		//			you will need to do trial and error on the repetitions to
		//          get the average time to converge  
		
		Stopwatch llDeleteInsertTimer = new Stopwatch();
		double averagellDeleteInsertTime;
		for (int i = 0; i < repetitions; i ++) {
			int randomDelete = StdRandom.uniform(0,N);
			int randomInsert = StdRandom.uniform(0,N);
			double randomValue = StdRandom.uniform();
			llOfData.llDelete(randomDelete);
			llOfData.llInsert(randomValue, randomInsert);
		}
		
		averagellDeleteInsertTime = llDeleteInsertTimer.elapsedTime() / repetitions;
		StdOut.format("Array size: %d  Average time to insert and delete in linked list %8.4e \n", N, averagellDeleteInsertTime);
	}
	

	//
	// Experiment 3.   Determine the running time to do both:
	//						traverse a list, performing an action on each element 
	//                 in an array and in a linked list.
	//          
	//			       this experiment tests:
	//						the functions:  findArrayMax 
	//										findListMax
	//
	//				  for a user defined number of repetitions.
	//
	//  	An array and linked list of size N are created/filled for you, just add
	//      the code to do the timing tests
	//
	private static void runTimingExperiment3(int N) {
		double[] data;
		
		// create an array and linked list of size N, fill them with random data
		
		data = new double[N];
		CSC300P6 llOfData = new CSC300P6();
		fillArrayWithData( data);
		llOfData.fillWithData( data);
		int repetitions = 10000;
		
		// TODO 3a)   
		//          Start a timer, 
		//			then inside a loop (repetitions) 
		//               call a function to find the maximum in an array
		//          after loop: print the average time to perform the two operations
		//
		//         
		//			you will need to do trial and error on the repetitions to
		//          get the average time to converge 
		
		Stopwatch arrayMaxTimer = new Stopwatch();
		double averageArrayMaxTime;
		for (int i = 0; i < repetitions; i++) {
			double maximum = arrayMax(data);
		}
		averageArrayMaxTime = arrayMaxTimer.elapsedTime() / repetitions;
		StdOut.format("Array size: %d  Average time to find max in array %8.4e \n", N, averageArrayMaxTime);
		
		
		// TODO 3b)   
		//          Start a timer, 
		//          then inside a loop (repetitions) 
		//               invoke a function to find the maximum in an list
		//          after loop: print the average time to perform the two operations
		//
		//         
		//			you will need to do trial and error on the repetitions to
		//          get the average time to converge 
		
		Stopwatch llMaxTimer = new Stopwatch();
		double averagellMaxTime;
		for (int i = 0; i < repetitions; i++) {
			double maximum = llOfData.llMax(data);
		}
		averagellMaxTime = llMaxTimer.elapsedTime() / repetitions;
		StdOut.format("Array size: %d  Average time to find max in linked list %8.4e \n", N, averagellMaxTime);		
		
		
	}
	
}
