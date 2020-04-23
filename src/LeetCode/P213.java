package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/23 22:08
 **/
public class P213 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp1 = new int[len+2];
        if(len == 1) return nums[0];
        for (int i = 2; i <=len ; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i-2]);
        }

        int[] dp2 = new int[len+2];
        for (int i = 3; i <=len+1 ; i++) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i-2]);
        }

        return Math.max(dp1[len],dp2[len+1]);
    }
}
