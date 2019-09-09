package LuoGu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1223 {
  public static void main(String[] args) {
    class node{
      public int x;
      public int y;

      public node(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    node[] nums = new node[n];
    for (int i = 0; i <n ; i++) {
      nums[i] = new node(i+1,sc.nextInt());
    }

    Arrays.sort(nums, new Comparator<node>() {
      @Override
      public int compare(node o1, node o2) {
        return o1.y - o2.y;
      }
    });

    int now = 0;
    double sum = 0;
    for (int i = 0; i <n-1; i++) {
      System.out.print(nums[i].x + " ");
      now += nums[i].y;
      sum += now;
    }
    System.out.println(nums[n-1].x);
    double res = sum /n ;
    System.out.printf("%.2f",res);
  }
}

