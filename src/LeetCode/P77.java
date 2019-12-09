package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther: kid1999
 * @date: 2019/12/6 10:44
 * @desc: P77
 **/
public class P77 {
    public static void main(String[] args) {
        combine(4,2);
    }

    private static List<List<Integer>> res = new ArrayList<>(0);
    private static int count,r;
    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        res = new LinkedList<>();
        count = k;
        r = n;
        dfs(1,new LinkedList<>());
        return res;
    }
    public static void  dfs(int left,List<Integer> temp){
        if(temp.size() == count){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = left; i <=r - (count - temp.size()) + 1 ; i++) {
            temp.add(i);
            dfs(i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
