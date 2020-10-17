package lanqiao.test2020;

import java.util.Scanner;

public class H {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][][] dp = new int[101][101][101];
		int[][] nums = new int[101][101];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <=i; k++) {
					dp[i][j][k] = Math.max(dp[i-1][j-1][k-1], dp[i-1][j][k]) + nums[i][j];
				}
			}
		}
		int res = 0;
		int m = n/2;
		if(n%2 == 1){
			for (int i = 1; i <=n; i++) {
				res = Math.max(res, dp[n][i][m+1]);
			}
		}
		if(n%2 == 0){
			for (int i = 1; i <=n; i++) {
				res = Math.max(res, dp[n][i][m]);
				res = Math.max(res, dp[n][i][m+1]);
			}
		}
		System.out.println(res);
	}
}


