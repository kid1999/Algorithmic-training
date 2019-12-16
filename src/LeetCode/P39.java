package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: kid1999
 * @date: 2019/12/16 8:30
 * @desc: P39
 **/
public class P39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    public static void dfs(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int index){
//        if(target < 0) return;
        if(target == 0){
            res.add(list);
            return;
        }
        for (int i = index; i <candidates.length && candidates[i] <= target ; i++) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(candidates[i]);
            dfs(res,tmp,candidates,target-candidates[i],i);
        }
    }
}
