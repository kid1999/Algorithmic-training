package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/1/18 10:04
 **/
public class P442 {
    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n:nums) {
            int num = Math.abs(n);
            if(nums[num-1] > 0) nums[num-1] *= -1;
            else res.add(num);
        }
        return res;
    }
}
