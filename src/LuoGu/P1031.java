package LuoGu;

import java.util.Scanner;

public class P1031 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n];
		int sum = 0;
		for (int i = 0; i <n ; i++) {
			dp[i] = sc.nextInt();
			sum += dp[i];
		}
		sum /= n;
		int count = 0,res = 0;
		for (int i = 0; i < n ; i++) {
			int tmp = count + dp[i] - sum;
			if(tmp != 0) res++;		// 只能往后移动如果不能直接把后一个数变成0 就需要继续移动
			count = tmp;
		}
		System.out.println(res);
	}
}
