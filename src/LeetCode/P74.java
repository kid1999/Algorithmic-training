package LeetCode;

/**
 * @author kid1999
 * @title: P74
 * @date 2020/5/29 17:38
 */

public class P74 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int x=0;
		int x_len = matrix.length;
		if(x_len == 0) return false;
		int y_len = matrix[0].length;
		if(y_len == 0 || target < matrix[0][0] || target > matrix[x_len-1][y_len-1]) return false;
		for (int i = 0; i <x_len; i++) {
			if(target >= matrix[i][0] && target <= matrix[i][y_len-1]){
				x = i;break;
			}
		}
		for (int i = 0; i <y_len ; i++) {
			if(target == matrix[x][i]) return true;
		}
		return false;
	}
}
