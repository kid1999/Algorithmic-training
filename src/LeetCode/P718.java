package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/7/1 14:23
 **/
public class P718 {
    public static void main(String[] args) {

    }

    // 暴力
//    public int findLength(int[] A, int[] B) {
//        int max = 0;
//        for (int i = 0; i < A.length; i++) {
//            int start = i;
//            for (int j = 0; j <B.length ; j++) {
//                int count = 0;
//                int end = j;
//                while (start < A.length && end<B.length && A[start] == B[end]){
//                    count++;
//                    start++;
//                    end++;
//                }
//                max = Math.max(max,count);
//                start = i;
//            }
//        }
//        return max;
//    }

    // DP
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }


}
