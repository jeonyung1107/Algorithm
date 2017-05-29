import java.util.Scanner;

public class Baek_8895 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long [][][] dp;
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int n[] = new int[d];
		int l[] = new int[d];
		int r[] = new int[d];
		
		dp = new long[20+1][20+1][20+1];
		
		int i=0;
		int j=0;
		int k=0;
		
		dp[1][1][1] = 1;
		
		for(i = 2;i<=20; i++){
			for(j = 1; j<=20; j++){
				for(k = 1; k<=20; k++){
					dp[i][j][k] = dp[i-1][j-1][k]+dp[i-1][j][k-1]+dp[i-1][j][k]*(i-2);
				}
			}
		}
		
		for(i = 0; i<d; i++){
			n[i] = sc.nextInt();
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		for(i = 0; i<d; i++){
			System.out.println(dp[n[i]][l[i]][r[i]]);
		}
	}
}
