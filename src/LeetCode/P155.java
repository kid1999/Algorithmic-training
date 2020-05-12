package LeetCode;

import java.util.*;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/12 8:14
 **/
public class P155 {

}


class MinStack {
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }

    // 一个值，一个当前最小值 保证一直保留一个最小值在栈顶
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int min = stack.peek();
            stack.push(x);
            stack.push(Math.min(min,x));
        }
    }

    // 先删除再恢复现场
    public void pop() {
        stack.pop();
        stack.pop();
    }


    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }
}