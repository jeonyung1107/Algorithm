#include <cstdio>
#define MAX 1001

int dp[MAX];
int arr[MAX];
int n;

void init(){
	scanf("%d",&n);
	for(int i=1; i<=n; ++i){
		scanf("%d ", &arr[i]);
	}
}

void solve(){
	for(int i=1; i<=n; ++i){
		for(int j=1; j<i; ++j){
			if(arr[i] < arr[j] && dp[j]+1 > dp[i]){
				dp[i] = dp[j] + 1;
			}
		}
	}
}

int main(){
	init();
	solve();
	int max = 0;
	for(int i=1; i<=n; ++i){
		if(max < dp[i])max = dp[i];
	}
	printf("%d", max + 1);
}

