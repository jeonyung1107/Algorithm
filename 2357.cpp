/*
 * author: CoffDopeaa
 * 
 * */
#include <iostream>
#include <algorithm>

using namespace std;

#define INF 1234567890

int n,m;
pair<int,int> tree[300000];
int origin[100000];

int read_int()
{
	int ret = 0;
	char ch;
	while((ch = getchar()) >= '0' && ch <= '9') {
		ret = ret*10 + ch - '0';
	}
	return ret;
}

void buildTree(int now,int start,int end){

	if(start==end){
		tree[now]=make_pair(origin[start],origin[start]);
	}else{
		int mid = (start + end) /2;

		buildTree(now*2,start,mid);
		buildTree(now*2+1,mid+1,end);
		tree[now]=make_pair(
				min(tree[now*2].first,tree[now*2+1].first),
				max(tree[now*2].second,tree[now*2+1].second)
				);
	}
}

pair<int,int> find(int now,int start,int end,int left, int right){

	if(left>end || right<start){
		return make_pair(INF,-1);
	}

	if(left<=start && end <=right){
		return tree[now];
	}

	int mid =  (start+end)/2;
	pair<int,int> tmp1 = find(now*2,start,mid,left,right);
	pair<int,int> tmp2 = find(now*2+1,mid+1,end,left,right);

	return make_pair(
			min(tmp1.first,tmp2.first),
			max(tmp1.second,tmp2.second)
			);
}

int main(void){
	n = read_int();
	m = read_int();

	for (int i=0;i<n;++i){
		origin[i]=read_int();
	}

	buildTree(1,0,n-1);	

	int s,e;
	for(int i=0; i<m;++i){
		s = read_int();
		e = read_int();
		--s,--e;
		pair<int,int> result=find(1,0,n-1,s,e);
		printf("%d %d\n",result.first,result.second);
	}
}
