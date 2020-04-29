package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/29 11:43
 **/
public class P518 {
    public static void main(String[] args) {

    }


    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount+1];
        for (int i = 0; i <len ; i++) {
            for (int j = 1; j <=amount ; j++) {
                dp[j] = dp[j] + dp[j-coins[i]] + 1;
            }
        }
        return dp[amount];
    }
}
