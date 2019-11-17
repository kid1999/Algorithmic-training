package lanqiao.test2019;

import java.util.Arrays;
import java.util.Scanner;

public class I {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] nums = new int[n+m+1];
    for (int i = 0; i <n+m+1 ; i++) {
      nums[i] = sc.nextInt();
    }
    Arrays.sort(nums);
    int res = 0;
    n++;
    for (int i = nums.length-1; i >=0; i--) {
      if(n>0){
        res += nums[i];
        n--;
      }else res -= nums[i];
    }
    System.out.println(res);
  }
}
