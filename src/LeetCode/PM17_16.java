package LeetCode;

/**
 * @author kid1999
 * @create 2020-11-17 19:47
 * @description TODO
 **/
public class PM17_16 {
    public static void main(String[] args) {

    }

//    public int massage(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n+2];
//        for (int i = 2; i <= n+1 ; i++) {
//            for (int j = 2; j <=i ; j++) {
//                dp[i] = Math.max(dp[i-2]+nums[i-2],dp[i-1]);
//            }
//        }
//        return dp[n+1];
//    }

    public int massage(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = 2; i <= n+1 ; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-2],dp[i-1]);
        }
        return dp[n+1];
    }
}