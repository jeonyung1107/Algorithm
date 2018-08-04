import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Samsung_repair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc<=T; ++tc){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();

            int[][] reception = new int[N][3];
            int[][] repair = new int[M][3];
            int[][] people = new int[K][2];
            int[][] where = new int[K+1][2];

            Deque<Integer> receptionWait = new LinkedList<>();
            Deque<Integer> repairWait = new LinkedList<>();

            for(int i=0; i<N; ++i){
                reception[i][1] = sc.nextInt();
                reception[i][2] = Integer.MAX_VALUE;
            }
            for(int i=0; i<M; ++i){
                repair[i][1] = sc.nextInt();
                repair[i][2] = Integer.MAX_VALUE;
            }
            for(int i=0; i<K; ++i){
                people[i][0] = i+1;
                people[i][1] = sc.nextInt();
            }

            int time = 0;
            int peoplePoint = 0;
            int checkedNum = 0;

            while (true){
                while(peoplePoint < K && people[peoplePoint][1] <= time){
                    receptionWait.offer(people[peoplePoint][0]);
                    peoplePoint++;
                }

                for(int i=0; i<M; ++i){
                    if(time - repair[i][2] == repair[i][1]){
                        repair[i][0] = 0;
                        repair[i][2] = Integer.MAX_VALUE;
                    }
                }

                for(int i=0; i<N; ++i){
                    if(time - reception[i][2] == reception[i][1]){
                        repairWait.offer(reception[i][0]);
                        reception[i][0] = 0;
                        reception[i][2] = Integer.MAX_VALUE;
                    }
                }



                while (!repairWait.isEmpty()){
                    for(int i=0; i<M; ++i){
                        if(repair[i][0] == 0 && !repairWait.isEmpty()){
                            int now = repairWait.poll();
                            repair[i][0] = now;
                            repair[i][2] = time;
                            where[now][1] = i+1;
                            checkedNum++;
                        }
                    }

                    break;
                }

                while(!receptionWait.isEmpty()){
                    for(int i=0; i<N; ++i){
                        if(reception[i][0] == 0 && !receptionWait.isEmpty()){
                            int now = receptionWait.poll();
                            reception[i][0] = now;
                            reception[i][2] = time;
                            where[now][0] = i+1;
                        }
                    }

                    break;
                }

                if(checkedNum == K) break;

                time++;
            }

            int res = 0;
            for(int i=1; i<=K; ++i){
                if(where[i][0] == A && where[i][1] == B){
                    res += i;
                }
            }
            if(res == 0) res = -1;

            System.out.println("#" + tc + " " + res);
        }
    }
}
