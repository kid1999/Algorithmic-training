package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/17 10:26
 **/
public class P0107 {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        // 1 对角变换
        int len = matrix.length;
        for (int i = 0; i <len ; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 2 y轴对称变换
        int mid = len / 2;
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j <mid ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = tmp;
            }
        }
    }
}
