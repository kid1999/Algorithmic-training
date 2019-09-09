package LuoGu;

import java.util.Scanner;
import java.util.Stack;

public class P1449 {
  public static void main(String[] args) {
    Scanner sc=  new Scanner(System.in);
    String string = sc.next();
    Stack<Integer> nums = new Stack<>();
    int tmp = 0;
    int num = 0;
    for (char ch:string.toCharArray()) {
      if(ch == '.') {
        nums.push(num);
        num = 0;
      }
      else if(Character.isDigit(ch)){
        num = num*10 + ch-'0';
      }
      else {
        if(ch == '@') break;
        int b = nums.pop();
        if(ch == '+'){
          if(nums.isEmpty()) tmp = tmp + b;
          else tmp = b + nums.pop();
        }else if (ch == '-'){
          if(nums.isEmpty()) tmp = tmp - b;
          else tmp = nums.pop() - b;
        }else if(ch == '*'){
          if(nums.isEmpty()) tmp = tmp * b;
          else tmp = nums.pop() * b;
        }else if(ch == '/'){
          if(nums.isEmpty()) tmp = tmp / b;
          else tmp = nums.pop() / b;
        }
      }
    }
    System.out.println(tmp);
  }
}
