#include <queue>
#include <iostream>
#include <utility>
#include <vector>

#define V 20001
#define E 300000
#define INF 987654321

using namespace std;

class cmp{
	public:
		bool operator()(pair<int,int> a, pair<int,int> b){
			return a.second>b.second;
		}
};

vector<vector<pair<int, int> > > graph;
priority_queue<pair<int,int>, vector<pair<int,int> >,cmp> q;
vector<int> dist;

int dijkstra(int start){
	
	q.push(make_pair(start,0));
	int now=0;
	int now_dist=0;
	int v=0;
	int v_dist=0;
	
	while(!q.empty()){
		now=q.top().first;
		now_dist=q.top().second;
		q.pop();
		
		if(dist[now]>now_dist){
			dist[now]=now_dist;
		}else{
			continue;
		}

		for(int i=0;i<graph[now].size();++i){
			v=graph[now][i].first;
			v_dist=graph[now][i].second;
			if(dist[now]+v_dist<dist[v]){
				q.push(make_pair(v, dist[now]+v_dist));
			}
		}
	}

	return 1;
}

int main(){
	int v,e,k;
	int u,d,w;
	
	cin >> v >> e >> k;
	graph.resize(v+1);
	dist.assign(v+1,INF);

	for(int i=0; i<e;i++){
		cin >> u >> d >>w;
		graph[u].push_back(make_pair(d,w));
	}
	dijkstra(k);
	
	for(int i=1; i<=v;++i){
		if(dist[i]==INF){
			cout << "INF"<<endl;
			continue;
		}
		cout << dist[i] <<endl;
	}
}
