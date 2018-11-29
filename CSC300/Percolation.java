package algs15.perc;

import algs15.*;

// Uncomment the import statements above.
/*
 * 
 * Lexus Nguyen
 * 402
 * 
 */

// You can test this using InteractivePercolationVisualizer and PercolationVisualizer
// All methods should make at most a constant number of calls to the UF data structure,
// except percolates(), which may make up to N calls to the UF data structure.
public class Percolation {
	int N;
	boolean[] open;
	int top;
	int bottom;
	private QuickUnionUF quf;
	
	public Percolation(int N) {
		this.N = N;
		this.open = new boolean[N*N];
		this.bottom = N*N+1;
		this.top = N*N;
		quf = new QuickUnionUF(N * N + N);
	}
	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		open[i*N+j] = true;
		if (i == 0) {
			quf.union(quf.find(i*N+j), top);
		}
		if (i == N-1) {
			quf.union(bottom, quf.find(i*N+j));
		}
		if (i > 0 && isOpen(i-1,j) == true) {
			if (isFull(i,j)) {
				quf.union(quf.find((i - 1) * N + j) , quf.find(i*N+j) );
			}
			else if (isFull(i-1,j)) {
				quf.union(quf.find(i*N+j) , quf.find((i - 1) * N + j) );
			}
			else {
				quf.union(quf.find((i - 1) * N + j) , quf.find(i*N+j) );
			}
		}
		if (i < N - 1 && isOpen(i+1,j) == true) {
			if (isFull(i,j)) {
				quf.union(quf.find((i + 1) * N + j) , quf.find(i*N+j) );
			}
			else if (isFull(i+1,j)) {
				quf.union(quf.find(i*N+j) , quf.find((i + 1) * N + j) );
			}
			else {
				quf.union(quf.find((i + 1) * N + j) , quf.find(i*N+j) );
			}
		}
		if (j > 0 && isOpen(i,j-1) == true) {
			if (isFull(i,j)) {
				quf.union(quf.find(i * N + (j - 1)) , quf.find(i*N+j) );
			}
			else if (isFull(i,j - 1)) {
				quf.union(quf.find(i*N+j) , quf.find(i * N + (j - 1)) );
			}
			else {
				quf.union(quf.find(i * N + (j - 1)) , quf.find(i*N+j) );
			}
		}
		if (j < N - 1 && isOpen(i,j + 1) == true) {
			if (isFull(i,j)) {
				quf.union(quf.find( i * N +(j + 1)) , quf.find(i*N+j) );
			}
			else if (isFull(i,j + 1)) {
				quf.union(quf.find(i*N+j) , quf.find( i * N +(j + 1)) );
			}
			else {
				quf.union(quf.find( i * N +(j + 1)) , quf.find(i*N+j) );
			}
		}
	}
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		return open[i*N+j];
	}
	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		return quf.connected(i*N+j,top);

	}
	// does the system percolate?
	public boolean percolates() {
		return quf.connected(top, bottom);

	}
}