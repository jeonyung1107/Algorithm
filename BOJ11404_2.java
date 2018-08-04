import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ11404_2 {
    public static void main(String[] args){
        final int MAX = Integer.MAX_VALUE/2;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int busNum = sc.nextInt();

        int[][] D = new int[n+1][n+1];

        for(int i=1; i<=n; ++i){
            Arrays.fill(D[i],MAX);
        }

        for(int i=0; i<busNum; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            if(cost < D[start][end]) D[start][end] = cost;
        }

        for(int mid = 1; mid<=n; ++mid){
            for(int s = 1; s<=n; ++s){
                for(int d = 1; d<=n; ++d){
                    if(s == d) continue;

                    if(D[s][d] > D[s][mid] + D[mid][d]) D[s][d] = D[s][mid] + D[mid][d];
                }
            }
        }

        for(int i=1; i<=n; ++i){
            for( int j=1; j<=n; ++j){
                if(D[i][j] == MAX){
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }
}
