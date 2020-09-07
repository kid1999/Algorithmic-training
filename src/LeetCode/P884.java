package LeetCode;

import java.util.*;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/28 18:24
 **/
public class P884 {
    public static void main(String[] args) {

    }

//    public String[] uncommonFromSentences(String A, String B) {
//        Set<String> set = new HashSet<>();
//        Set<String> set2 = new HashSet<>();
//        List<String> res = new ArrayList<>();
//        String s = A + " " + B;
//        for (String ss:s.split(" ")) {
//            if(set.contains(ss)) set2.add(ss);
//            set.add(ss);
//        }
//        for (String ss:set) {
//            if(!set2.contains(ss)) res.add(ss);
//        }
//        String[] strings = new String[res.size()];
//        return res.toArray(strings);
//    }

    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String string = A + " " + B;
        for (String s:string.split(" ")) {
           map.put(s,map.getOrDefault(s,0)+1);
        }
        for (String key:map.keySet()) {
            if(map.get(key) == 1) list.add(key);
        }
        String[] strings = new String[list.size()];
        return list.toArray(strings);
    }
}
