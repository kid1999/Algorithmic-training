package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/25 9:50
 **/
public class P309 {
    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int[][] dp = new int[len+2][4];
        for (int i = 0; i <4 ; i++){
            dp[0][i] = Integer.MIN_VALUE;
            dp[1][i] = Integer.MIN_VALUE;
        }
        dp[1][2] = 0;
        for (int i = 2; i <=len+1 ; i++) {
            int p = prices[i-2];
            dp[i][0] = Math.max(dp[i-1][2],dp[i-2][1])-p;   // 买
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][3])+p;   // 卖
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);     // 持币观望
            dp[i][3] = Math.max(dp[i-1][0],dp[i-1][3]);     // 持票观望
        }
        return Math.max(dp[len+1][1],dp[len+1][2]);
    }
}
