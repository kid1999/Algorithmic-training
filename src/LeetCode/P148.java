package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/15 9:16
 **/
public class P148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return merge_sort(head);
    }
    ListNode merge_sort(ListNode head){
        if(head.next == null) return head;
        ListNode slow = head,fast = head,pre = null;
        while (fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = merge_sort(head);
        ListNode r = merge_sort(slow);
        return merge(l,r);
    }
    ListNode merge(ListNode l,ListNode r){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l != null && r !=null){
            if(l.val <= r.val){
                cur.next = l;
                cur = cur.next;
                l = l.next;
            }else{
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if(l!=null) cur.next = l;
        if(r!=null) cur.next = r;
        return head.next;
    }
}
