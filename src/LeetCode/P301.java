package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/23 12:28
 **/
public class P301 {

    // 应用版BFS
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        set.add(s);
        while(true){
            for(String str : set){
                if(check(str)) res.add(str);
            }
            if(res.size() > 0) return res;
            HashSet<String> nextSet = new HashSet<>();
            for(String str:set){
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i) == '(' || str.charAt(i) == ')')
                        nextSet.add(str.substring(0,i) + str.substring(i+1,str.length()) );  // 删除一个括号
                }
            }
            set = nextSet;
        }

    }
    Boolean check(String s){
        int count = 0;
        for(char c:s.toCharArray()){
            if(c == '(') count++;
            if(c == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }

}
