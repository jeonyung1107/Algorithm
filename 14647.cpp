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
	/*��, �� �� ���� 9�� ���� ������ �ִ� ���� ���� �ڿ� ��ü���� ����*/
	cnt-=whats_max(row_cnt,col_cnt,n,m);
	
	cout <<cnt;
}
