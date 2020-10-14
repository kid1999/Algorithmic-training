package LeetCode;

import java.util.List;

/**
 * @author kid1999
 * @create 2020-10-14 17:06
 * @description TODO
 **/
public class P92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode lNode = pre;
        ListNode rNode = pre.next;
        for (int i = 0; i <m ; i++) {
            lNode = lNode.next;
            rNode = rNode.next;
        }
        for (int i = 0; i <n-m ; i++) {
            ListNode remove = rNode.next;
            rNode.next = rNode.next.next;
            remove.next = lNode.next;
            lNode.next = remove;
        }
        return pre.next;
    }
}