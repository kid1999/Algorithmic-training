package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/28 10:33
 **/
public class P416 {

    // dp 转化为 01背包
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        int sum = 0;
        for (int n:nums) sum += n;
        if(sum %2 == 1) return false;
        int weight = sum/2;
        boolean[] dp = new boolean[weight+1];
        for (int i = 0; i <=weight; i++) dp[i] = nums[0] == i;  // base case
        for (int i = 1; i <nums.length ; i++) {
            for (int j = weight; j >= nums[i] ; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[weight];
    }
}
