package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/4 9:12
 **/
public class P45 {
    // dp  超时
//    public int jump(int[] nums) {
//        int len = nums.length;
//        int[] f = new int[len];
//        Arrays.fill(f,Integer.MAX_VALUE);
//        f[0] = 1;
//        for (int i = 0; i <len ; i++) {
//            for (int j = 0; j <i ; j++) {
//                if(nums[j] + j >= i ) f[i] = Math.min(f[i],f[j]+1);
//            }
//        }
//        for (int i = 0; i <len ; i++) {
//            System.out.println(f[i]);
//        }
//        return f[len-1];
//    }

    // dijkstra 变形
    public int jump(int[] nums) {
        int steps = 0;
        int start = 0;
        int end = 0;
        while (end<nums.length-1){
            int max = end;
            for (int i = start; i <=end ; i++) {
                if(nums[i]+i>max) max = nums[i]+i;
            }
            start = end+1;
            end = max;
            steps++;
        }
        return steps;
    }
}
