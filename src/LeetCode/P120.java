package LeetCode;

import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/22 11:05
 **/
public class P120 {
    public static void main(String[] args) {

    }

    // 从上往下dp
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int len = triangle.size();
//        int[][] dp = new int[len+1][len+1];
//        for (int i = 1; i <= len ; i++) {
//            for (int j = 1; j <=i ; j++) {
//                int num = triangle.get(i-1).get(j-1);
//                if(j==1) dp[i][j] = dp[i-1][j] + num;
//                else if(j==i) dp[i][j] = dp[i-1][j-1] + num;
//                else dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + num;
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <=len ; i++) {
//            if(res > dp[len][i]) res = dp[len][i];
//        }
//        return res;
//    }

    // 从下往上 dp
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int len = triangle.size();
//        int[][] dp = new int[len+1][len+1];
//        for (int i = len-1; i >=0 ; i--) {
//            for (int j = i; j >=0 ; j--) {
//                int num = triangle.get(i).get(j);
//                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + num;
//            }
//        }
//        return dp[0][0];
//    }

    // 优化数组空间
    // dp[i][j] =  max(dp[i+1][j],dp[i+1][j+1]) + num
    // 每轮正序覆盖: dp[i] = max(dp[i],dp[i+1]) + num
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len+1];
        for (int i = len-1; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                int num = triangle.get(i).get(j);
                dp[j] = Math.min(dp[j],dp[j+1]) + num;
            }
        }
        return dp[0];
    }
}
