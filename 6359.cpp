#include <iostream>
#include <stdlib.h>
using namespace std;

int main(){
	int T; //케이스 수
	cin >> T;
	
	/*각 케이스 별 죄수의 수 */
	int* n = (int*)malloc(T*sizeof(int));
	for(int i = 0; i<T; i++){
		cin >> n[i];
	}
	/*100까지의 수들의 약수 갯수를 구한다.*/
	int* cnt = (int*)malloc(101*sizeof(int));
	for(int i =1; i<=100; i++){
		for(int j =1; j<=i; j++){
			if(i%j==0) cnt[i]++;
		}
	}
	
	/*주어진 죄수의 수의 약수가 홀수인 경우 탈출한다.*/
	for(int i =0 ; i<T; i++){
		int prisoner = n[i];
		int cnt_free =0;
		for(int j =1;j <=prisoner; j++){
			if(cnt[j]%2 !=0) cnt_free++;
		}
		cout<< cnt_free <<endl;
	}
}
