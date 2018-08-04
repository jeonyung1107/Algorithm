import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BOJ2167 {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        arr = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                arr[i][j] = scanner.nextInt();
                dp[i][j] = dp[i][j-1] + arr[i][j];
            }
        }

        int t = scanner.nextInt();

        while(t-->0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            int res = 0;

            for(int i=a; i<=c; ++i){
                res += dp[i][d] - dp[i][b-1];
            }

            System.out.println(res);
        }
    }
}
