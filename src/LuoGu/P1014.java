package LuoGu;

import java.util.Scanner;

public class P1014 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ceng = 1;
    // 蛇形排列 且无边际限制
    while(n > ceng){
      n -= ceng;
      ceng++;
    }
    if((ceng&1) == 0) System.out.println(n + "/"+(ceng+1-n));
    else System.out.println((ceng+1-n) + "/"+n);
  }
}
