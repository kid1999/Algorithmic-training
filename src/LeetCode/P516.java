package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/27 9:15
 **/
public class P516 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aaabb"));
    }

    // dp
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = len-1; i >=0; i--) dp[i][i] = 1;    //base case
        for (int i = len-1; i >=0; i--) {
            for (int j = i+1; j <len ; j++) {
                if(chars[i] == chars[j]) dp[i][j] = dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }


}
