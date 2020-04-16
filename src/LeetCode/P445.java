package LeetCode;

import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/16 20:07
 **/
public class P445 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1!= null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!= null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag > 0) {
            int sum = flag;
            sum += stack1.isEmpty()? 0: stack1.pop();
            sum += stack2.isEmpty()? 0: stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            flag = sum/10;
        }
        return head;
    }
}
