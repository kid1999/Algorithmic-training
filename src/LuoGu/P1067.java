package LuoGu;

import java.util.Scanner;

public class P1067 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums=  new int[n+1];
    for (int i = 0; i <=n ; i++) {
      nums[i] = sc.nextInt();
    }
    StringBuffer res=  new StringBuffer();
    for (int i = 0; i < n-1 ; i++) {
      if(nums[i] > 0){
        if(nums[i] == 1) res.append("+").append("x^").append(n-i);
        else res.append("+").append(nums[i]).append("x^").append(n-i);
      }else if(nums[i] == 0) continue;
       else{
        if(nums[i] == -1) res.append("-").append("x^").append(n-i);
        else res.append(nums[i]).append("x^").append(n-i);
      }
    }

    // 特判 x
    if(nums[n-1] > 1) res.append("+").append(nums[n-1]).append("x");
    else if(nums[n-1] == 1) res.append("+x");
    else if(nums[n-1] == -1) res.append("-x");
    else if(nums[n-1] < 0) res.append(nums[n-1]).append("x");
    // 特判 x0
    if(nums[n] > 0) res.append("+").append(nums[n]);
    else if(nums[n] < 0) res.append(nums[n]);

    if(nums[0] > 0) System.out.println(res.substring(1));
    else System.out.println(res);
  }
}
