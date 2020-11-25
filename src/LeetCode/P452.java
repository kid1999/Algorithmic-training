package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kid1999
 * @create 2020-11-23 21:21
 * @description TODO
 **/
public class P452 {
    public static void main(String[] args) {
        
    }


    public int findMinArrowShots(int[][] points) {
        if(points.length < 1) return 0;
        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[1]));
        int res = 0;
        int end = points[0][1];
        for (int i = 0; i < points.length ; i++) {
            if(end < points[i][0]){
                res++;
                end = points[i][1];
            }
        }
        return res;
    }
}