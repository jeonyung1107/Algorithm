import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static int MIN = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0;i<n;++i){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(dp(arr));
    }

    public static long dp(int[] arr){
        long res = MIN , tempSum = MIN;

        for(int i=0;i<arr.length;++i){
            tempSum = Math.max(tempSum,0) + arr[i];
            res = Math.max(tempSum,res);
        }

        return res;
    }
}
