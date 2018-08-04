import java.io.File;
import java.util.Scanner;

public class BOJ2698 {
    static int[][][] dp = new int[101][101][2];

    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int t = sc.nextInt();

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for(int i=0; i<100; ++i){
            for(int j=2; j<=100; ++j){
                if(i == 0){
                    dp[j][i][1] += dp[j-1][i][0];
                }else{
                    dp[j][i][1] += dp[j-1][i][0] + dp[j-1][i-1][1];
                }
                dp[j][i][0] += dp[j-1][i][0] + dp[j-1][i][1];
            }
        }

        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int result = dp[n][k][0] + dp[n][k][1];
            System.out.println(result);
        }
    }
}
