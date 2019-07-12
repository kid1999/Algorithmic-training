package may;

import java.util.Scanner;

public class P1164 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] dp = new int[n+1][m+1];
    int[] value = new int[n+1];
    for (int i = 1; i <=n ; i++) {
      value[i] = sc.nextInt();
    }


    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=m ; j++) {  //j 代表当前剩余钱
        // 都是前一道菜的基础上...
        if(j==value[i]) dp[i][j] = dp[i-1][j] +1;   // 只够吃这一个菜
        if(j<value[i]) dp[i][j] = dp[i-1][j];      // 吃不了
        if(j>value[i]) dp[i][j] = dp[i-1][j-value[i]] + dp[i-1][j];  // 吃不吃都可以
      }
    }
    System.out.println(dp[n][m]);
  }
}
