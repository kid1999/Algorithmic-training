package LuoGu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1598 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Map<Character,Integer> words = new HashMap<>();
    for (int i = 0; i <4 ; i++) {
        String string = sc.nextLine();
      for (char ch:string.toCharArray()) {
        if(words.containsKey(ch)){
          words.put(ch,words.get(ch) + 1);
        }else{
          words.put(ch,1);
        }
      }
    }
    // output
    int max = 0;
    int[] length = new int[26];
    for (int j = 0; j <26 ; j++) {
      char ch = (char)(65+j);
//      length[j] = words.getOrDefault(ch,0);
      if(length[j] > max) max = length[j];
    }

    // 柱状

    for (int len = max; len >0 ; len--) {
      StringBuilder S = new StringBuilder();
      boolean f = true;
      for (int k = 25; k >=0 ; k--) {
        if(f && length[k] < len) continue;
        if(f && length[k] >= len) f = false;
        if(k == 0){
          if(length[k] >= len) S.append("*");
          else S.append(" ");
        }else{
          if(length[k] >= len) S.append("* ");
          else S.append("  ");
        }

      }
      System.out.println(S.reverse());
    }

    // x坐标
    for (int j = 0; j <26 ; j++) {
      char ch = (char)(65+j);
      System.out.print(ch + " ");
    }

  }
}
