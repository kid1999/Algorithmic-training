package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kid1999
 * @date 2020/8/31 17:31
 * @desc
 **/
public class P228 {
    public static void main(String[] args) {

    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int l = 0;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i]+1 != nums[i+1]){
                if(i == l) res.add(""+nums[i]);
                else res.add(nums[l] + "->" + nums[i]);
                l = i+1;
            }
        }
        if(l == nums.length-1) res.add(""+nums[l]);
        else res.add(nums[l] + "->" + nums[nums.length-1]);
        return res;
    }
}
