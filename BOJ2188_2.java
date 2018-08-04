import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.*;

public class BOJ2188_2 {
    static int N,M;
    static int[] A, B, dist;
    static boolean[] used;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        A = new int[N + 1];
        B = new int[M + 1];
        dist = new int[N + 1];
        used = new boolean[N + 1];
        adj = new ArrayList[N + 1];

        for(int i=0; i<adj.length;++i){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<N;++i){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int hutNum = Integer.parseInt(stringTokenizer.nextToken());
            for(int j=0;j<hutNum;++j){
                adj[i].add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }

        Arrays.fill(A,-1);
        Arrays.fill(B,-1);

        int matchNum = 0;
        while (true){
            bfs();

            int flow = 0;
            for(int i=0;i<N;++i){
                if(!used[i] && dfs(i)) {flow++;}
            }

            if(flow == 0) {
                break;
            }
            matchNum += flow;
        }

        System.out.println(matchNum);
    }

    static void bfs(){
        Deque<Integer> q = new LinkedList<>();

        for(int i=0;i<N;++i){
            if(!used[i]){
                dist[i] = 0;
                q.offer(i);
            }else{
                dist[i] = Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()){
            int a = q.poll();

            for(int b : adj[a]){
                if(B[b] != -1 && dist[B[b]] == Integer.MAX_VALUE){
                    dist[B[b]] = dist[a] + 1;
                    q.offer(B[b]);
                }
            }
        }
    }

    static boolean dfs(int a){
        for(int b : adj[a]){
            if(B[b] == -1 || dist[B[b]] == dist[a] + 1 && dfs(B[b])){
                used[a] = true;
                A[a] = b;
                B[b] = a;
                return true;
            }
        }
        return false;
    }
}
