package LuoGu;

import java.util.Arrays;
import java.util.Scanner;

public class P1094 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int w = sc.nextInt();
    int n = sc.nextInt();
    int[] dp = new int[n];
    for (int i = 0; i <n ; i++) {
      dp[i] = sc.nextInt();
    }
    Arrays.sort(dp);
    int l = 0,r = n-1;
    int res = 0;
    while (l <= r){
      if(dp[l] + dp[r] > w) r--;
      else{
        l++;
        r--;
      }
      res++;
    }
    System.out.println(res);
  }
}
