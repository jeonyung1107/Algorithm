#include <cstdio>
#include <queue>

#define MAX 50
using namespace std;

int n;

class node{
	public:
		int parent;
		int childNo;
		bool cut;
		int child[MAX];

		node(){
			parent=0;
			childNo=0;
			cut=false;
		}	
};

node tree[MAX];

void prunning(int p){
	queue<int> q;
	q.push(p);
	while(!q.empty()){
		int now =q.front();
		tree[now].cut=true;
		if(tree[now].parent!=-1){
			tree[tree[now].parent].childNo--;
		}
		q.pop();

		for(int i=0;i<MAX;++i){
			if(tree[now].child[i]==1){q.push(i);}
		}
	}

}

int main(void){
	scanf("%d",&n);

	for(int i=0;i<n;++i){
		scanf("%d",&tree[i].parent);
		if(tree[i].parent!=-1){
			tree[tree[i].parent].child[i]=1;
			tree[tree[i].parent].childNo++;
		}
	}
	
	int prune,res=0;

	scanf("%d",&prune);
	prunning(prune);

	for(int i=0;i<n;++i){
		if(tree[i].cut==false&&tree[i].childNo==0){res++;}
	}
	printf("%d",res);
}
