package LeetCode;

/**
 * @author kid1999
 * @date 2020/9/9 20:35
 * @title P86
 */

public class P86 {
	public static void main(String[] args) {

	}

	public ListNode partition(ListNode head, int x) {
		ListNode left = new ListNode(-1);
		ListNode right = new ListNode(-1);
		ListNode node1 = left,node2 = right;
		while (head != null){
			int val = head.val;
			if(val < x){
				node1.next = head;
				head = head.next;
				node1 = node1.next;
				node1.next = null;
			}else {
				node2.next = head;
				head = head.next;
				node2 = node2.next;
				node2.next = null;
			}
		}
		node1.next = right.next;
		return left.next;
	}
}
