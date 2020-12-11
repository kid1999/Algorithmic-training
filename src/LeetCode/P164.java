package LeetCode;

import java.util.Arrays;

/**
 * @author kid1999
 * @create 2020-11-26 11:20
 * @description TODO
 **/
public class P164 {
    public static void main(String[] args) {

    }

    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int temp=0;
        int res=0;
        if(nums.length<2) return 0;
        for(int i=0;i<nums.length-1;i++){
            temp=nums[i+1]-nums[i];
            res=Math.max(res,temp);
        }
        return res;
    }
}