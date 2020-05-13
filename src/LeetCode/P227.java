package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/13 9:54
 **/
public class P227 {
    public static void main(String[] args) {
        System.out.println(calculate(" 3*2 *5"));
    }
    public static int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        String num = "";
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(c>='0' && c<='9') num += c;
            else if(c == '*' || c== '/'){
                int a = num.equals("") ? nums.pollLast() : Integer.parseInt(num);
                String nextNum = "";
                while (i+1<s.length()) {
                    i++;
                    if(s.charAt(i) == ' ') continue;
                    if(s.charAt(i)>='0' && s.charAt(i)<='9') nextNum += s.charAt(i);
                    else break;
                }
                i--;
                if(c == '*') nums.addLast(a*Integer.parseInt(nextNum));
                if(c == '/') nums.addLast(a/Integer.parseInt(nextNum));
                num = "";
            }else{
                ops.addLast(c);
                if(!num.equals("")) nums.addLast(Integer.parseInt(num));
                num = "";
            }
        }
        if(!num.equals("")) nums.addLast(Integer.parseInt(num));
        while (!ops.isEmpty()){
            int a = nums.pollFirst();
            int b = nums.pollFirst();
            if(ops.pollFirst() == '+'){
                nums.addFirst(a+b);
            }else{
                nums.addFirst(a-b);
            }
        }
        return nums.pop();
    }
}
