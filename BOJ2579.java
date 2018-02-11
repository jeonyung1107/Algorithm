/*문제: 계단 오르기 (https://www.acmicpc.net/problem/2579)
* 알고리즘: DP*/
import java.util.Scanner;

public class BOJ2579 {
    static final int MAX = 300;
    static int[] step = new int[MAX];
    static int[][] dp = new int[MAX][MAX];
    static int n;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i=0;i<n;++i){
            step[i] = sc.nextInt();
        }

        dp[0][0] = step[0];
        dp[0][1] = step[0];
        dp[1][0] = step[1]+step[0];
        dp[1][1] = step[1];

        for(int i=2;i<n;++i){
            dp[i][0] = dp[i-1][1]+step[i];
            dp[i][1] = Math.max(dp[i-2][0],dp[i-2][1])+step[i];
        }

        System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));

    }
}
