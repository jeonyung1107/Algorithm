#include <stdlib.h>
#include <stdio.h>
#define MAX 41
int main(){
	int n;
	scanf("%d",&n);
	int* a = (int*)malloc(sizeof(int)*n);
	for(int i =0; i<n; i++){
		scanf("%d",&a[i]);
	}
	int dp[MAX][2];

	dp[0][0] = 1;
	dp[0][1] = 0;
	dp[1][0] = 0;
	dp[1][1] = 1;
	for(int i= 2; i<MAX; i++){
		dp[i][0] = dp[i-2][0] + dp[i-1][0];
		dp[i][1] = dp[i-2][1] + dp[i-1][1];
	}

	for(int i = 0; i<n; i++){
		printf("%d %d\n",dp[a[i]][0],dp[a[i]][1]);
	}
}
