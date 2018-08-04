import java.util.Scanner;

public class Samsung_cook {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc<=T; ++tc){
            int n = sc.nextInt();
            int[][] s = new int[n][n];

            for(int i = 0; i<n; ++i){
                for(int j = 0; j<n; ++j){
                    s[i][j] = sc.nextInt();
                }
            }

            res = Integer.MAX_VALUE;
            int[] AB = new int[n];
            dfs(0,0,n,s,AB);
            System.out.println("#" + tc + " " + res);
        }
    }

    static void dfs(int now, int cntA,int total, int[][] s,int[] AB){
        if(now == total){
            if(cntA == total/2){
                int A = 0;
                int B = 0;
                for(int i=0; i<total; ++i){
                    for(int j=0; j<total; ++j){
                        if(AB[i] == 1 && AB[j] == 1){
                            A += s[i][j];
                        }

                        if (AB[i] == 0 && AB[j] == 0) {
                            B += s[i][j];
                        }
                    }
                }
                int tmpRes = Math.abs(A-B);
                if(res>tmpRes) res = tmpRes;
            }
            return;
        }
        if(cntA < total/2){
            AB[now] = 1;
            dfs(now+1,cntA+1,total, s,AB);
            AB[now] = 0;
        }
        dfs(now+1,cntA,total,s,AB);
    }
}
