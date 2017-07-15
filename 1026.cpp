#include <iostream>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;

	vector<int> A;
	vector<int> B;
	int t;
	for(int i = 0; i<n; i++){
		cin >> t;
		A.push_back(t);
	}
	for (int i = 0; i < n; ++i)
	{
		cin >> t;
		B.push_back(t);
	}

	sort(A.begin(), A.end());
	sort(B.begin(), B.end(), greater<int>());

	int S = 0;
	for (int i = 0; i < n; ++i)
	{
		/* code */
		S += A[i] *B[i];
	}
	cout <<S;
}