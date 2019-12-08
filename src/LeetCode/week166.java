package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/8 10:24
 **/
public class week166 {

    public static void main(String[] args) {
        double a = 1;
        System.out.println((int)Math.ceil((a / 5)));
    }

    // 1
    public int subtractProductAndSum(int n) {
        String s = String.valueOf(n);
        int a = 0;
        int b = 1;
        for (char c:s.toCharArray()) {
            a += c - '0';
            b *= c - '0';
        }
        return b - a;
    }

    // 2

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] vis = new boolean[groupSizes.length];
        for (int i = 0; i <groupSizes.length ; i++) {
            if(vis[i]) continue;
            int size = groupSizes[i];
            List<Integer> tmp = new LinkedList<>();
            for (int j = i; j < groupSizes.length; j++) {
                if(groupSizes[j] == size && !vis[j]){
                    tmp.add(j);
                    vis[j] = true;
                }
                if(tmp.size() == size){
                    res.add(tmp);
                    break;
                }
            }
        }
        return res;
     }
    // 3
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1,r = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            r = Math.max(r,nums[i]);
        }
        System.out.println(l + " " + r);
        while (l<r){
            int mid = l+r>>1;
            System.out.println(check(mid,nums));
            if(check(mid,nums) <= threshold) r = mid;
            else l = mid+1;
        }
        return l;
    }
    public static int check(int n,int[] nums){
        int res = 0;
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i] / (double)n);
            res += Math.ceil((nums[i] /  (double)n));
        }
        return res;
    }

    //4
    public int minFlips(int[][] mat) {
        int UNKNOW = 0;
        return UNKNOW;
    }

}
