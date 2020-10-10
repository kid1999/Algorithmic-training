package LuoGu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author kid1999
 * @create 2020-10-10 22:30
 * @description TODO
 **/
public class P5727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        Stack<Long> stack = new Stack<>();
        while (true){
            stack.push(n);
            if(n == 1) break;
            if(n%2==1) n = n*3+1;
            else n/=2;
        }
        while (!stack.isEmpty()){
            if(stack.size() != 1) System.out.print(stack.pop() + " ");
            else System.out.print(stack.pop());
        }
    }
}