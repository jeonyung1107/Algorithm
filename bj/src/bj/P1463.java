package bj;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1463 {

	static final int MAX_N = 1_000_000;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		dp = new int[MAX_N + 1];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(dp(n));
	}

	public static int dp(int n) {
		if (n == 1) {
			return 0;
		}

		if (dp[n] == 0) {

			int r3 = n % 3 == 0 ? dp(n / 3) : Integer.MAX_VALUE;
			int r2 = n % 2 == 0 ? dp(n / 2) : Integer.MAX_VALUE;
			int r1 = dp(n - 1);

			dp[n] = Math.min(r3, Math.min(r2, r1)) + 1;
		}

		return dp[n];
	}
}
