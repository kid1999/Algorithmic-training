package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/26 10:24
 **/
public class week186 {
    public static void main(String[] args) {
        int[] arr = {11,49,100,20,86,29,72};
        System.out.println(maxScore(arr,4));
    }

    // 1
    public static int maxScore(String s) {
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <chars.length ; i++) {
            int sum = 0;
            for (int j = 0; j <i ; j++) {
                if(chars[j] == '0') sum++;
            }
            for (int j = i; j <chars.length ; j++) {
                if(chars[j] == '1') sum++;
            }
            if(sum > max) max = sum;
        }
        return max;
    }

    // 2
//    public static int maxScore(int[] cardPoints, int k) {
//        int max = Integer.MIN_VALUE;
//        int len = cardPoints.length;
//        if(len <= k) k = len;
//        for (int i = 0; i <=k; i++) {
//            int sum1 = 0,sum2 = 0;
//            if(i != 0){
//                for (int j = 0; j <i; j++) {
//                    sum1 += cardPoints[j];
//                }
//            }
//            if(i!=k){
//                for (int j = 0; j <k-i; j++) {
//                    sum2 += cardPoints[len-j-1];
//                }
//            }
//            if(sum1+sum2 > max) max = sum1+sum2;
//        }
//        return max;
//    }

    public static int maxScore(int[] cardPoints, int k) {
        int max = Integer.MIN_VALUE;
        int len = cardPoints.length;
        int[] pre = new int[len+1];
        int[] next = new int[len+1];

        for (int i = 1; i <=len ; i++) {
            pre[i] = pre[i-1] + cardPoints[i-1];
            next[i] = next[i-1] + cardPoints[len-i];
        }
        int l= 0;int r = k;
        while (l<=k){
            if(pre[l] + next[r] > max) max = pre[l] + next[r];
            l++;
            r--;
        }
        return max;
    }

    // 3
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res = new ArrayList<>();
        int size = nums.size();
        for (int i = 0; i <size; i++) {
            for (int j = 0; j <=i ; j++) {
                if (j<nums.get(i-j).size()) res.add(nums.get(i-j).get(j));
            }
        }
        for (int i = size-1; i >=1 ; i--) {
            for (int j = size-1; j >= size-i ; j--) {
                if(nums.get(j).size() >= size-j) res.add(nums.get(j).get(size-j));
            }
        }
        int[] d = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            d[i] = res.get(i);
        }
        return d;
    }

    // 4

}
