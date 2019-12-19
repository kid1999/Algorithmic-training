package LeetCode;

import java.util.Stack;

/**
 * @auther: kid1999
 * @date: 2019/12/19 10:59
 * @desc: P682
 **/
public class P682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String option:ops) {
            if(option.equals("C")){
                stack.pop();
            }else if(option.equals("D")){
                stack.push(stack.peek()*2);
            }else if(option.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(b+a);
            }else{
                stack.push(Integer.valueOf(option));
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
