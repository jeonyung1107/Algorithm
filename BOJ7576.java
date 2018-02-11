import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ7576 {
    static final int MAX=1_000;
    static int[][] box=new int[MAX][MAX];
    static int[][] nexts = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m,tomNum;

    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);

       Queue<Point> q = new LinkedList<>();

       m=sc.nextInt(); n=sc.nextInt();

       for(int i=0;i<n;++i){
           for(int j=0;j<m;++j){
               box[i][j]=sc.nextInt();
               if(box[i][j]==1){
                   q.offer(new Point(i,j));
               }else if(box[i][j]==0){
                   ++tomNum;
               }
           }
       }

       int res=-1;
       while(!q.isEmpty()) {
//           하루치 변환
           int size = q.size();
           for(int i=0;i<size;++i){
               Point now = q.poll();

               for (int[] next : nexts) {
                   int x = now.x+next[0];
                   int y = now.y+next[1];

                   if (x >= 0 && x < n && y >= 0 && y < m) {
                       if (box[x][y] == 0) {
                           box[x][y] = 1;
                           --tomNum;
                           q.offer(new Point(x,y));
                       }
                   }
               }
           }
           res++;
       }

       if(tomNum>0){
           System.out.print(-1);
           return;
       }

       System.out.print(res);
    }

    static class Point{
        int x;
        int y;

        Point(){
            x=0;
            y=0;
        }
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
