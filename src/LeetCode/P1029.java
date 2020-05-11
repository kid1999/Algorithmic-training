package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/11 18:50
 **/
public class P1029 {
    public static void main(String[] args) {

    }

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        int res = 0,sum = 0;
        for (int[] num:costs) sum += num[0];
        int[] arr = new int[2*n];
        for (int i = 0; i <2*n ; i++) {
            arr[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(arr);
        for (int i = 0; i <n ; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
