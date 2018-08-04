import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2157 {
    static int N,M,K;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        arr = new int[301][301];
        dp = new int[301][301];

        for(int i=0; i<301; ++i){
            Arrays.fill(arr[i],-1);
            Arrays.fill(dp[i],-1);
        }

        for(int i=0; i<K; ++i){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int val = sc.nextInt();
            if(s<e)arr[s][e] = Math.max(arr[s][e],val);
        }

        dp[1][1] = 0;
        for (int i = 2; i <= N; i++)
        {
            for (int j = 1; j < i; j++)
            {
                for (int k = 1; k <= M; k++)
                {
                    if (arr[j][i] != -1 && dp[j][k - 1] != -1)
                    {
                        dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + arr[j][i]);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= M; i++) res = Math.max(res, dp[N][i]);

        System.out.println(res);
    }
}
