package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class P9095 {

	static int[] dp;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		dp(11);
		
		for (int i = 0; i < n; i++) {
			int r = Integer.parseInt(br.readLine());
			
			System.out.println(dp[r]);
		}
	}
	
	static int dp(int n) {
		if (dp[n] == 0) {
			dp[n] = dp(n-1) + dp(n-2) + dp(n-3);
		}
		
		return dp[n];
	}
}
