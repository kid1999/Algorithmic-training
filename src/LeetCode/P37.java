package LeetCode;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/15 19:25
 * @title P37
 */

public class P37 {
	public static void main(String[] args) {
		char[][] b = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		P37 p = new P37();
		p.solveSudoku(b);
	}

//	boolean[][] cols,rows;
//	boolean[][][] block;
//	int n = 9;
//	public void solveSudoku(char[][] board) {
//		rows = new boolean[n][10];       // 行
//		cols = new boolean[n][10];       // 列
//		block = new boolean[3][3][10];
//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < n; j++) {
//				int num = board[i][j] - '0';
//				if(1 <= num && num <= 9){
//					rows[i][num] = true;
//					cols[j][num] = true;
//					block[i/3][j/3][num] = true;
//				}
//			}
//		}
//		dfs(board,0,0);
//		System.out.println(Arrays.deepToString(board));
//	}
//	private boolean dfs(char[][] d,int i,int j){
//		System.out.println(i + " " + j);
//		if(j>=n){ i++; j=0; }
//		if(i>=n) return true;
//		if(d[i][j] == '.'){
//			for (int m = 1; m <=n ; m++) {
//				boolean canUse = !(cols[j][m] || rows[i][m] || block[i/3][j/3][m]);
//				if(canUse){
//					rows[i][m] = true;
//					cols[j][m] = true;
//					block[i/3][j/3][m] = true;
//					d[i][j] = (char)(m + '0');
//
//					if(dfs(d,i,j+1)) return true;
//
//					d[i][j] = '.';
//					rows[i][m] = false;
//					cols[j][m] = false;
//					block[i/3][j/3][m] = false;
//				}
//			}
//		}else dfs(d,i,j+1);
//		return false;
//	}


	// 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
	boolean[][] rowUsed,colUsed;
	boolean[][][] boxUsed;
	int n = 9;
	public void solveSudoku(char[][] board) {
		rowUsed = new boolean[n][10];
		colUsed = new boolean[n][10];
		boxUsed = new boolean[n][3][10];
		// 初始化
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++) {
				int num = board[row][col] - '0';
				if(1 <= num && num <= 9){
					rowUsed[row][num] = true;
					colUsed[col][num] = true;
					boxUsed[row/3][col/3][num] = true;
				}
			}
		}
		// 递归尝试填充数组
		dfs(board, 0, 0);
		System.out.println(Arrays.deepToString(board));
	}

	private boolean dfs(char[][]board, int row, int col){
		// 边界校验, 如果已经填充完成, 返回true, 表示一切结束
		if(col == n){
			col = 0;
			row++;
		}
		if(row >= n)return true;
		// 是空则尝试填充, 否则跳过继续尝试填充下一个位置
		if(board[row][col] == '.') {
			// 尝试填充1~9
			for(int num = 1; num <= 9; num++){
				boolean canUsed = !(rowUsed[row][num] || colUsed[col][num] || boxUsed[row/3][col/3][num]);
				if(canUsed){
					rowUsed[row][num] = true;
					colUsed[col][num] = true;
					boxUsed[row/3][col/3][num] = true;

					board[row][col] = (char)('0' + num);
					if(dfs(board, row, col + 1)) return true;
					board[row][col] = '.';

					rowUsed[row][num] = false;
					colUsed[col][num] = false;
					boxUsed[row/3][col/3][num] = false;
				}
			}
		} else {
			return dfs(board, row, col + 1);
		}
		return false;
	}
}
