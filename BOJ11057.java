import java.util.Scanner;

public class BOJ11057 {
    static int[][] dp = new int[1_001][10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<10; ++i){
            dp[1][i] = 1;
        }

        for(int i=2; i<=1000; ++i){
            for(int j=0; j<=9; ++j){
                for(int k=0; k<=j; ++k){
                    dp[i][j] = (dp[i][j] +  dp[i-1][k]) % 10_007;
                }
            }
        }

        int res = 0;

        for(int i=0; i<10; ++i){
            res += dp[n][i];
        }

        System.out.println(res % 10007);
    }
}
