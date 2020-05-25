package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kid1999
 * @title: P18
 * @date 2020/5/25 14:30
 *
 * 四数之和 思路：
 *
 * 1.先排序，这样在最后两数相加时可用二分且利于去重
 *
 * 2.for一层，n-1个数之和 = target - nums[i]
 *
 * 2.for一层，n-2个数之和 = n-1个数之和 - nums[j]
 *
 * ......重复消减变量
 *
 * 3.双指针选出最后两个数之和满足的
 *
 * 4.复杂度:太高了.....
 *
 * 注意事项： 除掉 nums[i] == nums[i-1] 重复的答案
 */

public class P18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length == 0) return res;
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			if(i>0 && nums[i] == nums[i-1]) continue;   //去重
			int newSum3 = target - nums[i];

			for(int j=i+1;j<nums.length;j++){
				if(j>i+1 && nums[j] == nums[j-1]) continue;   //去重
				int newSum2 = newSum3 - nums[j];
				int l=j+1,r=nums.length-1;
				while(l<r){
					if(nums[l]+nums[r] == newSum2){
						List<Integer> tmp = new ArrayList<>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[l]);
						tmp.add(nums[r]);
						res.add(tmp);
						while(l<r && nums[l] == nums[l+1]) l++;     //去重
						while(l<r && nums[r] == nums[r-1]) r--;
						l++;r--;
					}else if(nums[l]+nums[r] < newSum2) l++;
					else r--;
				}
			}
		}
		return res;
	}

}
