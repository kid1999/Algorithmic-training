package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/8 11:15
 **/
public class P63 {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        if(grid[0][0] == 1) return 0;
        dp[1][1] = 1;
        for (int i = 1; i <=grid.length ; i++) {
            for (int j = 1; j <=grid[0].length ; j++) {
                if(grid[i-1][j-1] == 0) dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
