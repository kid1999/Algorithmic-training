package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kid1999
 * @create 2021-03-04 21:32
 * @description TODO
 **/
public class P354 {
    public static void main(String[] args) {

    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, ( a, b) -> (a[0]-b[0]));
        int len = envelopes.length;
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <i ; j++) {
                if(envelopes[i][0] > envelopes[j][0]
                && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}