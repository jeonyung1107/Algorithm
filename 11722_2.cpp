#include <cstdio>
#include <vector>
#define MAX 1001

using namespace std;

vector<int> dp;
int arr[MAX];
int n;

void init(){
	scanf("%d",&n);
	for(int i=1; i<=n; ++i){
		scanf("%d",&arr[i]);
	}
}

void lower_bound(int value){
	if(value < dp.back()) {
		dp.push_back(value);
	}else{
		int s = 0;
		int e = (int)dp.size() - 1;

		while(e>=s){
			int mid = (e+s)/2;
			if(dp[mid] == value) return;
			if(e == s){
				if(value > dp[mid]) dp[mid] = value;
				else dp[mid + 1] = value;
				return;
			}
			else if(dp[mid] > value){
				s = mid + 1;
			}else if(dp[mid] < value){
				e = mid - 1;
			}
		}
	}
}

void solve(){
	dp.push_back(arr[1]);
	for(int i=2; i<=n; ++i){
		lower_bound(arr[i]);
	}
}

int main(){

	init();
	solve();
	printf("%d",(int)dp.size());
}
