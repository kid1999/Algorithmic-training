package LeetCode;

/**
 * @author kid1999
 * @title: P4
 * @date 2020/1/3 21:52
 */

public class P4 {
	public static void main(String[] args) {
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len = nums1.length + nums2.length;
		int[] nums = new int[len];
		int cur = 0,l = 0,r = 0;
		while (l<nums1.length || r < nums2.length){
			if(nums1[l] >= nums2[r]){
				nums[cur++] = nums2[r++];
			}else {
				nums[cur++] = nums1[l++];
			}
		}
		while (l < nums1.length) nums[cur++] = nums1[l++];
		while (r < nums2.length) nums[cur++] = nums2[r++];
		if(len %2 == 0){
			return (nums[len/2-1] + nums[len/2]) / 2.0;
		}
		return nums[len/2];
	}
}
