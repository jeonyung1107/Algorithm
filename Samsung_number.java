import java.util.Scanner;

public class Samsung_number {
    static int[] numbers;
    static int[] operators;
    static int max;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc<=T; ++tc){
            max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
            int N = sc.nextInt();
            operators = new int[4];
            numbers = new int[N];

            for(int i = 0; i<4; ++i){
                operators[i] = sc.nextInt();
            }
            for(int i=0; i<N; ++i){
                numbers[i] = sc.nextInt();
            }

            dfs(numbers[0],0,N-1);

            int res = max - min;

            System.out.println("#" + tc + " " + res);
        }
    }

    static void dfs(int num,int depth, int targetDepth){

        if(depth == targetDepth){
            max = Math.max(num,max);
            min = Math.min(num,min);
        }else if(depth != targetDepth){
            if(operators[0] > 0){
                operators[0]--;
                dfs(num + numbers[depth+1],depth+1,targetDepth);
                operators[0]++;
            }
            if(operators[1] > 0){
                operators[1]--;
                dfs(num - numbers[depth+1],depth+1,targetDepth);
                operators[1]++;
            }
            if(operators[2] > 0){
                operators[2]--;
                dfs(num * numbers[depth+1], depth+1, targetDepth);
                operators[2]++;
            }
            if(operators[3] > 0){
                operators[3]--;
                dfs(num / numbers[depth+1], depth+1, targetDepth);
                operators[3]++;
            }
        }
    }
}
