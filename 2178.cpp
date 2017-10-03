#include <iostream>
#include <vector>

using namespace std;

int main(){
	int n, m;
	cin >> n >>m;
	vector<vector<int>> maze(n,vector<int>(m));

	for(int i; i<n; i++){
		for(int j; j<m; j++){
			cin >> maze[i][j];
		}
	}
	

}
