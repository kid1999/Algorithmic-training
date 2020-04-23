package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/23 9:49
 **/
public class P53 {
    public static void main(String[] args) {

    }

    // dp
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(0,dp[i-1]) + nums[i-1];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }

    // 贪心
//    public int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int sum = 0;
//        for(int n :nums){
//            if(sum >= 0) sum += n;
//            else sum = n;
//            if(sum > max) max = sum;
//        }
//        return max;
//    }
}
