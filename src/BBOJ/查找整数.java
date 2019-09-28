package BBOJ;

import java.util.Scanner;

public class 查找整数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n];
		for (int i = 0; i <n ; i++) {
			dp[i] = sc.nextInt();
		}
		int num = sc.nextInt();
		for (int i = 0; i <n ; i++) {
			if (num == dp[i]){
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("-1");
	}
}
