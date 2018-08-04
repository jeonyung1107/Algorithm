import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Line5 {

    /**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < N; i++) {
                StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
                int M = Integer.parseInt(tokens.nextToken());
                int D = Integer.parseInt(tokens.nextToken());
                int I = Integer.parseInt(tokens.nextToken());

            }
        }
    }
}
