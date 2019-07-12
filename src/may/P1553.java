package may;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1553 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String num = sc.next();
    if(num.indexOf('.') != -1){// 小数
      String left = num.substring(0,num.indexOf('.'));
      String right = num.substring(num.indexOf('.')+1);
      System.out.println(reverce(left) +"." +reverce_xiaoshu(right));
    }else if(num.indexOf('/') != -1){ //分数
      String left = num.substring(0,num.indexOf('/'));
      String right = num.substring(num.indexOf('/')+1);
      System.out.println(reverce(left )+ "/" + reverce(right));
    }else if(num.indexOf('%') != -1){
      String left = num.substring(0,num.indexOf('%'));
      System.out.println(reverce(left)+ "%");
    }else {
      System.out.println(reverce(num));
    }
  }
  public static String reverce(String num){
    if(num.equals("0")) return "0";
    int len = num.length();
    StringBuilder re_num = new StringBuilder();
    boolean flag = true;
    for (int i = len-1; i >=0 ; i--) {
      if(flag && num.charAt(i) == '0') continue;
      if(flag && num.charAt(i) != '0') flag =false;
      re_num.append(num.charAt(i));
    }
    return re_num.toString();
  }

  public static String reverce_xiaoshu(String num){
    if(num.equals("0")) return "0";
    int len = num.length();
    StringBuilder re_num = new StringBuilder();
    boolean flag = true;
    for (int i = len-1; i >=0 ; i--) {
      if(flag && num.charAt(i) == '0') continue;
      if(flag && num.charAt(i) != '0') flag =false;
      re_num.append(num.charAt(i));
    }

    for (int i = re_num.length()-1; i >=0 ; i--) {
      if(re_num.charAt(i) == '0')
        re_num.delete(i,i+1);
      else break;
    }
    if(re_num.length() == 0) return "0";
    return re_num.toString();
  }
}
