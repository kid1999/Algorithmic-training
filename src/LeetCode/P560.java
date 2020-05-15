package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/15 8:39
 **/
public class P560 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int res = 0,sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int n:nums) {
            sum += n;
            // sum1 - sum2 = k
            if(map.containsKey(sum-k)) res += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }

}
