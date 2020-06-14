package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/13 22:21
 **/
public class week28 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,1};
        System.out.println(minSumOfLengths(arr,7));
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

    // 3  [1 6 1]
    public static int minSumOfLengths(int[] arr, int target) {
        int l=0,r=0;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while (r<arr.length){
            sum += arr[r];
            while (l<=r &&sum >= target){
                if(sum == target) list.add(new int[]{l,r,r-l});
                sum -= arr[l++];
            }
            r++;
        }
        if(list.size()<2) return -1;
        list.sort((o1,o2)->{
            return o1[2] - o2[2];
        });
        for (int[] a:list) {
            for (int[] b:list) {
                if(a[1] < b[0] ||b[1] < a[0])
                    return a[1]-a[0] + b[1]-b[0] + 2;
            }
        }
        return -1;
    }
    // 4
//    public int minDistance(int[] houses, int k) {
//
//    }
}
