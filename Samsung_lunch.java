import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Samsung_lunch {
    static int[][] map;
    static int[][][] stairsQueue;
    static int[][] stair;
    static int[][] peoples;
    static int peoplePoint;
    static int stairPoint;
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1; tc<=T; ++tc){
            int n = sc.nextInt();
            map = new int[n][n];
            stairsQueue = new int[2][3][3];
            stair = new int[2][3];
            peoples = new int[n*n][3];

            peoplePoint = 0;
            stairPoint = 0;
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    map[i][j] = sc.nextInt();
                    if(map[i][j] == 1){
                        peoples[peoplePoint][0] = i;
                        peoples[peoplePoint][1] = j;
                        peoples[peoplePoint][2] = -1;
                        peoplePoint++;
                    }else if(map[i][j] > 1){
                        stair[stairPoint][0] = map[i][j];
                        stair[stairPoint][1] = i;
                        stair[stairPoint][2] = j;
                        stairPoint++;
                    }
                }
            }

            for(int i=0; i<2; ++i){
                for(int j=0; j<3; ++j){
                    stairsQueue[i][j][0] = 0;
                    stairsQueue[i][j][1] = stair[i][0];
                    stairsQueue[i][j][2] = Integer.MAX_VALUE;
                }
            }

            res = Integer.MAX_VALUE;
            dfs(0,peoplePoint);

            System.out.println("#" + tc + " " + res + 1);
        }
    }

    static void dfs(int depth, int targetDepth){
        if(depth == targetDepth){

            int[][] waitinPeople = new int[targetDepth][2];
            Deque<Integer>[] staitWaiting = new Deque[2];
            staitWaiting[0] = new LinkedList<>();
            staitWaiting[1] = new LinkedList<>();

            for(int i=0; i<targetDepth; ++i){
                waitinPeople[i][0] = peoples[i][2];
                waitinPeople[i][1] = Math.abs(peoples[i][0] - stair[waitinPeople[i][0]][1]) +
                        Math.abs(peoples[i][1] - stair[waitinPeople[i][0]][2]);
            }

            int time = 0;
            int totalCount = 0;
            while(true){
                for(int i=0; i<targetDepth; ++i){
                    if(waitinPeople[i][1] == time){
                        staitWaiting[waitinPeople[i][0]].offer(1);
                    }
                }

                for(int i=0; i<3; ++i){
                    if(stairsQueue[0][i][0] == 1 && time - stairsQueue[0][i][2] == stairsQueue[0][i][1]){
                        stairsQueue[0][i][0] = 0;
                        stairsQueue[0][i][2] = Integer.MAX_VALUE;
                        totalCount++;
                    }
                    if(stairsQueue[1][i][0] ==1 && time - stairsQueue[1][i][2] == stairsQueue[1][i][1]){
                        stairsQueue[1][i][0] = 0;
                        stairsQueue[1][i][2] = Integer.MAX_VALUE;
                        totalCount++;
                    }
                }

                if(!staitWaiting[0].isEmpty()){
                    for(int i=0; i<3; ++i){
                        if(stairsQueue[0][i][0] == 0 && !staitWaiting[0].isEmpty()){
                            stairsQueue[0][i][0] = staitWaiting[0].poll();
                            stairsQueue[0][i][2] = time;
                        }
                    }
                }

                if(!staitWaiting[1].isEmpty()){
                    for(int i=0; i<3; ++i){
                        if(stairsQueue[1][i][0] == 0 && !staitWaiting[1].isEmpty()){
                            stairsQueue[1][i][0] = staitWaiting[1].poll();
                            stairsQueue[1][i][2] = time;
                        }
                    }
                }

                if(totalCount == targetDepth){
                    res = Math.min(time,res);
                    break;
                }
                time++;
            }
            return;
        }

        peoples[depth][2] = 0;
        dfs(depth+1,targetDepth);

        peoples[depth][2] = 1;
        dfs(depth+1,targetDepth);

    }
}
