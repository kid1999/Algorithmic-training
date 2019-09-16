package LuoGu;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1012 {
  static BigInteger res = BigInteger.ZERO;
  static String[] nums;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    nums = new String[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.next();
    }

    Set<Integer> used = new HashSet<>();
    helper(used,"");
    System.out.println(res);
  }
  public static void helper( Set<Integer> used,String num){
    if (used.size() == nums.length){
      BigInteger tmp = new BigInteger(num);
      if(res.compareTo(tmp) == -1){
        res = tmp;
      }
      return;
    }
    for (int i = 0; i < nums.length ; i++) {
      if(!used.contains(i)){
        Set<Integer> newused = new HashSet<>(used);
        newused.add(i);
        helper(newused,num + nums[i]);
      }
    }
  }
}
