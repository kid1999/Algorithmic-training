package CF.R593;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i <n ; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int res = 0;
      while (c>=2 && b >=1){
        res += 3;
        c -= 2;
        b -= 1;
      }
      while (b>=2 && a >=1){
        res += 3;
        b -= 2;
        a -= 1;
      }
      System.out.println(res);
    }
  }
}
