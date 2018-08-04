import java.util.Scanner;

public class BOJ9461 {
    static long[] dp = new long[101];

    public static void main(String[] args) {
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;

        for(int i = 6; i<=100; ++i){
            dp[i] = dp[i-1] + dp[i-5];
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            System.out.println(dp[sc.nextInt()]);
        }
    }
}
