package LeetCode;

import java.util.Arrays;

/**
 * @author kid1999
 * @create 2020-11-17 20:10
 * @description TODO
 **/
public class P1641 {
    public static void main(String[] args) {

    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        Arrays.fill(dp[0],1);
        for (int i = 1; i <=n ; i++) {
            int sum = 0;
            for (int j = 0; j <5 ; j++) {
                sum += dp[i-1][j];
                dp[i][j] = sum;
            }
        }
        return dp[n][4];
    }
}