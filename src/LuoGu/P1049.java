package LuoGu;

import java.util.Scanner;

public class P1049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		int[][] dp = new int[n+1][w+1];
		int[] w_and_v = new int[n+1];
		for (int i = 1; i <=n ; i++) {
			w_and_v[i] = sc.nextInt();
		}
		for (int i = 1; i <=n ; i++) {
			for (int j = 1; j <=w ; j++) {
				if(w_and_v[i] > j){
					dp[i][j] = dp[i-1][j];
				}else{
					int v1 = dp[i-1][j];
					int v2 = dp[i-1][j-w_and_v[i]] + w_and_v[i];
					dp[i][j] = Math.max(v1,v2);
				}
			}
		}
		System.out.println(w-dp[n][w]);
	}
}
