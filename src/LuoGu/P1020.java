package LuoGu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*   暴搜
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
  */

// 参考 https://blog.csdn.net/belous_zxy/article/details/80517745
// n*2的朴素线性dp
public class P1020{
  public static void main(String[] args) throws FileNotFoundException {
//    Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new FileInputStream("data/in"));
    int[] nums = new int[100001];
    int[] dp = new int[100001];
    int[] dst = new int[100001];
    int count = 0;
    while (sc.hasNextInt()){
      nums[count++] = sc.nextInt();
    }
    int res1 = 0,res2 = 0;
    for (int i = 1; i <count ; i++) {
      for (int j = 0; j <i ; j++) {
        if(nums[j] >= nums[i]) dp[i] = Math.max(dp[i],dp[j]+1);
        else dst[i] = Math.max(dst[i],dst[j]+1);
      }
      res1 = Math.max(res1,dp[i]);
      res2 = Math.max(res2,dst[i]);
    }
    System.out.println(res1+1);
    System.out.println(res2+1);
  }
}