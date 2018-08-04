import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2156 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i<n; ++i){
            arr[i] = scanner.nextInt();
        }

        if(n == 1){
            System.out.println(arr[0]);
            return;
        }

        long[][] dp = new long[n][3];

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        dp[0][2] = 0;
        dp[1][0] = arr[1] + arr[0];
        dp[1][1] = arr[1];
        dp[1][2] = arr[0];

        for(int i = 2; i<n; ++i){
            dp[i][0] = arr[i] + dp[i-1][1];
            dp[i][1] = arr[i] + Math.max(dp[i-2][0],Math.max(dp[i-2][1],dp[i-2][2]));
            dp[i][2] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
        }

        System.out.println(Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2])));
    }
}
