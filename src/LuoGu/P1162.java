package LuoGu;

import java.util.Scanner;

public class P1162 {
	static int n;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+2][n+2];
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <=n ; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		// 外围染色
		bfs(0,0);
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <=n ; j++) {
				if(dp[i][j] == 3) System.out.print(0 + " ");
				else if(dp[i][j] == 0) System.out.print(2 + " ");
				else System.out.print(1 + " ");
			}
			System.out.println();
		}
	}
	// 在外围染色
	public static void bfs(int i,int j) {
		if (i >= 0 && i <= n + 1 && j >= 0 && j <= n + 1) {
			if(dp[i][j] == 1 || dp[i][j] == 3) return;
			dp[i][j] = 3;
			bfs(i-1, j);
			bfs(i, j+1);
			bfs(i+1, j);
			bfs(i, j-1);
		}
	}
}
