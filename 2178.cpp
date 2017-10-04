#include <iostream>
#include <vector>
#include <queue>
#include <cstdio>

using namespace std;

class node{
	public:
		int road;
		int num_step;
		int i,j;
		bool is_checked;

	node(){
		road=0;
		num_step=1;
		i=0;
		j=0;
		is_checked=false;
	}
};


int BFS(vector<vector<node> > maze,int n, int m,queue<node> in){
	int i=0,j =0;
	
	in.push(maze[0][0]);
	in.front().is_checked = true;

	int x[] = {0,0,-1,1};
	int y[] = {-1,1,0,0};

	while(1){	
		node now = in.front();
		in.pop();
		i = now.i;
		j = now.j;
		
		/*종료 조건*/
		if(now.i ==n-1&& now.j ==m-1){return now.num_step;}

		/*현재 위치 주변의 후보 탐색*/
		for(int k=0; k<4; k++){
			int ni = i+x[k];
			int nj = j+y[k];
			if(ni>=0&&ni<n&&nj>=0&&nj<m){
				if(maze[ni][nj].is_checked !=true&&maze[ni][nj].road==1){
					maze[ni][nj].is_checked = true;
					maze[ni][nj].num_step = now.num_step +1;
					in.push(maze[ni][nj]);
				}
			}
		}
	}
}

int main(){
	int n, m;
	cin >> n >>m;
	vector<vector<node> > maze(n,vector<node>(m,node()));

	queue<node> in_queue;
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%1d",&maze[i][j].road);
			maze[i][j].i=i;
			maze[i][j].j=j;
		}
	}

	int result = BFS(maze,n,m,in_queue);
	cout << result <<endl;
	return 1;
}
