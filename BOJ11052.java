import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] dp = new int[N + 1];
        int[] price = new int[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<=N; ++i){
            price[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        dp[1] = price[1];

        for(int i=2;i<=N;++i){
            for(int j = 1; j<=i;++j){
                dp[i] = Math.max(dp[i],dp[i - j] + price[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
