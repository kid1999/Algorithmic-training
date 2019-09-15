package LuoGu;

import java.util.Scanner;

public class P1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n+1][4];
		for (int i = 1; i <=n ; i++) {
			dp[i][0] = sc.nextInt();
			dp[i][1] = sc.nextInt();
			dp[i][2] = sc.nextInt();
			dp[i][3] = sc.nextInt();
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		int res = -1;
		for (int i = 1; i <=n ; i++) {
			if(dp[i][0] <= x && dp[i][1] <= y && x <= dp[i][0] +dp[i][2] && y <= dp[i][1] +dp[i][3]) res = i;
		}
		System.out.println(res);
	}
}
