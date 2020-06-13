package LeetCode;

import java.util.HashMap;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/13 22:21
 **/
public class week28 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,1,1,5,1,2,1};
        System.out.println(minSumOfLengths(arr,3));
    }

    // 1
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i <prices.length ; i++) {
            res[i] = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] <= prices[i]){
                    res[i] = prices[i]-prices[j];
                    break;
                }
            }
        }
        return res;
    }

    // 2

    // 3  [3,2,2,4,3]
    public static int minSumOfLengths(int[] arr, int target) {
        int l = 0;
        int sum = 0;
        int len1=Integer.MAX_VALUE,len2 = Integer.MAX_VALUE;
        for (int r = 0; r <arr.length ; r++) {
            sum += arr[r];
            while (target < sum && l<=r){
                sum -= arr[l++];
            }
            if (sum == target){
                if(len1>=len2) len1 = Math.min(len1,r-l+1);
                else len2 = Math.min(len2,r-l+1);
                sum = 0;
                l = r+1;
            }
        }
        if(len1==Integer.MAX_VALUE || len2==Integer.MAX_VALUE) return -1;
        else return len1+len2;
    }
    // 4
//    public int minDistance(int[] houses, int k) {
//
//    }
}
