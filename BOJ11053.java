import java.io.File;
import java.util.Scanner;

public class BOJ11053 {
    static int cnt = 0;
    static int[] dp;
    static int[] arr;
    public static void main (String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];


        for(int i=0; i<n; ++i){
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        cnt++;

        for(int i=1; i<n; ++i){
            if(arr[i] > dp[cnt-1]){
                dp[cnt] = arr[i];
                cnt++;
            }else{
                lowerBound(arr[i],0,cnt-1);
            }
        }

        System.out.println(cnt);
    }

    static void lowerBound(int target, int s, int e){
        int mid = (s+e)/2;
        if(mid >0 && dp[mid] > target && target > dp[mid-1]) {
            dp[mid] = target;
            return;
        }

        if(s >= e){
            if(target < dp[s]) dp[s] = target;
            return;
        }

        if(dp[mid] > target){
            lowerBound(target,s,mid-1);
        }else if(dp[mid] < target){
            lowerBound(target,mid + 1, e);
        }
    }
}
