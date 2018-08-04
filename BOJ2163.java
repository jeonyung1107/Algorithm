import java.util.Scanner;

public class BOJ2163 {
    static int[][] dp;
    static int n,m;
    final static int MAX = 301;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp = new int[MAX][MAX];
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=1; i<=n; ++i){
            for(int j =1; j<=m; ++j){
                if(i == 1 || j == 1) {
                    int max = Math.max(i,j);
                    dp[i][j] = max - 1;
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j] + dp[1][j], dp[i][j-1] + dp[i][1]) + 1;
            }
        }

        System.out.println(dp[n][m]);
    }
}
