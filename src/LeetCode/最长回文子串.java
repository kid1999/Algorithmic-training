package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/20 10:01
 **/
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    // 1.暴力法：
//    public static String longestPalindrome(String s) {
//        int max = -1;
//        String res = "";
//        char[] chs = s.toCharArray();
//        for (int i = 0; i < chs.length; i++) {
//            for (int j = chs.length-1; j >=i ; j--) {
//                int l = i,r = j;
//                boolean f = true;
//                while (l<=r){
//                    if(chs[l]!=chs[r]){
//                        f = false;
//                        break;
//                    }
//                    l++;
//                    r--;
//                }
//                if(f){
//                    if(max<j-i){
//                        max =  j-i;
//                        res = s.substring(i,j+1);
//                    }
//                    break;
//                }
//            }
//        }
//        return res;
//    }


    // 2.中心拓展法：
//    public static String longestPalindrome(String s) {
//        if(s.equals("")) return s;
//        char[] chars = s.toCharArray();
//        int res = 0;
//        Deque<Character> dequRes = new LinkedList<>();
//        for (int i = 0; i <chars.length ; i++) {
//            Deque<Character> deque = new LinkedList<>();
//            Deque<Character> list = new LinkedList<>();
//            deque.add(chars[i]);
//            int len = 1;
//            while (i-len>=0 && i+len <chars.length && chars[i-len] == chars[i+len]){
//                deque.addFirst(chars[i-len]);
//                deque.addLast(chars[i+len]);
//                len++;
//            }
//            len = 0;
//            while (i-len>=0 && i+len+1 <chars.length && chars[i-len] == chars[i+len+1]){
//                list.addFirst(chars[i-len]);
//                list.addLast(chars[i+len+1]);
//                len++;
//            }
//            if(deque.size()>res){
//                res = deque.size();
//                dequRes = deque;
//            }
//            if(list.size()>res){
//                res = list.size();
//                dequRes = list;
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        while (!dequRes.isEmpty()){
//            stringBuilder.append(dequRes.pollFirst());
//        }
//        return stringBuilder.toString();
//    }

    // 3. dp动态规划
        public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];

        int maxLen = 1;
        int start = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {//边界条件
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int currentLen = j - i + 1;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
