#include <iostream>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

class cmp{
	public:
		bool operator()(pair<int,int> a, pair<int,int> b){
			return a.second>b.second;	
		}
};

vector<vector<pair<int,int> > > graph;
priority_queue<pair<int, int>,vector<pair<int,int> >,cmp > q;
vector<int> visit;

int insert(int now){
	for(int i=0; i<graph[now].size();++i){
		if(visit[graph[now][i].first]==0){
			if(visit[graph[now][i].first]==0){
				q.push(graph[now][i]);	
			}
		}
	}

	return 0;
}

int main(){
	int result=0;
	int v,e;
	cin >> v >> e;
	
	graph.resize(v+1);
	visit.assign(v+1,0);

	int a,b,c;
	for(int i=0;i<e;++i){
		cin >> a >> b >> c;
		graph[a].push_back(make_pair(b,c));
		graph[b].push_back(make_pair(a,c));
	}
	
	int now;
	int now_cost;

	q.push(make_pair(1,0));
	while(!q.empty()){
		now=q.top().first;
		now_cost=q.top().second;
		q.pop();

		if(visit[now]==0){
			result+=now_cost;
			insert(now);
			visit[now]=1;
		}
	}
	cout <<result<<endl;
}
