package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/21 20:49
 **/
public class P300 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j <i ; j++) {
                if(nums[j] < nums[i] && dp[j] > count) count = dp[j];
            }
            dp[i] = count + 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
