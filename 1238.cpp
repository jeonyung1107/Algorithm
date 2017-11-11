#include <queue>
#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

#define INF 987654321

using namespace std;

class cmp{
	public:
		bool operator()(pair<int,int> a, pair<int,int> b){
			return a.second>b.second;	
		}
};

vector<vector<pair<int,int> > > graph;
vector<vector<int> > dist;
vector<int> two_way;
priority_queue<pair<int, int>,vector<pair<int,int> >,cmp > q;

int dijkstra(int start){
	q.push(make_pair(start,0));
	int now=0;
	int now_dist=0;
	int v=0;
	int v_dist=0;

	while(!q.empty()){
		now=q.top().first;
		now_dist = q.top().second;
		q.pop();

		if(dist[start][now]>now_dist){
			dist[start][now]=now_dist;
		}else continue;

		for(int i=0; i<graph[now].size();++i){
			v=graph[now][i].first;
			v_dist=graph[now][i].second;
			if(dist[start][now]+v_dist<dist[start][v]){
				q.push(make_pair(v,dist[start][now]+v_dist));
			}
		}
	}

	return 1;
}

int main(){
	int n,m,x;
	cin >> n >> m >> x;

	/*resize to n+1*/
	graph.resize(n+1);
	dist.assign(n+1,vector<int>());
	two_way.resize(n+1);	

	for(int i=0;i<n+1;++i){
		dist[i].assign(n+1,INF);
	}

	for(int i=0; i<m;++i){
		int s,e,cost;
		cin >> s >> e >> cost;
		graph[s].push_back(make_pair(e,cost));
	}

	for(int i=1;i<n+1;++i){
		dijkstra(i);
	}
	
	two_way[0]=0;
	for(int i=1;i<n+1;++i){
		two_way[i] = dist[i][x]+dist[x][i];
	}

	vector<int>::iterator itr;
	itr =max_element(two_way.begin(),two_way.end());
	cout << *itr << endl;
}
