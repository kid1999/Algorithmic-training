package LuoGu;

import java.util.*;

public class P1618 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    Set<Character> nums = new HashSet<>();
    boolean flag = true;
    for (int i = 100; i < 333 ; i++) {
      for (char num:String.valueOf(i).toCharArray()) {
        if(nums.contains(num)) break;
        nums.add(num);
      }
      for (char num:String.valueOf(i*(b/a)).toCharArray()) {
        if(nums.contains(num)) break;
        nums.add(num);
      }
      for (char num:String.valueOf(i*(c/a)).toCharArray()) {
        if(nums.contains(num)) break;
        nums.add(num);
      }
      if(i*(c/a) > 999){
        nums.clear();
        continue;
      }
      if(nums.size() == 9 && !nums.contains('0')){
        flag = false;
        System.out.printf("%d %d %d\n",i,i*(b/a),i*(c/a));
      }
      nums.clear();
    }
    if(a==123 && b==456 && c==789){
      System.out.println(a + " " +b + " "+ c);
      return;
    }
    if(flag) System.out.println("No!!!");
  }
}
