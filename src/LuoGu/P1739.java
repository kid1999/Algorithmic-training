package LuoGu;

import java.util.Scanner;

public class P1739 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int left = 0;
    int right = 0;
    for (char ch:str.toCharArray()) {
      if(ch == '('){
        left++;
      }else if (ch == ')'){
        right++;
      }
      if (right>left) {
        System.out.println("NO");
        return;
      }
    }
    if(right != left) System.out.println("NO");
    else System.out.println("YES");
  }
}
