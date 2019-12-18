package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther: kid1999
 * @date: 2019/12/18 16:25
 * @desc: P216
 **/
public class P216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1,k,n,res,new ArrayList<>());
        return res;
    }
    public static void dfs(int last,int k,int sum,List<List<Integer>> res,List<Integer> list){
        if (sum == 0 && k == 0) {
            Collections.sort(list);
            if(!res.contains(list)) res.add(list);
            return;
        }
        if(sum<=0 || k <=0) return;
        for (int i = last; i <=sum && i<=9 ; i++) {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(i);
            dfs(i+1,k-1,sum-i,res,tmp);
        }
    }
}
