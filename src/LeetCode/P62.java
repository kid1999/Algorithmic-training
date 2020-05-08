package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/8 11:08
 **/
public class P62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
