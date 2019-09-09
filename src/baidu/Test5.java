package baidu;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		int sum = 0;
		long[] nums = new long[100010];
		nums[1] = 1;
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong();
		sc.nextLong();
		for (int i = 2; i <= t; i++) {
			long n = sc.nextLong();
			long pre2 = nums[i-1] * (i-1);
			nums[i] = (sum + pre2) % n;
			sum += pre2;
		}
		for (int i = 1; i <= t ; i++) {
			System.out.println(nums[i]);
		}
	}
}
