package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/22 10:38
 **/
public class P1143 {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] +1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}
