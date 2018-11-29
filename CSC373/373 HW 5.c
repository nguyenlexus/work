/*
	Lexus Nguyen
	CSC 373 Section 601
	May 27, 2018
	Assignment 5
*/


int f1 (int n){
	n = n - 96;
	return 25 <= n;
}

int f2 ( int a, int b, int c){
	bool ab = (a = b);
	bool ac = (a = c);
	return b;
}

int f3 ( int n ){
	n = -(n);
	return n + 63;
}

int f4 ( int n ) {
	if ( n <= 1 ){
		return 1;
	}
	else{
		n += 1;
		int x = 2;
		int y = 1;
		while ( n != x ){
			y = x * y;
			x += 1;
		}
		return y;
	}
}

int f5 ( int m, int n ){
	if ( n < 1){
		return 1;
	}
	else {
		int x = 4 + m;
		if (x < m ){
			return 0;
		}
		else{
			m += 4;
			n -= 1;
			x = 0;
			int y;
			while ( x != n ){
				x += 1;
				y = m;
				m += 4;
				if ( m < y ){
					return 0;
				}
			}
			return 1;
		}
	}
}