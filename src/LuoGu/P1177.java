package LuoGu;

import java.util.Scanner;

public class P1177 {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		 dp = new int[n];
		for (int i = 0; i <n; i++) {
			dp[i] = sc.nextInt();
		}
		quick_sort(0,n-1);
		for (int i = 0; i <n-1 ; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println(dp[n-1]);

	}
	public static void quick_sort(int l, int r){
		if(l>=r) return;
		int m = dp[l+r>>1],left = l-1,right = r+1;
		while (left<right){
			do left++; while (dp[left] < m);
			do right--; while (dp[right] > m);
			if(left<right){
				int tmp = dp[left];
				dp[left] = dp[right];
				dp[right] = tmp;
			}
		}
		quick_sort(l,right);
		quick_sort(right+1,r);
	}
}
