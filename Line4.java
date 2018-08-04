import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Line4 {

    /**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws IOException {
        int mod = 1003001;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int T = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < T; i ++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
                int N = Integer.parseInt(tokenizer.nextToken());
                int K = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());

                System.out.println((composition(N,K-M)*composition(N,M))%mod);
            }
        }
    }
    public static int composition(int x, int y){
        long wii = 1;
        long are = 1;
        for(int i=0;i<y;++i){
            wii *=(x-i);
            are *=i+1;
        }

        return (int)(wii/are);
    }
}

