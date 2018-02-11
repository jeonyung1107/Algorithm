/*
* 문제: 경로찾기 (https://www.acmicpc.net/problem/11403)
* 알고리즘: BFS
* */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ11404 {
    static final int MAX = 100;
    static int[][] mat = new int[MAX][MAX];
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>(MAX);
    static int n;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i=0;i<n;++i){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                mat[i][j] = sc.nextInt();
                if(mat[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }

        for(int i=0;i<n;++i){
            Queue<Integer> q = new LinkedList<>();
            q.addAll(adj.get(i));

            while(!q.isEmpty()&&adj.get(i).size()<n){
                int now = q.poll();

                for(Integer indirect: adj.get(now)){
                    if(!adj.get(i).contains(indirect)){
                       adj.get(i).add(indirect);
                       mat[i][indirect] = 1;
                       q.offer(indirect);
                    }
                }
            }
        }
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
