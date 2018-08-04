import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    static int[][] dp;
    static int[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        while (t-->0){
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            dp = new int[n+1][3];
            points = new int[n+1][2];

            StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());
            StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());

            for(int i=1; i<=n;++i){
                points[i][0] = Integer.parseInt(st1.nextToken());
                points[i][1] = Integer.parseInt(st2.nextToken());
            }

            dp[1][1] = points[1][0];
            dp[1][2] = points[1][1];

            if(n == 1){
                System.out.println(Math.max(points[1][0],points[1][1]));
                break;
            }

            for(int i=2; i<=n; ++i){
                dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
                dp[i][1] = points[i][0] + Math.max(dp[i-1][2],dp[i-1][0]);
                dp[i][2] = points[i][1] + Math.max(dp[i-1][1],dp[i-1][0]);
            }

            System.out.println(Math.max(dp[n][0],Math.max(dp[n][1],dp[n][2])));
        }
    }
}
