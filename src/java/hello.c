#include <stdio.h>
int main(){
    int x;
    printf("Enter an Integer Number:\n");
	scanf("%d", &x);
    if(x % 2 == 0) printf("even\n");
    else printf("odd\n");
	//printf("Hello i am running!");
    return 0;
}