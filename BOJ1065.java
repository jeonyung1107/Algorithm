/*
* 문제: https://www.acmicpc.net/problem/1065
* 알고리즘: 브루트포스*/
import java.io.*;
import java.util.StringTokenizer;
public class BOJ1065 {
    static int n;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[3];
        n = Integer.parseInt(st.nextToken());

        int res =0;
        for (int i = 1; i <= n; ++i) {
            if(i<100) {
                res = i;
                continue;
            }
            if(i==1000) break;

            int t =i;
            int k = 0;
            while (t>0){
                a[k] = t%10;
                t/=10;
                ++k;
            }
            if(a[0]-a[1] == a[1]-a[2]) res++;
        }
        System.out.println(res);
    }
}
