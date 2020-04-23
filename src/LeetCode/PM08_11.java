package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/23 8:14
 **/
public class PM08_11 {
    public static void main(String[] args) {
        System.out.println(waysToChange(61));
    }

    // 完全背包
//    public static int waysToChange(int n) {
//        int[][] dp  = new int[5][n+1];
//        int[] weight = {0,1,5,10,25};
//        dp[0][0] = 1;
//        Arrays.fill(dp[1],1);
//        for (int i = 2; i <= 4; i++) {       // 物品体积
//            for (int j = 1; j <=n ; j++) {  // 剩余容量
//                if(weight[i] > j) dp[i][j] = dp[i-1][j];
//                else {
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-weight[i]];
//                }
//            }
//        }
//        return dp[4][n];
//    }

    // 一维数组优化版
    public static int waysToChange(int n) {
        int[] dp  = new int[n+1];
        dp[0] = 1;
        int[] weight = {1,5,10,25};
        for (int i = 0; i < 4; i++) {       // 物品体积
            for (int j = weight[i]; j <=n ; j++) {  // 剩余容量
                dp[j] = (dp[j] + dp[j-weight[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
