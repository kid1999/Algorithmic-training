package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/1/18 10:16
 **/
public class P448 {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n:nums) {
            int num = Math.abs(n);
            if(nums[num-1]>0) nums[num-1] *= -1;
        }
        for (int i = 1; i <=nums.length ; i++) {
            if(nums[i-1]>0) res.add(i);
        }
        return res;
    }
}
