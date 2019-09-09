package luogu;

import java.util.Scanner;

public class P1028 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			if(i%2==0) dp[i] = dp[i-1] + dp[i/2];
			else dp[i] = dp[i-1];
		}
		System.out.println(dp[n]);	
	}
}
