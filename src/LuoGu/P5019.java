package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-11 14:41
 * @description TODO
 **/
public class P5019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        for (int i = 0; i <n ; i++) {
            dp[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 1; i <n ; i++) {
            if(dp[i] > dp[i-1]) res += dp[i]-dp[i-1];
        }
        System.out.println(res + dp[0]);
    }
}