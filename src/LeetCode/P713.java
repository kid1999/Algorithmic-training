package LeetCode;

/**
 * @author kid1999
 * @title: P713
 * @date 2020/5/27 11:00
 */

public class P713 {
	// 类似前缀和的前缀积。
	// 前缀和是正负波动的，但是这个是递增的，所以不能用存储而是用指针
	// 求小于区间直接用左指针压缩区间
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if(k<=1) return 0;
		int res = 0,sum = 1,l = 0;
		for (int r = 0; r <nums.length ; r++) {
			sum *= nums[r];
			while (sum >= k){
				sum /= nums[l];
				l++;
			}
			res += (r-l+1);
		}
		return res;
	}

}
