package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/29 18:26
 **/
public class week16 {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        replaceElements(arr);

    }


    public static int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int len = arr.length-2;
        int max = arr[len+1];
        res[len+1] = -1;
        for (int i = len ; i >=0 ; i--) {
            int newMax = Math.max(arr[i],max);
            res[i] = max;
            max = newMax;
        }
        for (int n: res) System.out.println(n + " ");
        return res;
    }
}
