package LeetCode;

/**
 * @author kid1999
 * @create 2021-02-17 9:48
 * @description TODO
 **/
public class P566 {
    public static void main(String[] args) {

    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int len = nums[0].length * nums.length;
        if(len != r*c) return nums;
        int[][] res = new int[r][c];
        int x = nums[0].length;
        for (int j = 0; j < len ; j++) {
            res[j/c][j%c] = nums[j/x][j%x];
        }
        return res;
    }
}