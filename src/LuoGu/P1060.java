package LuoGu;

import java.util.Scanner;

public class P1060 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt();
    int n = sc.nextInt();
    int[][] dp = new int[n+1][w+1];
    int[] weight = new int[n+1];
    int[] value = new int[n+1];
    for (int i = 1; i <=n ; i++) {
      weight[i] = sc.nextInt();
      value[i] = sc.nextInt();
    }

    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=w ; j++) {
        if(weight[i] > j){
          dp[i][j] = dp[i-1][j];
        }else{
          int v1 = dp[i-1][j];
          int v2 = dp[i-1][j-weight[i]] + value[i]*weight[i];
          dp[i][j] = Math.max(v1,v2);
        }
      }
    }
    System.out.println(dp[n][w]);
  }
}
