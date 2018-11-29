int main(){
	
	char str1[9] = "comp";
	char str2[ ] = "uter";
	char str3[10] = "comp";
	printf("str1 contains %s\n", str1);
	printf("str2 contains %s\n", str2);
	printf("str3 contains %s\n", str3);
	printf("concatenate %s and %s\n", str1,str2);
	strcat373(str1, str2);
	printf("str1 contains %s\n", str1);
	printf("str2 contains %s\n", str2);
	printf("concetenate %s and %s\n", str2,str3);
	printf("str2 contains %s\n", strcat373(str2,str3));

	
	
	
	
	
	
}