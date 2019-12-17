package LeetCode;

import java.util.Arrays;

/**
 * @auther: kid1999
 * @date: 2019/12/18 3:44
 * @desc: P1051
 **/
public class P1051 {

    public int heightChecker(int[] heights) {
        // java 拷贝数组的几种方法

        /**
         * 1. System.arraycopy拷贝数组
         * System.arraycopy(src, srcPos, dest, destPos, length);
         * 源数组,源数组中拷贝的起始位置, 目标数组, 目标数组中开始存放的位置, 拷贝的长度
         */
        int[] temp = new int[heights.length];
        System.arraycopy(heights,0,temp,0,heights.length);
        /**
         * 2. heights.clone();
         * 直接使用clone方法 复制数组
         *  int[] temp = heights.clone();
         */
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i <heights.length ; i++) {
            if(heights[i] != temp[i]) res++;
        }
        return res;
    }
}
