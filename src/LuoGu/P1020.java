package LuoGu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1020 {
  static int max = 0;
  static int res = 0;
  static int count = 0;
  static int dp_len = 0;
  static int[] nums;
  static boolean[] dp;
  static List<Integer> chooice;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
//    Scanner sc = new Scanner(new FileInputStream("data/in"));
    nums = new int[100001];
    dp = new boolean[100001];
    while (sc.hasNextInt()){
      nums[count++] = sc.nextInt();
    }

    while (dp_len != count) {
      max = 0;
      dfs(0,0,Integer.MAX_VALUE,new ArrayList<>());
      dp_len += chooice.size();
      res++;
      if(res == 1) System.out.println(max);
      for (int n:chooice) {
        dp[n] = true;
      }
    }
    System.out.println(res);
  }
  public static void dfs(int index, int sum, int last, List<Integer> tmp){
    if(index >= count){
      if (sum > max){
        max = sum;
        chooice = tmp;
      }
      return ;
    }
    if(!dp[index]){
      if(nums[index] <= last){
        List<Integer> n_tmp = new ArrayList<>(tmp);
        n_tmp.add(index);
        dfs(index+1,sum+1,nums[index],n_tmp);  // 选
      }
    }
    dfs(index+1,sum,last,new ArrayList<>(tmp));     // 不选
  }
}
