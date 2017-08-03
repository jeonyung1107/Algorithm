#include <iostream>
#include <stdlib.h>
using namespace std;
int main(){
	int* bridge = (int*)malloc(101*sizeof(int)); //index 1~100까지 사용한다.
	int* cnt = (int*)malloc(3*sizeof(int));
	int wealth;
	int cnt_secretary;
	cin >> wealth >>cnt_secretary;
	/*각 비서의 시작지점과 방향을 받아 징검다리에 값을 더해준다*/
	for (int i = 0; i < cnt_secretary; ++i){
		int start;
		int l=1, r=100;
		char direction;
		cin >> start >> direction;
		if(direction =='R'){
			for(int j =start+1; j<=100; j++) bridge[j]=(bridge[j]+1)%3;
		}else if(direction == 'L'){
			for(int j= start-1; j>=1; j--) bridge[j]=(bridge[j]+1)%3;
		}
	}

	/*각 색별로 수 확인*/
	for(int i =1; i<=100; i++) cnt[bridge[i]]++;
	for(int i=0; i<3; i++) printf("%.2lf\n", wealth * 0.01 * cnt[i]);
	
	return 0;
}
