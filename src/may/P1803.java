package may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1803 {
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
    for (int i = 0; i < n; i++) {
      nums[i] = new node(sc.nextInt(),sc.nextInt());
    }
    Arrays.sort(nums, new Comparator<node>() {
      @Override
      public int compare(node o1, node o2) {
        return o1.y - o2.y;
      }
    });

    int right = 0;
    int count = 0;
    for (int i = 0; i <n ; i++) {
      if(nums[i].x>=right){
        right = nums[i].y;
        count++;
      }
    }
    System.out.println(count);
  }
}
