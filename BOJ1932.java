/*문제:
* 알고리즘: DP*/
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1932 {
    static int n;
    static int[][] tri = new int[500][];
    static int[][] dp = new int[500][];

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;++i){
            tri[i] = new int[i+1];
            dp[i] = new int[i+1];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;++j){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = tri[0][0];
        long max=0;
        for(int i=1;i<n;++i){
            for(int j=0;j<=i;++j){
                if(j>0&&j<i){dp[i][j] = tri[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);}
                else if(j==0){dp[i][j] = tri[i][j]+dp[i-1][0];}
                else if(j==i){dp[i][j] = tri[i][j]+dp[i-1][j-1];}
                if(dp[i][j]>max){max = dp[i][j];}
            }
        }

        System.out.println(max);

    }
}
