/*Algorithm: 이분매칭, 포드 풀커슨, BFS
* */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ2188 {
    static final int NUM = 402;
    static final int S=400;
    static final int E=401;
    static int n,m;
    static int[][] flow = new int[NUM][NUM];
    static ArrayList<Integer>[] adj = new ArrayList[NUM];

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt(); m=sc.nextInt();

        for(int i=0;i<NUM;++i){
            adj[i]=new ArrayList<>();
        }

        int hutNum;
        for(int i=0;i<n;++i){
            hutNum=sc.nextInt();
            makeEdge(S,i,1);

            int hut;
            for(int j=0;j<hutNum;++j){
                hut=sc.nextInt();
                hut+=200;
                hut--;
                makeEdge(i,hut,1);
                makeEdge(hut,E,1);
            }
        }

        int res=0;
        while(true){
            int[] prev = new int[NUM];
            Arrays.fill(prev,-1);
            Queue<Integer> q = new LinkedList<>();

            q.offer(S);
            while(!q.isEmpty()&&prev[E]==-1){
                int u=q.poll();

                for(int v:adj[u]){
                    if(flow[u][v]>0&&prev[v]==-1){
                        q.offer(v);
                        prev[v]=u;
                    }
                }
            }
            if(prev[E]==-1){break;}
            for(int u=E;u!=S;u=prev[u]){
                flow[prev[u]][u]--;
                flow[u][prev[u]]++;
            }
            res++;
        }
        System.out.print(res);
    }

    static void makeEdge(int start,int end,int weight){
        if(start==end){return;}

        adj[start].add(end);
        adj[end].add(start);
        flow[start][end]=weight;
    }
}
