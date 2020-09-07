package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/7/26 10:21
 **/
public class week199 {
    public static void main(String[] args) {
//        minFlips("001011101");
        int  s = getLengthOfOptimalCompression("aaabcccd",2);
        System.out.println(s);
    }


    // 1
    public String restoreString(String s, int[] indices) {
        char[] dp = new char[indices.length];
        for (int i = 0; i <indices.length ; i++) {
            dp[indices[i]] = s.charAt(i);
        }
        String res = "";
        for (char c:dp) {
            res += c;
        }
        return res;
    }

    // 2
    public static int minFlips(String s) {
        int res = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i-1) != s.charAt(i)) res++;
        }
        return res;
    }

    // 3
     class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }
//    public int countPairs(TreeNode root, int distance) {
//
//    }



    // 4
    private static int k;
    public static int getLengthOfOptimalCompression(String s, int c) {
        k = c;
        String s0 = func(s);
        String s1 = removeMid(s0);
        return removeOne(s1).length();
    }

    public static String func(String s){
        String res = "";
        int count = 1;
        char word = s.charAt(0);
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i) == word) count++;
            else {
                if(count > 1) res = res + word + count;
                else res += word;
                word = s.charAt(i);
                count = 1;
            }
        }
        if(count > 1) res = res +  word + count;
        else res += word;
        return res;
    }

    // 1.去中间
    public static String removeMid(String s){
        List<Integer> nums = new ArrayList<>();
        List<Character> words = new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c <= '9' && c>= '0') continue;
            else {
                words.add(c);
                if(i+1 < s.length()){
                    if(s.charAt(i+1) <= '9' && s.charAt(i+1) >= '0'){
                        i++;
                        nums.add(s.charAt(i) - '0');
                    }
                    else nums.add(1);
                }
            }
        }
        if(s.charAt(s.length()-1) > '9') nums.add(1);
        for (int i = 1; i < words.size()-1 ; i++) {
            char p = words.get(i-1);
            char n = words.get(i+1);
            int count = nums.get(i);
            if(p == n && count <= k){
                k -= count;
                nums.set(i,0);
            }
        }
        String res = "";
        for (int i = 0; i < words.size() ; i++) {
            if(nums.get(i) == 0) continue;
            else if(nums.get(i) == 1) res += words.get(i);
            else res = res + words.get(i) + nums.get(i);
        }
        return res;
    }

    // 2.去1个
    public static String removeOne(String s){
        List<Integer> nums = new ArrayList<>();
        List<Character> words = new ArrayList<>();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0') continue;
            else {
                words.add(s.charAt(i));
                if(i+1 < s.length()){
                    if(s.charAt(i+1) <= '9' && s.charAt(i+1) >= '0'){
                        i++;
                        nums.add(s.charAt(i) - '0');
                    }
                    else nums.add(1);
                }
            }
        }
        if(s.charAt(s.length()-1) > '9') nums.add(1);
        for (int i = 0; i < words.size(); i++) {
            int count = nums.get(i);
            if(count == 1 && k >= 1){
                k--;
                nums.set(i,0);
            }
        }
        for (int i = 0; i < words.size(); i++) {
            int count = nums.get(i);
            if(count == 2 && k >= 2){
                k-=2;
                nums.set(i,0);
            }
        }
        String res = "";
        for (int i = 0; i <words.size() ; i++) {
            if(nums.get(i) == 0) continue;
            else if(nums.get(i) == 1) res += words.get(i);
            else res = res + words.get(i) + nums.get(i);
        }
        return res;
    }
}
