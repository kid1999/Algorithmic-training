package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/25 8:58
 **/
public class P46 {
    public static void main(String[] args) {

    }

    /**回溯模板
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */

    static List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    public static void dfs(int[] nums,List<Integer> tmp,boolean[] visd){
        if(tmp.size()== nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(visd[i]) continue;
            visd[i] = true;
            tmp.add(nums[i]);
            dfs(nums,tmp,visd);
            visd[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
