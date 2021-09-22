package LeetCode;

/**
 * @author kid1999
 * @create 2021-02-05 8:20
 * @description TODO
 **/
public class P1208 {
    public static void main(String[] args) {

    }

    public int equalSubstring(String s, String t, int maxCost) {
        int n = t.length();
        int[] dp = new int[n];
        for (int i = 0; i <n ; i++) {
            dp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLen = 0;
        int count = 0,l = 0, r = 0;
        while (l <= r && r < n){
            if(count + dp[r] <= maxCost) count += dp[r++];
            else count -= dp[l++];
            maxLen = Math.max(maxLen,r-l);
            if(l>r) r = l;
        }
        return maxLen;
    }
}