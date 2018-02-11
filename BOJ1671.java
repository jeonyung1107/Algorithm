import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ1671 {
    private static final int MAX=2_000_000_000;
    private static final int NUM=2_002;
    private static int[][] flow=new int[NUM][NUM];
    private static ArrayList<Integer>[] adj = new ArrayList[NUM];

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<NUM;++i){
            adj[i]=new ArrayList<>();
        }

        int n=sc.nextInt();
        int[][] sharks=new int[n][3];

        for(int i=0;i<n;++i){
            sharks[i][0]=sc.nextInt();
            sharks[i][1]=sc.nextInt();
            sharks[i][2]=sc.nextInt();
        }

        for(int i=0;i<n;++i){
//            source와 sink 간선 연결

            makeEdge(2*n,2*i,2);
            makeEdge(2*i+1,2*n+1,1);

//            먹을 수 있는 경우 간선 생성. 이 때 서로 먹을 수 있는 경우 index가 작은 쪽이 먹는다.
            for(int j=0;j<n;++j){
                if(i==j){continue;}
                if(sharks[i][0]<sharks[j][0]||sharks[i][1]<sharks[j][1]||sharks[i][2]<sharks[j][2]){continue;}
                if(sharks[i][0]==sharks[j][0]&&sharks[i][1]==sharks[j][1]&&sharks[i][2]==sharks[j][2]&&i>j){continue;}
                makeEdge(2*i,2*j+1,1);
            }
        }

        int res=n;
        while(true){
            int[] prev=new int[NUM];
            Arrays.fill(prev,-1);

            Queue<Integer> q = new LinkedList<>();
            q.offer(2*n);
            while(!q.isEmpty()&&prev[2*n+1]==-1){
                int u=q.poll();

                for(int v:adj[u]){
                    if(flow[u][v]>0 &&prev[v]==-1){
                        q.offer(v);
                        prev[v]=u;
                    }
                }
            }
            if(prev[2*n+1]==-1){break;}
            for(int u=2*n+1;u!=2*n;u=prev[u]){
                flow[prev[u]][u]--;
                flow[u][prev[u]]++;
            }
            res--;
        }
        System.out.println(res);
    }

    private static void makeEdge(int start,int end,int weight){
        if(start==end){return;}

        adj[start].add(end);
        adj[end].add(start);
        flow[start][end]=weight;
    }
}

