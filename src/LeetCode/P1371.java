package LeetCode;

import java.util.HashMap;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/20 9:17
 **/
public class P1371 {

    public int findTheLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        HashMap<Integer,Integer> stateMap = new HashMap<Integer, Integer>();
        hashMap.put('a',1);            // 状态压缩，每个字母有两个状态01,用2^5个数表示所有状态
        hashMap.put('i',2);
        hashMap.put('u',4);
        hashMap.put('e',8);
        hashMap.put('o',16);
        int res = 0;
        int max = 0;
        stateMap.putIfAbsent(0, -1);
        for(int i = 0;i<s.length();i++){
            if (hashMap.containsKey(s.charAt(i))) {
                res ^= hashMap.get(s.charAt(i));        // 当前状态的异或值
            }
            if (stateMap.containsKey(res)) max = Math.max(max,i-stateMap.get(res));     // 如果之前有这个亦或值，求取最大长度
            stateMap.putIfAbsent(res,i);        // 保存当前状态
        }
        return max;
    }
}
