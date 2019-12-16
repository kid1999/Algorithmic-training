package LeetCode;

import java.util.*;

/**
 * @auther: kid1999
 * @date: 2019/12/16 10:57
 * @desc: P40
 **/
public class P40 {

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(arr,8));
    }


    private static Set<List<Integer>> set;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        set = new HashSet<>();
        Arrays.sort(candidates);
        dfs(res,new ArrayList<>(),candidates,target,new boolean[candidates.length+1],0);
        return res;
    }
    public static void dfs(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,boolean[] vis,int index){
        if(target == 0){
            Collections.sort(list);
            if(!set.contains(list)){
                set.add(list);
                res.add(list);
            }
            return;
        }
        for (int i = index; i <candidates.length && candidates[i] <= target; i++) {
            if(!vis[i]){
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(candidates[i]);
                vis[i] = true;
                dfs(res,tmp,candidates,target-candidates[i],vis,index+1);
                vis[i] = false;
            }
        }
    }
}
