package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/21 11:02
 **/
public class P41 {
    public static void main(String[] args) {

    }

    /**
     * 去除<0和>len的数字 利用 i-1的位置存储i
     * 在遍历找一遍 dp[i-1] == i ?
     *
     * 总结 限制数组的 题 可以从自身给定的 数组想办法
     * @param nums
     * @return
     */

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int temp = 0;
        int len = nums.length;
        for (int i = 0; i <len ; i++) {
            if(nums[i] >0 && nums[i] < len && nums[nums[i]-1] != nums[i]){
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]-1 != i) return i+1;
        }
        return len+1;
    }
}
