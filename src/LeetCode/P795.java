package LeetCode;

import java.util.PriorityQueue;

/**
 * @author kid1999
 * @title: P795
 * @date 2020/5/27 11:25
 */

public class P795 {
	public static void main(String[] args) {
		int[] arr = {2,1,4,3};
		System.out.println(numSubarrayBoundedMax(arr,2,3));
	}

	// 大于的 - 小于的 就是满足条件的
	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
		return count(A, R) - count(A, L-1);
	}

	public static int count(int[] A, int bound) {
		int ans = 0, cur = 0;
		for (int x: A) {
			cur = x <= bound ? cur + 1 : 0;
			ans += cur;
		}
		return ans;
	}

}
