hw3.c                                                                                               0000644 3654631 3642101 00000001251 13263716506 012776  0                                                                                                    ustar   slytinen                        domain users                                                                                                                                                                                                           /* CSC 373 Sections 601, 610 Spring 2018
   Lexus Nguyen
   CSC 373
   April 22, 2018
*/

int strcmp373(char str1[], char str2[]) {
	byte[] string1 = ASCIIEncoding.ASCII.GetBytes(str1);
	byte[] string2 = ASCIIEncoding.ASCII.GetBytes(str2);
	int index;
	while (string1[index] != string2[index] || string1[index] && string2[index] == 48;){
		index ++;
	}
	if (string1[index] < string2[index]){
		return ( string1[index] - string2[index]); 
	}
	else if (string2[index] < string1[index]){
		return string1[index] - string2[index];
	}
	else if (string1[index] == 48){
		return 0 - string2[index];
	}
	else if (string2[index] == 48){
		return string1[index];
	}
	else{
		return 0;
	}
}

char *strcat373(char dest[], char src[]) {
	char *srcpointer = src;
	dest[dest.length - 1] = *srcpointer;
	return dest; 
}

char *strchr373(char str[], char c) {
	int strindex = 0;
	while (str[strindex] != c || str[strindex] == '0'){
		index ++;
	}
	if (str[strindex] == c){
		return str[index:];
	}
	else{
		return '0';
	}
}

char *strncpy373(char dest[], char src[], int n) {
  int i;
  for (i = 0; i < n; i++){
	  dest[i] = src[i];
	  i ++;
	  
  return dest;
}

char *strncat373(char dest[], char src[], int n) {
  int ind;
  for (ind = 0; ind < n; ind ++){
	  dest[dest.length - 1] = src[ind];
  }
  
  return dest;
} 
                                                                                                                                                                                                                                                                                                                                                       hw3main.c                                                                                           0000644 3654631 3642101 00000004025 13263716512 013642  0                                                                                                    ustar   slytinen                        domain users                                                                                                                                                                                                           #include <stdio.h>
#include <string.h>
#include "hw3.c"
/*
#include "strcmp373.c"
#include "strcat373.c"
#include "strchr373.c"
#include "strncpy373.c"
#include "strncat373.c"
*/

int main() {

  // 1.  strcmp373
  printf("Problem 1.\n");
  int c1, c2, c3, c4;
  c1 = strcmp373("bin", "bag"); // returns 8 
  c2 = strcmp373("computer", "game"); // returns -4 
  c3 = strcmp373("computer", "computer"); // returns 0 
  // returns -97 the difference between '\0' and 'a
  c4 = strcmp373("are", "area"); 
  printf("%d %d %d %d\n", c1, c2, c3, c4);

  // 2.  strcat373
  printf("Problem 2.\n");
  char stra[10] = "comp";
  char strb[ ] = "uter";
  char strc[10] = "comp";
  printf("stra contains %s\n", stra);
  printf("strb contains %s\n", strb);
  printf("strc contains %s\n", strc);
  printf("concatenate %s and %s\n", stra, strb);
  strcat373(stra, strb);
  printf("stra contains %s\n", stra);
  printf("strb contains %s\n", strb);
  printf("concetenate %s and %s\n", strb, strc);
  printf("str2 contains %s\n", strcat373(strb, strc));

  // 3.  strchr373
  printf("Problem 3.\n");
  char words[] = "off-campus and on-campus housing";
  char *c= strchr373(words, '-');
  printf("Looking for '-' in %s\nFound at location %s\n", words, c);
  char *d;
  d = strchr373(&words[5], '-');
  printf("Looking for '-' in %s\nFound at location %s\n", c+1, d);

  // 4.  strncpy373
  printf("Problem 4\n");
  char s1[] = "comp";
  char s2[] = "systems";
  printf("Using strncpy into %s from %s,\n", s1, s2);
  printf("but only allowing 4 characters\n");
  strncpy373(s1, s2, 4);
  printf("Result is s1 %s and s2 %s\n", s1, s2);

  // 5.  strncat373
  printf("Problem 5\n");
  char strn1[100] = "comp";     // this is where all the concatenation is
  char strn2[] = "uter ";       // going on so I made it bigger
  char strn3[] = "science";
  strncat(strn1, strn2, 5);
  strncat(strn1, strn3, 7);
  char strn4[15] = "comp";     // a smaller array.  The entire concatenation
  strncat(strn4, strn2, 5);    // can't fit
  strncat(strn4, strn3, 5);
  printf("strn4 is %s\n", strn4);
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
