package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-10 22:39
 * @description TODO
 **/
public class P5728 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][4];
        for (int i = 0; i < n ; i++) {
            dp[i][0] = sc.nextInt();
            dp[i][1] = sc.nextInt();
            dp[i][2] = sc.nextInt();
            dp[i][3] = dp[i][0] + dp[i][1] + dp[i][2];
        }
        int count = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j < n; j++) {
                if(judge(dp,i,j)) count++;
            }
        }
        System.out.println(count);
    }

    public static boolean judge(int[][] dp,int i,int j){
        if(Math.abs(dp[i][0] - dp[j][0]) <= 5
        && Math.abs(dp[i][1] - dp[j][1]) <= 5
        && Math.abs(dp[i][2] - dp[j][2]) <= 5
        && Math.abs(dp[i][3] - dp[j][3]) <= 10)
            return true;
        else return false;
    }
}