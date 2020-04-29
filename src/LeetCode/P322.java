package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/29 10:41
 **/
public class P322 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(coinChange(arr,11));
    }
    // dp 完全背包
//    public static int coinChange(int[] coins, int amount) {
//        int len = coins.length;
//        if(len == 0) return -1;
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
//        for (int i = 0; i <len ; i++) {
//            for (int j = coins[i]; j <=amount ; j++) {
//                if(dp[j-coins[i]] != Integer.MAX_VALUE)
//                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
//            }
//        }
//        if(dp[amount] != Integer.MAX_VALUE) return dp[amount];
//        else return -1;
//    }


    // dfs + 剪枝
    static int res;
    public static int coinChange(int[] coins, int amount) {
        res = Integer.MAX_VALUE;
        Arrays.sort(coins);
        dfs(coins,amount,0,0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void dfs(int[] coins,int amount,int count,int index){
        if(index<0 || count+amount/coins[index] >= res) return;
        if(amount % coins[index] == 0){
            res = Math.min(res,count+amount/coins[index]);
            return;
        }
        for (int i = amount/coins[index]; i >=0 ; i--) {
            dfs(coins,amount-i*coins[index],count+i,index-1);
        }
    }
}
