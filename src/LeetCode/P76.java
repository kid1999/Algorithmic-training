package LeetCode;

import lanqiao.test2019.H;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/14 9:43
 **/
public class P76 {

    // 双指针 + 收缩滑动窗口
    // hashmap
//    public String minWindow(String s, String t) {
//        int l=0,r=s.length()-1;
//        Map<Character,Integer> map = new HashMap<>();
//        for (char c:t.toCharArray()) {
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        int minLen = Integer.MAX_VALUE;
//        int left = 0,right = 0;
//        while (l<r && r<s.length()){
//
//        }
//    }
//    public static boolean check(HashMap<Character,Integer> map){
//
//    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int[] word = new int[64];
        for (char c:t.toCharArray()) {
            word[c-'A']++;
            set.add(c);
        }
        int minLen = Integer.MAX_VALUE;
        int l=0,r=0;
        int left = 0,right = 0;
        while (l<=r && r<s.length()){
            while (l<r && check(word)){     // 收缩
                if(r-l < minLen){
                    left = l;
                    right = r;
                    minLen = r-l;
                }
                if(set.contains(chars[l])) word[chars[l] -'A']++;
                l++;
            }
            if(set.contains(chars[r])) word[chars[r] -'A']--;
            r++;        // 扩大寻找
        }
        while (l<r && check(word)){     // 收缩
            if(r-l < minLen){
                left = l;
                right = r;
                minLen = r-l;
            }
            if(set.contains(chars[l])) word[chars[l] -'A']++;
            l++;
        }
        if(right == 0) return "";
        else return s.substring(left,right);
    }
    public static boolean check(int[] word){
        for (int n:word) {
            if(n > 0) return false;
        }
        return true;
    }

}
