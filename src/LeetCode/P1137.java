package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/8 12:00
 **/
public class P1137 {
    public static void main(String[] args) {

    }
    public int tribonacci(int n) {
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            int tmp = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = tmp;
        }
        if(n<3) return dp[n];
        else return dp[2];
    }
}
