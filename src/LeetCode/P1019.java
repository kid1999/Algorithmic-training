package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/12 9:49
 **/
public class P1019 {
    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[10001];
        int index = 0;
        if(head == null) return new int[0];
        while (head != null){
            int val = head.val;
            while (!stack.isEmpty() && val>stack.peek()){
                stack.pop();
                res[stack.pop()] = val;
            }
            stack.push(index++);
            stack.push(val);
            head = head.next;
        }
        int[] tmp = new int[index];
        for (int i = 0; i <index ; i++) {
            tmp[i] = res[i];
        }
        return tmp;
    }
}
