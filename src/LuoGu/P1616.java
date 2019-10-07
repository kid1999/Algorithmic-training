package LuoGu;

import java.util.Scanner;

public class P1616 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m = sc.nextInt();
		int[] dp = new int[t+1];
		int[] weight = new int[m+1];
		int[] value = new int[m+1];
		for (int i = 1; i <=m ; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		for (int i = 1; i <=m ; i++) {
			for (int j = weight[i]; j <=t; j++) {
				dp[j] = Math.max(dp[j],dp[j-weight[i]] + value[i]);
			}
		}
		System.out.println(dp[t]);
	}
}
