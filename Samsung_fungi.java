import java.util.Scanner;

public class Samsung_fungi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc<=T; ++tc){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            fungi[][] map = new fungi[N][N];
            fungi[][] nextMap = new fungi[N][N];

            for(int i=0; i<N; ++i){
                for(int j= 0; j<N; ++j){
                    map[i][j] = new fungi(i,j,0,0);
                    nextMap[i][j] = new fungi(i,j,0,0);
                }
            }


            for(int i=0; i<K; ++i){
                int ii =sc.nextInt();
                int jj = sc.nextInt();
                int size = sc.nextInt();
                int nowDir = sc.nextInt();

                map[ii][jj] = new fungi(ii,jj,size,nowDir);
            }

            for(int time = 0; time < M; ++time){

                for(int i=0; i<N; ++i){
                    for(int j=0; j<N; ++j){

                        if(map[i][j].size > 0){
                            fungi now = map[i][j];

                            now.move();

                            if (now.isOnSide(N)) {
                                now.size /= 2;
                                now.invDir();
                            }

                            if(nextMap[now.i][now.j].size == 0){
                                nextMap[now.i][now.j].nowDir = now.nowDir;
                                nextMap[now.i][now.j].maxCnt = now.size;
                            }else if(nextMap[now.i][now.j].size > 0){
                                if(nextMap[now.i][now.j].maxCnt < now.size){
                                    nextMap[now.i][now.j].maxCnt = now.size;
                                    nextMap[now.i][now.j].nowDir = now.nowDir;
                                }
                            }

                            nextMap[now.i][now.j].size += now.size;
                        }

                    }
                }

                for(int i=0; i<N; ++i){
                    for(int j=0; j<N; ++j){
                        map[i][j] = nextMap[i][j];
                        nextMap[i][j] = new fungi(i,j,0,0);
                    }
                }
            }

            int res = 0;

            for(int i=0; i<N; ++i){
                for(int j=0; j<N; ++j){
                    res += map[i][j].size;
                }
            }

            System.out.println("#" + tc + " " + res);
        }
    }

    static class fungi{
        final static int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

        int i, j;
        int size;
        int nowDir;
        int maxCnt;

        fungi(int i, int j,int size, int nowDir){
            this.i = i;
            this.j = j;
            this.size = size;
            this.maxCnt = size;

            if(nowDir == 1){
                this.nowDir = 1;
            }else if(nowDir == 2){
                this.nowDir = 3;
            }else if(nowDir == 3){
                this.nowDir = 0;
            }else if(nowDir == 4){
                this.nowDir = 2;
            }
        }

        void invDir(){
            nowDir = (nowDir + 2) % 4;
        }

        void move(){
            i = i + dir[nowDir][0];
            j = j + dir[nowDir][1];
        }

        boolean isOnSide(int n){
            if(i == 0 || i == n-1 || j == 0 || j == n-1){
                return true;
            }
            return false;
        }
    }
}
