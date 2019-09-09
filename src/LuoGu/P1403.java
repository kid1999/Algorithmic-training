package LuoGu;

import java.util.Scanner;

public class P1403 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
//    int res = 0;
//    int j;
//    for (int num = 1; num <=n; num++) {
//      int end = (int) Math.sqrt(num);
//      for (j = 1; j <=end ; j++) {
//        if (num%j == 0){
//          res += 2;
//        }
//      }
//      j--;
//      if(num/j == j && num%j==0) res--;
//    }
//    System.out.println(res);

    int res = 0;
    for (int i = 1; i <=n ; i++) {
      res += n/i;
    }
    System.out.println(res);
  }
}
