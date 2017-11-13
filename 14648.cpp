#include <iostream>
#include <stdlib.h>

using namespace std;
long long query_one(int* arr,int a, int b){
	long long sum=0;
	for(int i = a-1; i<b;i++){
		sum += arr[i];	
	}
	int tmp = arr[a-1];
	arr[a-1] = arr[b-1];
	arr[b-1] = tmp;

	return sum;
}

long long query_two(int*arr, int a, int b, int c, int d){
	long long sum[2] = {0,0};
	for(int i = a-1; i<b; i++){
		sum[0] +=arr[i];
	}
	for(int i = c-1; i<d; i++){
		sum[1] +=arr[i];
	}

	return sum[0]-sum[1];
}

int main(){
	int n,q;
	cin >> n >> q;
	int* arr = (int*)malloc(n*sizeof(int));
	for(int i =0; i<n; i++){
		cin >> arr[i];
	}
	int a,b,c,d;
	for(int i =0; i<q; i++){
		int which_query;
		cin >> which_query;
		if(which_query ==1){
			cin >>a>>b;
			cout << query_one(arr,a,b)<<endl;
		}else{
			cin >>a>>b>>c>>d;
			cout<<query_two(arr,a,b,c,d)<<endl;
		}
	}
}
