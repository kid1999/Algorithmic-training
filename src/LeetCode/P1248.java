package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/21 9:20
 **/
public class P1248 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(arr,2));
    }

    // 滑动窗口的极限 https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/java-hua-dong-chuang-kou-xiang-jie-zhi-xing-yong-s/
    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0,count = 0,len = nums.length;
        int[] dp = new int[len+2];
        for (int i = 0; i <len ; i++) {
            if((nums[i] & 1) == 1) dp[++count] = i;
        }
        dp[0] = -1;
        dp[count+1] = len;
        for (int i = 1; i+k < count+2; i++) {
            res += (dp[i]-dp[i-1])*(dp[i+k]-dp[i+k-1]);
        }
        return res;
    }
}
