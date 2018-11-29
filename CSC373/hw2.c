void add_index(int numbers[], int len) {
int i;
for (i = 0; i < len; i ++)
	numbers[i] = numbers[i] + i;


}

void min_and_max(int scores[], int len, int *minptr, int *maxptr) {
int i;
if ( scores[0] < scores[1]){
	*minptr = scores[0];
	*maxptr = scores[1];
} else{
	*minptr = scores[1];
	*maxptr = scores[0];
}
for (i = 2; i < len; i ++)
	if ( scores[i] < *minptr ){
		*minptr = scores[i];
	}
	else if ( scores[i] > *maxptr ){
		*maxptr = scores[i];
	}
}

void copy_array(int *dest, int* src, int len) {

int i;
for ( i=0; i<len; i++)
	dest[i] = src[i];


}

void reverse_array(int x[], int len) {
int new[len];
int i;
for ( i = 0; i < len; i ++){
	new[i] = x[len - (i+1)];
};	
for ( i = 0; i < len; i++){
	x[i] = new[i];
};
}

void convert_temp(int deg, char scale, int *dptr, char *sptr) {

char f = 'F';
char c = 'C';
if (scale == f){
	*dptr = ( (deg - 32)/  9 )* 5 ;
	*sptr = 'C';
}
else if (scale == c){
	*dptr = ((deg / 5)* 9) + 32;
	*sptr = 'F';
}

}


