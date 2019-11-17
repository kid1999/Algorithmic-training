package lanqiao.test2019;

import java.util.Scanner;

public class J {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    for (int i = 0; i <t ; i++) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int j = 0; j <n ; j++) {
        nums[i] = sc.nextInt();
      }
      func(nums);
    }
  }
  public static void func(int[] nums){
    int[] dp = new int[nums.length+1];
    int res = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length-1 ; i++) {

    }
  }
}
