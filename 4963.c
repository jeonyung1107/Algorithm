#include<stdio.h>
#include<stdlib.h>

typedef struct node{
	int is_islnd;
	int check;
}node;

int count_islnd(node** island,int hgt,int wdth,int x, int y){
	if(island[x][y].check == 0&&island[x][y].is_islnd==1){
		island[x][y].check = 1;
		for(int i = y-1; i<=y+1; i++){
			for(int j = x -1; j<=x+1; j++){
				if(i>=0&&i<wdth&&j>=0&&j<hgt) count_islnd(island,hgt,wdth,j,i);
			}
		}		
	}
	return 0;
}

int main(){
	int width;
	int height;
	int cnt=0;
	int c[1000];
	int cc=0;
	do{
		cnt = 0;
		scanf("%d %d",&width,&height);
		if(width ==0&& height ==0) break;
		node** island = (node**)malloc(height*sizeof(node*));
		for(int i= 0; i<height; i++){
			island[i] = (node*)malloc(width*sizeof(node));
		}
		/*섬 정보 입력*/	
		for(int i = 0; i<height;i++){
			for(int j = 0; j<width;j++) scanf("%d",&(island[i][j].is_islnd));
		}

		/*각 셀에 대해서 함수 실행*/
		for(int i = 0; i<height;i++){
			for(int j = 0; j<width;j++){ 
				if(island[i][j].check ==0&&island[i][j].is_islnd ==1){ 
					cnt++;
					count_islnd(island,height,width,i,j);
				}
			}
		}
		c[cc] = cnt;
		cc++;
	}while(width!=0&&height!=0);
	for(int i = 0; i<cc;i++){
		printf("%d\n",c[i]);
	}

	return 1;
}
