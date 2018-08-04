import java.util.Scanner;

public class BOJ11726 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n == 1){
            System.out.println(1);
            return;
        }

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;

        for(int i=2;i<n;++i){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[n-1]);
    }
}
