package LeetCode;

import java.util.Arrays;

/**
 * @auther: kid1999
 * @date: 2019/12/18 4:07
 * @desc: P977
 **/
public class P977 {
    public int[] sortedSquares(int[] A) {
        int l = 0, r = A.length-1,index = A.length-1;
        int[] res = new int[A.length];
        while (index >= 0) {
            if (Math.abs(A[l]) >= Math.abs(A[r]))  res[index--] = A[l]*A[l++];
            else res[index--] = A[r]*A[r--];
        }
        return res;
    }
}
