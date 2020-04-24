package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/24 11:12
 **/
public class P188 {
    public static void main(String[] args) {

    }

    // 初始版
//    public int maxProfit(int k, int[] prices) {
//        int len = prices.length;
//        int[][][] dp = new int[len+1][k+1][2];
//        for (int j = 0; j <=k ; j++) {
//            dp[0][j][1] = Integer.MIN_VALUE;
//        }
//
//        for (int i = 1; i <=len ; i++) {
//            for (int j = 1; j <=k ; j++) {
//                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
//                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
//            }
//        }
//        return dp[len][k][0];
//    }

    // 1.dp状态
    // 2.状态转移
    // 3.初始化状态
    // 4.可选 优化数组 复写
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k>=len/2) return func(prices);
        int[][] dp = new int[k+1][2];
        for (int j = 0; j <=k ; j++) {
            dp[0][1] = Integer.MIN_VALUE;
        }

        for (int p:prices) {
            for (int j = 1; j <=k ; j++) {
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]-p);
                dp[j][0] = Math.max(dp[j][0],dp[j][1]+p);
            }
        }
        return dp[k][0];
    }

    // 退化为任意次 买卖
    private int func(int[] prices) {
        int res = 0;
        int last = Integer.MAX_VALUE;
        for (int i = 0; i <prices.length ; i++) {
            if(prices[i]-last>0) res += prices[i]-last;
            last = prices[i];
        }
        return res;
    }
}
