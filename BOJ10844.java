import java.util.Scanner;

public class BOJ10844 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int mod = 1_000_000_000;
        int n = scanner.nextInt();

        if(n == 1){
            System.out.println(9);
            return;
        }

        int[][] dp = new int[n + 1][10];
        for(int i = 1; i<=9; ++i){
            dp[1][i] = 1;
        }

        for(int i = 2; i<=n; ++i){
            for(int j = 1; j<=8; ++j){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][ j + 1]) % mod;
            }
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
        }

        int res = 0;
        for(int i=0; i<10; ++i){
            res = (res + dp[n][i]) % mod;
        }

        System.out.println(res);
    }
}
