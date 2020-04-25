package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/25 10:39
 **/
public class P714 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(arr,2));
    }
//    朴素版本
//    public static int maxProfit(int[] prices, int fee) {
//        int len = prices.length;
//        int[][] dp = new int[len+1][4];
//        dp[0][0] = -100000;
//        dp[0][1] = -100000;
//        dp[0][3] = -100000;
//        for (int i = 1; i <=len ; i++) {
//            int price = prices[i-1];
//            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2])-price-fee;   // 买
//            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][3])+price;   // 卖
//            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);   // 持币
//            dp[i][3] = Math.max(dp[i-1][0],dp[i-1][3]);   // 持票
//        }
//        return Math.max(dp[len][1],dp[len][2]);
//    }

    // 优化 直接优化为 买 卖
    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int sell = 0;
        int buy = -prices[0]-fee;
        for (int i = 0; i <len ; i++) {
            buy = Math.max(buy,sell-prices[i]);
            sell = Math.max(sell,buy+prices[i]-fee);
        }
        return sell;
    }
}
