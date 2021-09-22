package LeetCode;

/**
 * @author kid1999
 * @create 2021-02-07 9:05
 * @description TODO
 **/
public class P665 {
    public static void main(String[] args) {

    }

    public boolean checkPossibility(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1 && res < 2; i++) {
            if (nums[i] > nums[i + 1]) {
                res++;
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }
        return res < 2;
    }
}