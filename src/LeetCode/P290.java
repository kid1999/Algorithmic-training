package LeetCode;

import java.util.HashMap;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/8/9 10:10
 **/
public class P290 {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str==null) return false;
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        HashMap<Character,String> map = new HashMap<>();

        for (int i = 0; i <pattern.length() ; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {    //key已经在
                //不对应就失败
                if(!map.get(c).equals(strs[i])) return false;
            }
            else{//两个value的值一样 a-dog b-dog->false
                if(map.containsValue(strs[i])) return false;
                else map.put(c,strs[i]);
            }
        }
        return true;
    }
}
