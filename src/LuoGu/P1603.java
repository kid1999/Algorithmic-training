package LuoGu;

import java.util.*;

public class P1603 {
  static long max = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] transform = {
            "one", "two", "three", "four", "five", "six", "seven", "eight","nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"
    };
    String[] trans1 = {"a","both","another","first", "second", "third"};

    Set<String> words = new HashSet<>();
    for (int i = 0; i < 6 ; i++) {
      words.add(sc.next());
    }
    List<String> nums = new ArrayList<>();
    // 正式
    for (int j = 0; j <6 ; j++) {
      if(words.contains(trans1[j])){
        int res = (j%3+1)*(j%3+1);
        nums.add("0" + String.valueOf(res));
      }
    }
    // 非正式
    for (int j = 0; j <20; j++) {
      if(words.contains(transform[j])){
        int res = (j+1)*(j+1) % 100;
        if( res < 10) nums.add("0" + String.valueOf(res));
        else nums.add(String.valueOf(res));
      }
    }

    if(nums.size() != 0) {
      Set<Integer> used = new HashSet<>();
      helper(nums,used,"");
    }
    System.out.println(max);
  }
  public static void helper(List<String> nums, Set<Integer> used,String res){
    if(used.size() == nums.size()) {
      if(max < Long.parseLong(res)) max = Long.parseLong(res);
      return;
    }
    for (int i = 0; i < nums.size() ; i++) {
      if(!used.contains(i)){
        used.add(i);
        helper(nums,used,res+nums.get(i));
      }
    }
  }
}
