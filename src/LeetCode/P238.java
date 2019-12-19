package LeetCode;

/**
 * @auther: kid1999
 * @date: 2019/12/19 16:43
 * @desc: P238
 **/
public class P238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len+1];
        int[] right = new int[len+1];
        left[0] = nums[0];
        right[len-1] = nums[len-1];
        for (int i = 1; i <len ; i++) {
            left[i] = nums[i]*left[i-1];
            right[len-i-1] = nums[len-i-1]*right[len-i];
        }
        nums[0] = right[1];
        nums[len-1] = left[len-2];
        for (int i = 1; i <len-1 ; i++) {
            nums[i] = left[i-1] * right[i+1];
        }
        return nums;
    }
}
