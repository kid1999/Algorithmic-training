package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/19 10:32
 **/
public class P131 {
    public static void main(String[] args) {
        P131 p = new P131();
        System.out.println(p.partition("aab"));
    }

    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        dfs(s,new LinkedList<>());
        return res;
    }

    void dfs(String s,List<String> tmp){
        if(s.equals("")){
            res.add(tmp);
            return;
        }
        for (int i = 1; i <=s.length() ; i++) {
            String str = s.substring(0,i);
            if(check(str)){
                List<String> newtmp = new LinkedList<>(tmp);
                newtmp.add(str);
                dfs(s.substring(i),newtmp);
            }
        }
    }
    boolean check(String s){
        int l = 0, r = s.length()-1;
        while (l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }

}
