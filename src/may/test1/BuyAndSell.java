package may.test1;

public class BuyAndSell {
  public static void main(String[] args) {
      int k = 2;
//      int[] prices = {3,2,6,5,0,3};
    int[] prices = {3,3,5,0,0,3,1,4};
    System.out.println(maxProfit(k,prices));
  }

  // i 天 还有 k 次交易机会 是否拥有股票 0/1
  public static int maxProfit(int k, int[] prices) {
    if (prices.length < 2) return 0;
    // 初始化第一天
    int[][][] dp = new int[prices.length+1][k+1][2];
    dp[0][k][0] = 0;
    dp[0][k][1] = -99999;
    for (int i = 0; i < k; i++) {
      dp[0][i][0] = -99999;
      dp[0][i][1] = -99999;
    }


    for (int i = 1; i <=prices.length ; i++) {
      for (int j = k; j>=0; j--) {
        int v1 = dp[i-1][j][0]; // 不买
        int v2,v4;
        if(j+1>k){
          v2 = dp[i-1][k][0] - prices[i-1]; // 非法买（指剩余买卖次数与当前操作不合）
          v4 = dp[i-1][k][1] + prices[i-1]; // 非法卖
        }else{
          v2 = dp[i-1][j+1][0] - prices[i-1]; // 买
          v4 = dp[i-1][j+1][1] + prices[i-1]; //卖
        }
        int v3 = dp[i-1][j][1]; //不卖


        System.out.println(i + "天" + "剩余" + j +"次机会" +"   当前无股票   "+ v1+"(昨天没买)" + " " + v4 +"(今天才卖)"+"  |   当前有股票     " + v2 +"(今天才买)"+ " " + v3+"(昨天已买)");
        dp[i][j][0] = Math.max(v1,v4);
        dp[i][j][1] = Math.max(v2,v3);
      }
    }
    return dp[prices.length][0][0];
  }
}
