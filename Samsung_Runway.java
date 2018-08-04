import java.util.Scanner;

public class Samsung_Runway {
    static int n,x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tc = 1; tc <=t; ++tc){
            int res = 0;
            n = sc.nextInt();
            x = sc.nextInt();
            int[][] map = new int[n][n];

            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    map[i][j] = sc.nextInt();
                }
            }

            int[] line = new int[n];

            for(int i = 0; i<n; ++i){
                for(int j = 0; j<n; ++j){
                    line[j] = map[i][j];
                }
                if(isLine(line)) res++;
            }
            for(int i =0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    line[j] = map[j][i];
                }
                if(isLine(line)) res++;
            }

            System.out.println("#" + tc + " " + res);
        }

    }

    static boolean isLine(int[] line){
        boolean[] isUsed = new boolean[line.length];

        for(int i=0; i<line.length-1; ++i){
            if(Math.abs(line[i]-line[i+1])>=2) return false;

            if(line[i+1] == line[i]+1){
                if(!isEven(i-x+1,i,line,isUsed)){
                    return false;
                }
            }else if(line[i+1] == line[i]-1){
                if(!isEven(i+1,i+x,line,isUsed)){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isEven(int s, int e, int[] line, boolean[] isUsed){
        if(s<0 || e>=n) return false;
        for(int i=s; i<=e;++i){
            if(isUsed[i]) return false;
            if(i<e && line[i] != line[i+1]) return false;
        }

        for(int i=s; i<=e; ++i) isUsed[i] = true;

        return true;
    }
}
