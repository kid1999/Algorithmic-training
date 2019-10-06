package LuoGu;

import java.util.Scanner;

public class P1057 {
  static int n;
  static int[][] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int m = sc.nextInt();
    if(n%2==0 && m%2==1){       //特判
      System.out.println(0);
      return;
    }
    dp = new int[n+1][m+1];
    int res = func(0,m);
    System.out.println(res);
  }
  public static int func(int index,int count){
    if(count == 0){
      if(index==0) return 1;
      return 0;
    }
    int res = 0;
    if(dp[index][count]==0){
      res += func((index-1+n)%n,count-1);
      res += func((index+1+n)%n,count-1);
      dp[index][count] = res;
    }else res = dp[index][count];
    return res;
  }
}
// 30 30 155117522
//