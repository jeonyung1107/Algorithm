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
	int one=0;
	int ten=0;
	int baek=0;
	int cheon=0;
	for(int i = 0; i< n; i++){
		for(int j = 0; j< m; j++){
			cin >> bingopan[i][j];
			one = bingopan[i][j]%10;
			ten = bingopan[i][j]%100 - one;
			baek = bingopan[i][j]%1000 - ten -one;
			cheon = bingopan[i][j]-baek-ten-one;

			int cnt_temp = 0;
			if(one!=0&&one%9==0) cnt_temp++;
			if(ten!=0&&ten%90==0) cnt_temp++;
			if(baek!=0&&baek%900==0) cnt_temp++;
			if(cheon!=0&&cheon%9000==0) cnt_temp++;

			row_cnt[i]+=cnt_temp;
			col_cnt[j]+=cnt_temp;
			cnt+=cnt_temp;
		}
	}
	/*행, 렬 중 가장 9를 많이 가지고 있는 값을 구한 뒤에 전체에서 뺀다*/
	cnt-=whats_max(row_cnt,col_cnt,n,m);
	
	cout <<cnt;
}
