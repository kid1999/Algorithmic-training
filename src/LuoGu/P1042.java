package LuoGu;

import java.util.Scanner;

public class P1042 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] dp = new char[100001];
    int index = 0;
    boolean f = true;
    while (f){
      String s = sc.next();
      for (char c:s.toCharArray()) {
        if(c == 'E'){
          f = false;
          break;
        }
        dp[index++] = c;
      }
    }

    int res1 = 0;
    int res2 = 0;
    for (int i = 0; i <=index ; i++) {
      if(dp[i] == 'W') res1++;
      if(dp[i] == 'L') res2++;
      if((res1>=11 || res2>=11) && Math.abs(res1-res2)>=2){
        System.out.println(res1 + ":" + res2);
        res1 = res2 = 0;
      }
    }

    System.out.println(res1 + ":" + res2);
    System.out.println();
    res1 = res2 = 0;

    for (int i = 0; i <=index ; i++) {
      if(dp[i] == 'W') res1++;
      if(dp[i] == 'L') res2++;
      if((res1>=21 || res2>=21) && Math.abs(res1-res2)>=2){
        System.out.println(res1 + ":" + res2);
        res1 = res2 = 0;
      }
    }
    System.out.println(res1 + ":" + res2);
  }
}
