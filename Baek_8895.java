import java.util.Scanner;

public class Baek_8895 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int l;
		int r;
		int [][][] dp;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		if(n ==1){
			System.out.println(1);
			return;
		}
		
		dp = new int[n][n][n];
		
		int i=0;
		int j=0;
		int k=0;
		
		for(i = 0; i<n;i++){
			for(j = 0; j<n; j++){
				for(k = 0; k<n; k++){
					dp[i][j][k] = 1;
				}
			}
		}
		i = 0;
		j = 0;
		k = 0;
		
		for( i = 0; i<l; i++){
			if(i!=0)dp[i][j][k] = dp[i-1][j][k];
			for( j = 0; j<r; j++){
				if(j!=0)dp[i][j][k] = dp[i][j-1][k];
				for( k = 1; k<n-i-j; k++){
					if(i+j>0)dp[i][j][k] = dp[i][j][k-1]*(i+j+k-1);
				}
				k = 0;
			}
			j = 0;
		}
		System.out.println(dp[l-1][r-1][n-l-r+1]);
	}
}
