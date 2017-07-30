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
	int n;	// ���� �� n
	int m; // ���� �� m
	cin >> n >> m;
	int** bingopan = (int**)malloc(n*sizeof(int*)); //n*m ũ�� ������
	for(int i = 0 ; i<n; i++){
		bingopan[i] = (int*)malloc(m*sizeof(int)); //�� �࿡ mũ���� �迭 �Ҵ�
	}
	/*��ü 9�� ������ �� ��, ���� 9�� ����*/
	int cnt = 0;
	int* row_cnt = (int*)malloc(n*sizeof(int));
	int* col_cnt = (int*)malloc(m*sizeof(int));
	
	/*�������� �� ���� �Է� ���� �� ��� ��ġ�� �����ϴ��Ŀ� 
	 * ���� �ٷιٷ� ��� ���� 9�� ���� ���������ش�.*/
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
	/*��, �� �� ���� 9�� ���� ������ �ִ� ���� ���� �ڿ� ��ü���� ����*/
	cnt-=whats_max(row_cnt,col_cnt,n,m);
	
	cout <<cnt;
}
