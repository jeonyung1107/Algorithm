import java.util.Scanner;

public class BOJ1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX = 31;

        int[][] dp = new int[MAX][MAX];
        for(int i=1; i<MAX; ++i){
            dp[1][i] = i;
        }

        for(int n = 2; n < MAX; ++n){
            for(int m = n; m<MAX; ++m){
                for(int i = m-1; i >= n-1; i--)
                    dp[n][m] += dp[n - 1][i];
            }
        }

        int T = scanner.nextInt();

        for(int i=0; i<T; ++i){
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            if (N == M){
                System.out.println(1);
                continue;
            }

            System.out.println(dp[N][M]);

        }
    }
}
