/*알고리즘: 플로이드-와샬
 *풀이: 플로이드-와샬을 적용한 것으로 가정하고 중간지점k를 거치는 거리와 그렇지 않은 거리가 같은 경우 경로 ij를 제거한다. 이후 남은 경로들의 거리 합을 구한다.
 */

#include <cstdio>

#define INF 123456789
#define NIL 0
#define MAX 20

using namespace std;

int D[MAX][MAX];
int P[MAX][MAX];

int main(void){
	int n=0;
	int res=0;

	scanf("%10d",&n);
	
	/*initialize*/
	for(int i=0;i<n;++i){
		for(int j=0;j<n;++j){
			scanf("%10d",&D[i][j]);
			P[i][j]=NIL;
		}
	}

	for(int k=0;k<n;++k){
		for(int i=0;i<n;++i){
			for(int j=0;j<n;++j){
				if(i!=j&&i!=k&&j!=k&&D[i][j]==D[i][k]+D[k][j]){
					P[i][j]=1;
				}else if(D[i][j]>D[i][k]+D[k][j]){
					printf("%d",-1);
					return 1;
				}
			}
		}
	}


	for(int i=0;i<n;++i){
		for(int j=i;j<n;++j){
			if(P[i][j]!=1){
				res+=D[i][j];
			}
		}
	}
	printf("%d",res);
	
	return 0;
}
