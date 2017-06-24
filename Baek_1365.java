import java.util.Scanner;
public class Baek_1365 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int [] dp = new int[n];
		for(int i= 0; i<n; i++) dp[i] = 1;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<i; j++){
				if(arr[j] <arr[i]){
					if(dp[i]<=dp[j]){
						dp[i] = dp[j] +1;
					}
				}
			}
		}
		int m = 0;
		for(int i = 0; i<n; i++){
			if(dp[i]>m) m = dp[i];
		}
		System.out.println(n-m);	
	}
}
