#include <cstdio>
#include <stdlib.h>
#include <iostream>
using namespace std;

int main(){
	int T;
	//scanf("%d",&T);
	cin >> T;
	int* N=(int*)malloc(T*sizeof(int));
	int** a = (int**)malloc(T*sizeof(int*));
	for(int i = 0; i<T; i++){
		a[i] = (int*)malloc(1000000*sizeof(int));
	}
	int* K = (int*)malloc(T*sizeof(int));

	for (int i = 0; i < T; ++i)
	{
		/* code */
		printf("N");
		scanf("%d",&N[i]);
		for (int j= 0; j< N[i]; ++j)
		{
			/* code */
			printf("a");
			scanf("%d",&a[i][j]);
		}
		scanf("%d",&K[T]);
	}
}
