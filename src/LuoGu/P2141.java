package LuoGu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P2141 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
			set.add(nums[i]);
		}
		int res = 0;
		for (int i = 0; i <n-1 ; i++) {
			for (int j = i+1; j <n ; j++) {
				int sum = nums[i] + nums[j];
				if(sum != nums[i] && sum != nums[j] && set.contains(sum)){
					set.remove(sum);
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
