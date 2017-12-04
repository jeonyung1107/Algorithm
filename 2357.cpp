#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define INF 1234567890

class node{
	public:
		int min;
		int max;

		node(int _min, int _max){
			min = _min;
			max = _max;
		}
};

vector<node> tree;
vector<int> origin;

void buildTree(int now,int start,int end){

	if(start==end){
		tree[now]=node(origin[start],origin[start]);
	}else{
		int mid = (start + end) /2;

		buildTree(now*2,start,mid);
		buildTree(now*2+1,mid+1,end);
		tree[now]=node(min(tree[now*2].min,tree[now*2+1].min),max(tree[now*2].max,tree[now*2+1].max));
	}
}

node find(int now,int start,int end,int left, int right){

	if(left>end || right<start){
		return node(INF,-1);
	}

	if(left<=start && end <=right){
		return tree[now];
	}

	int mid =  (start+end)/2;
	node tmp1 = find(now*2,start,mid,left,right);
	node tmp2 = find(now*2+1,mid+1,end,left,right);

	node result = node(min(tmp1.min,tmp2.min),max(tmp1.max,tmp2.max));

	return result;
}

int main(void){
	int n,m;
	cin >>n>>m;
	tree.assign(4*n,node(0,0));

	for (int i=0;i<n;++i){
		int tmp;
		cin >>tmp;
		origin.push_back(tmp);
	}
	buildTree(1,0,origin.size()-1);	

	int s,e;
	for(int i=0; i<m;++i){
		cin  >>s >>e;
		node result=find(1,1,origin.size(),s,e);
		cout <<result.min << result.max<<endl;
	}
}
