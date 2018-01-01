/* 
 * problem: https://www.acmicpc.net/problem/10272
 * algorithm: dynamic programming
 * 
 * not fully understood
 *
 * */

#include <cstdio>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

#define MAX 555

int t,n;
double dp[MAX][MAX];
pair<double,double> dist[MAX];

double getDist(pair<double, double> x, pair<double, double> y){
	return sqrt(
			(x.first-y.first)*(x.first-y.first) + 
			(x.second-y.second)*(x.second-y.second)
			);
}

double dynamic(int x, int y){
	if(x ==n-1||y==n-1){
		if(y != n-1){ return getDist(dist[y], dist[n-1]); }
		if(x != n-1){ return getDist(dist[x], dist[n-1]); }
		return 0.0;
	}

	if( dp[x][y] != -1.0) return dp[x][y];
	int nxt = max(x,y) +1;
	double ret_tmp1 = getDist(dist[x],dist[nxt]) + dynamic(nxt,y);
	double ret_tmp2 = getDist(dist[y],dist[nxt]) + dynamic(x,nxt);
	double ret = min(ret_tmp1,ret_tmp2);
	
	dp[x][y] = ret;

	return ret;
}

int main(){
	scanf("%d",&t);
	for(int i=0; i<t; ++i){
		for (int j=0; j<MAX; ++j){
			for (int k=0; k<MAX; ++k){
				dp[j][k] = -1.0;
			}
		}
		scanf("%d",&n);
		for(int j=0; j<n; ++j){
			scanf("%lf%lf",&dist[j].first, &dist[j].second);
		}
		printf("%.3lf\n",dynamic(0,0));
	}
	return 0;
}
