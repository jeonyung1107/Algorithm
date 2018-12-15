#include <cstdio>
#include <vector>

#define MAX 16

using namespace std;

int t[MAX];
int p[MAX];
int dp[MAX];
int n;

int max(int a, int b){
	return a >= b ? a : b;
}

void solve(){
	for(int i=2; i<=n; ++i){
		for(int j=1; j<i; ++j){
			if(i - j >= t[j]){
				dp[i] = max(p[i] + dp[j], dp[i]);
			}
		}
	}
}

void init(){
	scanf("%d",&n);

	for(int i=1; i<=n; ++i){
		scanf("%d %d",&t[i],&p[i]);	
		dp[i] = p[i];
	}
}

int main(){
	init();
	solve();
	
	int maxno = 0;
	for(int i=1; i<=n; ++i){
		if(i + t[i] <= n+1){
			if(maxno < dp[i]){
				maxno = dp[i];
			}
		}
	}

	printf("%d",maxno);
}

