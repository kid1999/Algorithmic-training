package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/11 11:08
 **/
public class P329 {
    public static void main(String[] args) {

    }

    // dfs + 记忆化
//    static int[] func;
//    static int[][] vis;
//    public int longestIncreasingPath(int[][] matrix) {
//        func = new int[]{0,1,0,-1,1,0,-1,0};
//        vis = new int[matrix.length+1][matrix[0].length+1];
//        for (int i = 0; i <vis.length ; i++) Arrays.fill(vis[i],-1);
//        int max = 0;
//        for (int i = 0; i <matrix.length ; i++) {
//            for (int j = 0; j <matrix[0].length ; j++) {
//                max = Math.max(dfs(matrix,i,j,matrix[i][j]),max);
//            }
//        }
//        return max;
//    }
//    public static int dfs(int[][] matrix,int i,int j,int last){
//        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length) return 0;
//        if(matrix[i][j] > last) return 1;
//        if(vis[i][j] != -1) return vis[i][j];
//        vis[i][j] = 0;
//        for (int k = 0; k <4 ; k++) {
//            vis[i][j] = Math.max(dfs(matrix,i+func[2*k],j+func[2*k+1],matrix[i][j]),vis[i][j]);
//        }
//        return vis[i][j];
//    }

    // dp 不行 不知道开始和结束的地方
//    public int longestIncreasingPath(int[][] matrix) {
//        int n = matrix.length,m = matrix[0].length;
//        int[] func = new int[]{0,1,0,-1,1,0,-1,0};
//        int[][] dp = new int[n+2][m+2];
//        int max = 0;
//        for (int i = 1; i <=n ; i++) {
//            for (int j = 1; j <=m ; j++) {
//                for (int k = 0; k <4 ; k++) {
//                    int x = i+func[2*k], y = j+func[2*k+1];
//                    if(x<=0||x>n||y<=0||y>m||matrix[i-1][j-1] > matrix[x-1][y-1]){
//                        dp[i][j] = Math.max(dp[i][j],dp[x][y]+1);
//                        max = Math.max(max,dp[i][j]);
//                    }
//                }
//            }
//        }
//        return max;
//    }
}
