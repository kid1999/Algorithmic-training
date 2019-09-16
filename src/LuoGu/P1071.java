package LuoGu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1071 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String src = sc.next();   // 秘文
    String dst = sc.next();   // 源信息
    String text = sc.next();
    Map<Character,Character> map = new HashMap<>();
    for (int i = 0; i <src.length() ; i++) {
      if(!map.containsKey(src.charAt(i))){
        if(map.containsValue(dst.charAt(i))){
          System.out.println("Failed");
          return;
        }else map.put(src.charAt(i),dst.charAt(i));
      }else if(map.get(src.charAt(i)) != dst.charAt(i)){
        System.out.println("Failed");
        return;
      }
    }
    if(map.size() != 26){
      System.out.println("Failed");
      return;
    }
    for (char word:text.toCharArray()) {
      if(map.containsKey(word)){
        System.out.print(map.get(word));
      }else {
        System.out.println("Failed");
        return;
      }
    }
  }
}
