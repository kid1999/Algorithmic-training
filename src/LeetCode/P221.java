package LeetCode;

/**
 * @author kid1999
 * @title: P221
 * @date 2020/1/4 10:08
 */

public class P221 {
	public static void main(String[] args) {
		String[][] arr = {{"0","0","0","1","0","1","1","1"},
						{"0","1","1","0","0","1","0","1"},
						{"1","0","1","1","1","1","0","1"},
						{"0","0","0","1","0","0","0","0"},
						{"0","0","1","0","0","0","1","0"},
						{"1","1","1","0","0","1","1","1"},
						{"1","0","0","1","1","0","0","1"},
						{"0","1","0","0","1","1","0","0"},
						{"1","0","0","1","0","0","0","0"}};

	}

	// dfs 暴力
//	private static int max;
//	public int maximalSquare(char[][] matrix) {
//		max = 0;
//		for (int i = 0; i <matrix.length ; i++) {
//			for (int j = 0; j <matrix[0].length ; j++) {
//				if (matrix[i][j] == '1'){
//					if (1 > max) max = 1;
//					dfs(i,j,matrix,1);
//				}
//			}
//		}
//		return max * max;
//	}
//
//	public static void dfs(int i,int j,char[][] matrix,int len){
//		while (i+len<matrix.length && j+len<matrix[0].length){
//			for (int k = 0; k <=len ; k++) {
//				if(matrix[i+len][j+k] == '0') return;
//				if(matrix[i+k][j+len] == '0') return;
//			}
//			len++;
//			if (len > max) max = len;
//		}
//	}


	// 动态规划
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		if(matrix.length < 1) return 0;
		int[][] dp = new int[matrix.length+1][matrix[0].length+1];
		for (int i = 1; i <=matrix.length ; i++) {
			for (int j = 1; j <=matrix[0].length ; j++) {
				if(matrix[i-1][j-1] == '1'){
					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
					max = Math.max(max,dp[i][j]);
				}
			}
		}
		return max*max;
	}
}
