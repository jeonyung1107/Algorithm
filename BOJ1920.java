import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ1920 {
    final static int MAX = 100_000;
    static int list[] = new int[MAX];
    static int target[] = new int[MAX];
    static int n,m;

    static boolean bSearch(int t){
        int s = 0;
        int e = n-1;

        while (e>=s) {
            int mid = (s+e)/2;

            if(list[mid]==t){
                return true;
            }else if(list[mid]>t){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return false;
    }

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;++i){
            list[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;++i){
            target[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list,0,n);
        for(int i=0;i<m;++i){
            if(bSearch(target[i])){
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
