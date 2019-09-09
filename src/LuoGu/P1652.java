package LuoGu;

import java.util.Scanner;

public class P1652 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    int[] r = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      y[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      r[i] = sc.nextInt();
    }
    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();

    // Start
    int res = 0;
    for (int i = 0; i < n; i++) {
      double dist = Math.pow((x1-x[i]),2) + Math.pow((y1-y[i]),2);
      double dist2 = Math.pow((x2-x[i]),2) + Math.pow((y2-y[i]),2);
      double r2 = Math.pow(r[i],2);
      if((dist < r2 && dist2 > r2)  || (dist > r2 && dist2 < r2))
        res++;
    }
    System.out.println(res);
  }
}
