/*
* 알고리즘: 세그먼트 트리
* 문제점: 함수 내에서 세그먼트 트리만 변경한다. 즉, arr 업데이트를 신경 써줘야 됨*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2042 {
    public static void main(String args[]) throws IOException {
        int N,M,K;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[N];

        int depth = (int) (Math.ceil(Math.log(N)/Math.log(2)) + 1);
        long[] tree = new long[(int)Math.pow(2,depth) + 1];

        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        initTree(1,0,N - 1, arr, tree);

        for(int i=0; i< M + K; ++i){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            if(a == 1){
                long diff = c - arr[--b];
                arr[b] = c;
                updateTree(1, b, 0, N - 1, diff, tree);
            }else if(a == 2){
                long result = getSum(1,0, N - 1, --b, --c, tree);
                System.out.println(result);
            }
        }

        bufferedReader.close();
    }

    static long initTree(int now, int start, int end, int[] arr, long[] tree){
        if(start == end){
            return tree[now] = arr[start];
        }

        int mid = (start+end)/2;

        return tree[now] =  initTree(now*2,start,mid,arr,tree) + initTree(now*2+1,mid+1,end,arr,tree);
    }

    static void updateTree(int now, int targetNode, int start, int end, long diff, long[] tree){
        if(!(start <= targetNode && targetNode <= end)){
            return;
        }

        tree[now] += diff;

        if(start != end){
            int mid = (start + end)/2;
            updateTree(now*2, targetNode, start, mid, diff, tree);
            updateTree(now*2 + 1, targetNode, mid + 1, end, diff, tree);
        }
    }

    static long getSum(int now, int nowStart, int nowEnd, int targetStart, int targetEnd, long[] tree){
        if(targetStart > nowEnd || targetEnd < nowStart){
            return 0;
        }

        if(targetStart<= nowStart && nowEnd <= targetEnd){
            return tree[now];
        }

        int mid = (nowStart + nowEnd)/2;
        return getSum(now*2, nowStart, mid, targetStart, targetEnd, tree) + getSum(now*2 + 1, mid + 1, nowEnd, targetStart, targetEnd, tree);
    }
}
