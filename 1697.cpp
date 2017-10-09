#include <iostream>
#include <queue>
#define MAX 100001
using namespace std;

int where[MAX];
int is_checked[MAX];
int cost[MAX];

queue<int> q;


int insert(int now){
	int tmp[3]={now-1,now+1,now*2};
	for(int i=0;i<3;i++){
		if(is_checked[tmp[i]]!=1&&tmp[i]>=0&&tmp[i]<=100000){
			q.push(tmp[i]);
			cost[tmp[i]]=cost[now]+1;
			is_checked[tmp[i]]=1;
		}
	}
}

int BFS(int n,int k){
	q.push(n);

	while(!q.empty()){
		int now=q.front();
		q.pop();
		if(now==k){return cost[now];}
		insert(now);
	}
	return 1;
}
int main(){
	int n,k;
	cin >>n >>k;
	int result=BFS(n,k);
	cout << result <<endl;
}
