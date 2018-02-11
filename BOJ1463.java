import java.util.Scanner;
import java.util.Arrays;
public class BOJ1463 {
    static final int MAX = 1_000_001;
    static int[] dp = new int[MAX];

    static int find(int n){
        if(n==1) return 0;

        int d3=MAX,d2=MAX,d1;
        if(dp[n]==0){
            if(n%3==0) d3=find(n/3)+1;
            if(n%2==0) d2=find(n/2)+1;
            d1=find(n-1)+1;

            int min = (d3>d2)?(d2>d1?d1:d2):(d3>d1?d1:d3);
            dp[n] = min;

            return min;
        }else{
            return dp[n];
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(find(n));
    }
}
