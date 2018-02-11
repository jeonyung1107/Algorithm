/*
문제유형: 이분매칭
알고리즘: 이분매칭
참고: http://blog.naver.com/PostView.nhn?blogId=kks227&logNo=220807541506
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ11375 {
    static final int MAX=1_000;
    static int n,m;
    static int A[]=new int[MAX];
    static int B[]=new int[MAX];
    static ArrayList<Integer> adj[] = new ArrayList[MAX];
    static boolean visited[] = new boolean[MAX];

    static boolean dfs(int now){
        visited[now]=true;
        for(int b:adj[now]){
            if(B[b]==-1||!visited[B[b]]&&dfs(B[b])){
                A[now]=b;
                B[b]=now;

                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0;i<MAX;++i){
            adj[i]= new ArrayList<>();
        }

        for(int i=0;i<n;++i){
            int s=sc.nextInt();

            for(int j=0;j<s;++j){
                int k=sc.nextInt();
                adj[i].add(k-1);
            }
        }

        int match=0;
        Arrays.fill(A,0,n,-1);
        Arrays.fill(B,0,m,-1);

        for(int i=0;i<n;++i){
            if(A[i]==-1){
                Arrays.fill(visited,false);
                if(dfs(i)){match++;}
            }
        }

        System.out.print(match);
    }

}
