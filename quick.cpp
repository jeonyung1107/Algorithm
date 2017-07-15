#include <cstdio>
#define MAX 1000

void swap(int* a, int* b);
void quickSort(int left, int right, int* data);

void swap(int* a, int* b){
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

void quickSort(int left, int right, int* data){
	int pivot = left;
	int j = pivot;
	int i = pivot + 1;

	if (left < right){
		for(; i<=right; i++){
			if(data[i]<data[pivot]){
				j++;
				swap(&data[i],&data[j]);
			}
		}
		swap(&data[j],&data[pivot]);
		pivot = j;
		quickSort(left,pivot-1,data);
		quickSort(pivot+1,right,data);
	}
}


int main(){
	int arr[] = {4,5,1,7,9,3,1,10};
	quickSort(0,7,arr);
	for(int i =0; i<sizeof(arr)/sizeof(int); i++){
		printf("%d\n",arr[i]);
	}
	return 0;
}