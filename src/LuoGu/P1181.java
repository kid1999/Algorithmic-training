package LuoGu;

import java.util.Scanner;

public class P1181 {
  public static void main(String[] args) {
    Scanner sc  = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int sum = 0;
    int count = 0;
    for (int i = 0; i <n ; i++) {
      int num = sc.nextInt();
      if(sum+num<=m){
        sum += num;
      }else {
        sum = num;
        count++;
      }
    }
    System.out.println(count+1);
  }
}
