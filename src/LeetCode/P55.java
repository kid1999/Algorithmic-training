package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/17 10:11
 **/
public class P55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int len = nums.length-1;
        int max = 0;
        for (int i = 0; i <= len; i++) {
            if (max == len) return true;
            if(i > max) return false;
            if(i + nums[i] > max) max = i + nums[i];
        }
        return true;
    }
}
