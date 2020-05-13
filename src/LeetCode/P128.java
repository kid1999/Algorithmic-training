package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/13 9:03
 **/
public class P128 {
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }
        int max = 0;
        for (int num:nums) {
            if(set.remove(num)){
                int cur = num;
                int len = 1;
                while (set.remove(cur-1)) cur--;
                len += num-cur;

                cur = num;
                while (set.remove(cur+1)) cur++;
                len += cur-num;

                max = Math.max(max,len);
            }
        }
        return max;
    }
}
