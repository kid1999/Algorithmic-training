package LeetCode;

import java.util.*;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/28 18:52
 **/
public class PM16_24 {
    public static void main(String[] args) {

    }

//    public List<List<Integer>> pairSums(int[] nums, int target) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        List<List<Integer>> res = new ArrayList<>();
//        for (int n:nums) {
//            if(map.containsKey(target-n) && map.get(target-n) >= 1){
//                map.put(target-n,map.get(target-n)-1);
//                List<Integer> list = new ArrayList<>();
//                list.add(target-n);
//                list.add(n);
//                res.add(list);
//            }else {
//                map.put(n,map.getOrDefault(n,0)+1);
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        while (l<r){
            if(nums[l] + nums[r] == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                res.add(list);
                l++; r--;
            }else if(nums[l] + nums[r] > target){
                r--;
            }else {
                l++;
            }
        }
        return res;
    }
}
