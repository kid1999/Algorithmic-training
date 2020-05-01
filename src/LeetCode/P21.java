package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/1 8:59
 **/
public class P21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }else{
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) head.next = l1;
        else head.next = l2;
        return cur.next;
    }
}
