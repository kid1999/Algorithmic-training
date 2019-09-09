package LuoGu;

import java.util.Scanner;

public class P1720 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    double five = Math.sqrt(5);
    double res = (Math.pow(((1+five)/2),n) - Math.pow(((1-five)/2),n))/five;
    System.out.printf("%.2f",res);
  }
}
