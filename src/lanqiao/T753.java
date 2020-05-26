package lanqiao;

import java.util.Scanner;

/**
 * @author kid1999
 * @title: T753
 * @date 2020/5/26 9:01
 */

public class T753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n+1];
		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		int[][] dp = new int[5][n+1];
		for (int i = 1; i <=n ; i++) {
			dp[1][i] = 1;
			for (int j = i+1; j <=n ; j++) {
				if(nums[j] > nums[i]){
					dp[2][j] += dp[1][i];
					dp[3][j] += dp[2][i];
					dp[4][j] += dp[3][i];
				}
			}
		}
		long sum = 0L;
		for (int i = 4; i <=n ; i++) {
			sum += dp[4][i];
		}
		System.out.println(sum);
	}
}
