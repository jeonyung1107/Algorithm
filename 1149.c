#include<stdio.h>
#include<stdlib.h>

int min(int a, int b){
	if(a>b) return b;
	else return a;
}
int cal_former(int** former,int** cost,int size ){
	for(int i = 0; i<size; i++){
		if(i == 0){
			former[i][0] = cost[i][0];
			former[i][1] = cost[i][1];
			former[i][2] = cost[i][2];
		}
		else{
			former[i][0] = min(former[i-1][1],former[i-1][2]) +cost[i][0];	
			former[i][1] = min(former[i-1][0],former[i-1][2]) +cost[i][1];	
			former[i][2] = min(former[i-1][1],former[i-1][0]) +cost[i][2];	
		}
	}	
}

int main(){
	int size;
	scanf("%d",&size);

	/*결과값 저장할 매트릭스*/
	int** former = (int**)malloc(size*sizeof(int*));
	for(int i = 0; i<size; i++){
		former[i] = (int*)malloc(3*sizeof(int));
	}
	/*비용 저장할 매트릭스*/
	int** cost = (int**)malloc(size*sizeof(int*));
	for(int i = 0; i<size; i++){
		for(int j = 0; j<3; j++){
			cost[i] = (int*)malloc(3*sizeof(int));	
		}
	}
	/*비용 입력*/
	for(int i = 0; i<size; i++){
		scanf("%d %d %d",&cost[i][0],&cost[i][1],&cost[i][2]);
	}
	cal_former(former,cost,size);
	int min_cost = min(former[size-1][0],min(former[size-1][1],former[size-1][2]));
	printf("%d",min_cost);
}
