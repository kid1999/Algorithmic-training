package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/6 9:08
 **/
public class P983 {
    public static void main(String[] args) {

    }
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] f = new int[lastDay+1];
        Arrays.fill(f,999999);
        f[0] = 0;
        int index = 0;
        for (int j = 1; j <=lastDay ; j++) {
            if (days[index] == j) {
                f[j] = Math.min(f[j], f[j - 1] + costs[0]);
                if (j - 7 >= 0) f[j] = Math.min(f[j], f[j - 7] + costs[1]);
                else f[j] = Math.min(f[j], f[0] + costs[1]);
                if (j - 30 >= 0) f[j] = Math.min(f[j], f[j - 30] + costs[2]);
                else f[j] = Math.min(f[j], f[0] + costs[2]);
                index++;
            } else {
                f[j] = f[j - 1];
            }
        }
        return f[lastDay];
    }
}
