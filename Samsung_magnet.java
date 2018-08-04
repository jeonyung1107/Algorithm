import java.util.Scanner;

public class Samsung_magnet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc<=T; ++tc){
            int cycleNum = sc.nextInt();
            int[][] magnet = new int[4][8];
            int[] point = new int[4];

            for(int i=0; i<4; ++i){
                for(int j=0; j<8; ++j){
                    magnet[i][j] = sc.nextInt();
                }
            }

            for(int i= 0; i<cycleNum; ++i){
                boolean[] checked = new boolean[4];
                int now = sc.nextInt()-1;
                int where = sc.nextInt();
                rotate(now,where,magnet,point,checked);
            }

            int res = 0;
            for(int i=0; i<4; ++i){
                if(magnet[i][point[i]] == 1) res += Math.pow(2,i);
            }

            System.out.println("#" + tc + " " + res);
        }
    }

    static void rotate(int now, int where,int[][] magnet, int[] point,boolean[] checked){
        if(now<0 || now>=4 || checked[now] ){
            return;
        }
        checked[now] = true;

        if(now-1 >= 0 && !checked[now-1] && magnet[now][mod(point[now]-2,8)] != magnet[now-1][mod(point[now-1]+2,8)]){
            rotate(now-1,(-1)*where,magnet,point,checked);
        }
        if(now+1 <4 && !checked[now+1] && magnet[now][mod(point[now]+2,8)] != magnet[now+1][mod(point[now+1]-2,8)]){
            rotate(now+1,(-1)*where,magnet,point,checked);
        }

        point[now] = mod(point[now] - where,8);
    }

    static int mod(int n, int mod){
        if(n<0){
            return mod + n;
        }else{
            return n%mod;
        }
    }
}
