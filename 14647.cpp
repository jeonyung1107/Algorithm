#include <iostream>
#include <stdlib.h>

using namespace std;

int whats_max(int* row, int* col,int n, int m){
	int max = 0;
	
	for(int i = 0; i<n; i++){
		if(row[i]>max) max = row[i]; 
	}
	for(int i = 0; i<m; i++){
		if(col[i]>max) max = col[i];
	}
	return max;
}

int main(){
	int n;	// 행의 수 n
	int m; // 열의 수 m
	cin >> n >> m;
	int** bingopan = (int**)malloc(n*sizeof(int*)); //n*m 크기 빙고판
	for(int i = 0 ; i<n; i++){
		bingopan[i] = (int*)malloc(m*sizeof(int)); //각 행에 m크기의 배열 할당
	}
	/*전체 9의 갯수와 각 행, 렬의 9의 갯수*/
	int cnt = 0;
	int* row_cnt = (int*)malloc(n*sizeof(int));
	int* col_cnt = (int*)malloc(m*sizeof(int));
	
	/*빙고판의 각 수를 입력 받을 때 어느 위치에 저장하느냐에 
	 * 따라 바로바로 행과 열의 9의 수를 증가시켜준다.*/
	for(int i = 0; i< n; i++){
		for(int j = 0; j< m; j++){
			cin >> bingopan[i][j];
			int tmp = bingopan[i][j];
			int cnt_temp = 0;

			while(tmp>0){
				if(tmp%10 = 9) cnt_temp++;
			}
			row_cnt[i]+=cnt_temp;
			col_cnt[j]+=cnt_temp;
			cnt+=cnt_temp;
		}
	}
	/*행, 렬 중 가장 9를 많이 가지고 있는 값을 구한 뒤에 전체에서 뺀다*/
	cnt-=whats_max(row_cnt,col_cnt,n,m);
	
	cout <<cnt;
}
