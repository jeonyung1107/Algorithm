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
	for(int i=1; i<MAX; i++){
		if(graph[now][i] ==1&&is_checked[i]!=1){
			if(what==BFS){
				q.push(i);
			}
			else if(what==DFS){
				v.push_back(i);
			}
		}
		is_checked[i] ==1;
	}
}	

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
void search(int start,int what){
	int now=0;
	if(what==BFS){
		q.push(start);
	}else if(what==DFS){
		v.push_back(start);
	}
	is_checked[start]=1;
	/*now에 0들어오면 멈춤*/
	while(now = pop(what)){
		insert(now,what);
		cout << now << " ";
	}
	cout << endl;
	for(int i=1;i<MAX;i++){
		is_checked[i]==0;
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
	search(v,BFS);
	search(v,DFS);

	return 0;
}
