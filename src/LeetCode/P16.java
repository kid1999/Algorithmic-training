package LeetCode;

import java.util.Arrays;

/**
 * @author kid1999
 * @title: P16
 * @date 2019/12/15 21:48
 */

public class P16 {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for (int i = 0; i <nums.length-2 ; i++) {
			int l = i+1;
			int r = nums.length-1;
			while (l<r){
				int sum = nums[i] + nums[l] + nums[r];
				res = Math.abs(target-res) <= Math.abs(target-sum) ? res : sum;
				if(sum < target) l++;
				else if(sum > target) r--;
				else return target;
			}
		}
		return res;
	}
}
