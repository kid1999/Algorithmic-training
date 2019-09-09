package luogu;

import java.util.Scanner;

public class P1477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int h = sc.nextInt() + sc.nextInt();
		int[] nums = new int[n+1];
		int height,run,count=0;
		for (int i = 0; i < n; i++) {
			height = sc.nextInt();
			run = sc.nextInt();
			if(height <= h && run <= s) nums[count++] = run;
		}
		
		// dp Ñ°ÕÒ×î´óÖµ
		int[][] dp = new int[count+1][s+1];
		for (int i = 1; i <= count; i++) {
			for (int j = 0; j <= s; j++) {
				dp[i][j] = dp[i-1][j];
				if(nums[i-1] <= j) {
					dp[i][j] = Math.max(dp[i-1][j-nums[i-1]]+1, dp[i][j]);
				}
			}
		}	
		System.out.println(dp[count][s]);
	}
	
}
