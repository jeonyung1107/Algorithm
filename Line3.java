import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Line3 {
    public static final int MAX = 100_001;
    public static int[] roots = new int[MAX];
    public static int unionNum = 0;

    /**
     * Time complexity:
     * Space complexity:
     */
    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < N; i++) {
                StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(tokens.nextToken());
                int y = Integer.parseInt(tokens.nextToken());

                union(x,y);
            }
        }
        System.out.println(unionNum);
    }

    public static void union(int x, int y){
        if(roots[x] == 0 && roots[y] == 0){
            roots[y] = x;
            roots[x] = x;
            ++unionNum;
        }else if(roots[x] != 0 && roots[y] != 0){
            if(roots[x] !=  roots[y]){
                roots[y] = findRoot(x);
                --unionNum;
            }
        }else if(roots[x] != 0){
            roots[y] = findRoot(x);
        }else if(roots[y] != 0){
            roots[x] = findRoot(y);
        }
    }

    public static int findRoot(int x){
        int root = roots[x];
        while(root != roots[root]){
            root = roots[root];
        }

        return root;
    }
}

