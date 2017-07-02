#include <stdio.h>
#include <iostream>
#include <algorithm>

using namespace std;
int cnt;
int main(){
	int n;
	scanf("%d",&n);

	int** island = (int**)calloc(n,sizeof(int*));
	for(int i =0 ; i<n; i++){
		island[i] = (int*)calloc(n,sizeof(int));
	}
	int** check_is = (int**)calloc(n,sizeof(int*));
	for(int i= 0; i<n; i++){
		check_is[i] = (int*)calloc(n,sizeof(int));
	}

	
	return 1;
}
