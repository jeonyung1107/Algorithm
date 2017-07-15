#include <algorithm>
#include <iostream>
using namespace std;

void swap(int* arr){
	int t = arr[2];
	arr[2] = arr[1];
	arr[1] = arr[0];
	arr[0] = t;
}

int main(){
	int n;
	cin >> n;
	int size = n/2 + n%2;

	int A[n];
	int B[n];
	for (int i = 0; i < n; ++i)
	{
		/* code */
		cin >> A[i];
	}
	for (int i = 0; i < n; ++i)
	{
		/* code */
		cin >> B[i];
	}

	int B_part[3] = {B[n-3],B[n-2],B[n-1]};
	int A_part[3];

	int j = 0;
	for (int i = 0; i < n; ++i)
	{
		/* code */
		if(A[i] == B_part[0]||A[i] == B_part[1] || A[i] == B_part[2]) {
			A_part[j] = A[i];
			j++;
		}
	}
	while(A_part[1] != B_part[1]) swap(A_part);

	if(A_part[0] != B_part[0]){
		cout << "Impossible";
	}else{
		cout << "Possible";
	}
}