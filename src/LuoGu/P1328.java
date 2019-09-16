package LuoGu;

import java.util.Scanner;

public class P1328 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] judger = {
            {0,-1,1,1,-1},
            {1,0,-1,1,-1},
            {-1,1,0,-1,1},
            {-1,-1,1,0,1},
            {1,1,-1,-1,0}
    };
    int n = sc.nextInt();
    int len_a = sc.nextInt();
    int len_b = sc.nextInt();
    int[] a = new int[len_a];
    int[] b = new int[len_b];
    for (int i = 0; i <len_a ; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i <len_b ; i++) {
      b[i] = sc.nextInt();
    }
    int sum_a = 0,sum_b = 0;
    for (int i = 0; i <n ; i++) {
      int a_select = a[i%len_a];
      int b_select = b[i%len_b];
      if(judger[a_select][b_select] > 0) sum_a++;
      else if(judger[a_select][b_select] < 0) sum_b++;
    }
    System.out.println(sum_a + " " + sum_b);
  }
}
