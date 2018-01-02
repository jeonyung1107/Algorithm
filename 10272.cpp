#include <algorithm>
#include <cmath>
#include <cstdio>

#define MAX 512

using namespace std;

int t,n;
pair<double,double> pts[MAX];
double dp [MAX][MAX];


double getDist(pair<double, double> pt1, pair<double, double> pt2){
	return sqrt(
			(pt1.first-pt2.first)*(pt1.first-pt2.first)+
			(pt1.second-pt2.second)*(pt1.second-pt2.second)
			);
}

double minDist(int pt1, int pt2){
	if(pt1 == n-1){return getDist(pts[pt2],pts[n-1]);}
	else if(pt2 == n-1){return getDist(pts[pt1],pts[n-1]);}

	int nxt = max(pt1,pt2) +1;

	if(dp[pt1][pt2]) return dp[pt1][pt2];

	double ret = min(
			getDist(pts[pt1],pts[nxt]) + minDist(nxt,pt2),
			getDist(pts[pt2],pts[nxt]) + minDist(pt1,nxt)
			);

	dp[pt1][pt2] = ret;

	return ret;
}
int main(void){
	scanf("%d",&t);
	for(int i=0;i<t;++i){
		for(int j=0;j<MAX;++j){
			for (int k=0;k<MAX;++k){
				dp[j][k]=0; 
			}
		}
		scanf("%d",&n);
		for(int j=0;j<n;++j){scanf("%lf%lf",&pts[j].first,&pts[j].second);}
		printf("%.3lf\n",minDist(0,0));
	}


}

