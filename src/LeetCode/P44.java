package LeetCode;

import java.util.Arrays;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/25 11:24
 **/
public class P44 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa","ab*"));
    }

//    dp[i][j] 表示s[i] 与 p[j] 是否匹配

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <=p.length() ; i++) {
            if(p.charAt(i-1) == '*') dp[0][i] = true;
            else break;
        }
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*') dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
            }
        }
        return dp[s.length()][p.length()];
    }


}
