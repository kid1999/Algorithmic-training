package LuoGu;

import java.util.Arrays;
import java.util.Scanner;

public class P1094 {
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int max = sc.nextInt();
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i <n ; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    int l = 0;
    int r = n-1;
    int sum = 0;
    int count = 0;
    while (l<=r){
      sum += nums[l];
      if(sum>=max){
        count++;
        l++;
        sum = 0;
      }
      sum += nums[r];
      if(sum>=max) {
        count++;
        r--;
        sum = 0;
      }

      l++;
//      kjl
    }
  }
}
