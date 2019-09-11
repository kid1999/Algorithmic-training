package LuoGu;

import java.util.Scanner;

public class P1464 {
  static long[][][] dp = new long[21][21][21];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true){
      long a = sc.nextLong();
      long b = sc.nextLong();
      long c = sc.nextLong();
      if(a == -1 && b == -1 && c == -1) break;
      else if(a<=0 || b<=0 || c<=0) System.out.println("w(" + a + ", " + b + ", "+ c + ") = " +1);
      else if(a>20 || b>20 || c>20) System.out.println("w(" + a + ", " + b + ", "+ c + ") = " +func(20,20,20));
      else{
        int x  = (int)a; int y = (int) b; int z = (int) c;
        System.out.println("w(" + a + ", " + b + ", "+ c + ") = " +func(x,y,z));
      }
    }
  }
  public static long func(int a,int b,int c){
    if(a<=0 || b<=0 || c<=0) return 1;
    if(dp[a][b][c] == 0) dp[a][b][c] = func(a-1,b,c)+func(a-1,b-1,c)+func(a-1,b,c-1)-func(a-1,b-1,c-1);
    return dp[a][b][c];
  }
}
