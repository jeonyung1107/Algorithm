/*
* 문제:
* 알고리즘: DP*/
import java.util.Scanner;

public class BOJ2193 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[n+1];
        dp[1] = 1l;
        if(n>1) dp[2] = 1l;

        for(int i=3;i<=n;++i){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
