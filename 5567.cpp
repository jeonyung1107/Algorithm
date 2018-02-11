#include <queue>
#include <cstdio>

using namespace std;

int matrix[501][501];
int list[501];
int n,m;

void check(){
	queue<int> q;

	for(int i=2;i<=500;++i){
		if(matrix[1][i]==1){
			list[i]=1;
			q.push(i);		
		}
	}

	while(!q.empty()){
		int now=q.front();
		q.pop();

		for(int i=2;i<=500;++i){
			if(matrix[now][i]==1){list[i]=1;}
		}
	}
}

int main(void){

	scanf("%6d %6d",&n,&m);
	for(int i=0;i<m;++i){
		int s,e;
		scanf("%6d %6d",&s,&e);
		matrix[s][e]=1;
		matrix[e][s]=1;
	}
	check();

	int res=0;
	for(int i=2;i<=500;++i){
		if(list[i]==1){ res++; }
	}
	printf("%d",res);
}
