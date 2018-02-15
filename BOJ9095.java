/*문제:
* 알고리즘: DP*/
import java.util.Scanner;

public class BOJ9095 {
    static final int MAX = 11;
    static int[] dp = new int[MAX];
    static int t;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4;i<11;++i){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        t = sc.nextInt();
        for(int i=0;i<t;++i){
            int tmp = sc.nextInt();
            System.out.println(dp[tmp]);
        }
    }
}
