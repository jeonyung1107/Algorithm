#include <algorithm>
#include <iostream>
using namespace std;

//빵 뒤집기
void swap(int* arr){
	int t = arr[2];
	arr[2] = arr[1];
	arr[1] = arr[0];
	arr[0] = t;
}


int main(){
	int n;
	cin >> n;

	int A[n];
	int B[n];
	for (int i = 0; i < n; ++i)
	{
		cin >> A[i];
	}
	for (int i = 0; i < n; ++i)
	{
		cin >> B[i];
	}

}
