#include <iostream>
#include <queue>
#include <vector>

using namespace std;
#define MAX 1001
#define BFS 0
#define DFS 1

int graph[MAX][MAX];
int is_checked[MAX];

queue<int> q;
vector<int> v;

void insert(int now,int what){
	if(what==BFS){
		for(int i=1; i<MAX; i++){
			if(graph[now][i] ==1&&is_checked[i]!=1){
				q.push(i);
			}
		}
	}else if(what==DFS){
		for(int i=MAX-1;i>0;i--){
			if(graph[now][i]==1&&is_checked[i]!=1){
				v.push_back(i);
			}
		}
	}
}	
/*노드 방문을 구현한 함수
 * 더이상 방문할 노드가 없는 경우 0 반환한다.
 * 다형성을 이용할 수 있으면 좋겠다.*/
int pop(int what){
	int now=0;
	if(what==BFS&&!q.empty()){
		now = q.front();
		q.pop();
	}else if(what==DFS&&!v.empty()){
		now = v.back();
		v.pop_back();
	}
	return now;
}
/*실제 탐색 수행하는 함수*/
void search(int start,int what){
	int now=0;
	if(what==BFS){
		q.push(start);
	}else if(what==DFS){
		v.push_back(start);
	}
	/*now에 0들어오면 멈춤*/
	while(now = pop(what)){
		if(is_checked[now]==1) continue;
		is_checked[now]=1;
		insert(now,what);
		cout << now << " ";
	}
	cout << endl;
	for(int i=1;i<MAX;i++){
		is_checked[i]=0;
	}
}

int main(){
	int n,m,v;
	cin >> n >> m >> v;
	
	for(int i=0;i<m;i++){
		int s,e;
		cin >> s >> e;

		graph[s][e] = 1;
		graph[e][s] = 1;
	}
	search(v,DFS);
	search(v,BFS);

	return 0;
}
