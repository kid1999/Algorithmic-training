package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/23 21:57
 **/
public class P198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        for (int i = 2; i <=nums.length+1 ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-2]);
        }
        return dp[nums.length+1];
    }
}
