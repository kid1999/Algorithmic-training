package LeetCode;

/**
 * @author kid1999
 * @title P80
 * @date 2020/9/7 18:59
 */

public class P80 {
	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i-2])
				nums[i++] = n;
		return i;
	}
}
