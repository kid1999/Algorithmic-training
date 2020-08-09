package LeetCode;

import lanqiao.test2019.H;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/8/9 10:27
 **/
public class week201 {


    // 1
    public static String makeGood(String s) {
        LinkedList<Character> ss = new LinkedList<>();
        for (char c:s.toCharArray()) {
            ss.add(c);
        }
        for (int i = 0; i <ss.size()-1; i++) {
            char a = ss.get(i);
            char b = ss.get(i+1);
            if(a == (b + 32) || a == (b-32)) {
                ss.remove(i+1);
                ss.remove(i);
                i = -1;
            }
        }
        String res = "";
        for (char c:ss) {
            res += c;
        }
        return res;
    }

    // 2
    public static char findKthBit(int n, int k) {
        StringBuilder res = new StringBuilder("0");
        for (int i = 1; i <=n ; i++) {
            StringBuilder a = res;
            StringBuilder b = invert(res);
            res = a.append("1").append(b.reverse());
        }
        return res.charAt(k-1);
    }
    public static StringBuilder invert(StringBuilder s){
        StringBuilder new_s = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i) == '0') new_s.append('1');
            else new_s.append('0');
        }
        return new_s;
    }

    // 3
    // 前缀和 + dp
    public static int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0;
        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1];
            sum += nums[i-1];
            int delta = sum - target;
            if(map.containsKey(delta))
                dp[i] = Math.max(dp[i],dp[map.get(delta)]+1);
            map.put(sum,i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] arr = {-2,6,6,3,5,4,1,2,8};
        System.out.println(maxNonOverlapping(arr,10));
    }
}
