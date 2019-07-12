package may;

import java.util.Scanner;

public class P1115 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int max = Integer.MIN_VALUE;
    int[] dp = new int[n+1];
    for (int i = 1; i <=n ; i++) {
      int num = sc.nextInt();
      dp[i] = Math.max(num,dp[i-1]+num);
      if(dp[i] > max) max = dp[i];
    }
    System.out.println(max);
  }
}
