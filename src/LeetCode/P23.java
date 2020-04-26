package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/26 8:37
 **/
public class P23 {
    public static void main(String[] args) {

    }

    // 暴力比对大小

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode node = new ListNode(-1);
//        ListNode head = node;
//        int len = lists.length;
//        boolean[] isNull = new boolean[len];
//        while (len > 0){
//            int min = Integer.MAX_VALUE;
//            int index = 0;
//            for (int i = 0; i <len; i++) {
//                if( !isNull[i] && lists[i] == null){
//                    isNull[i] = true;
//                    len--;
//                }
//                else if(!isNull[i] && lists[i].val < min){
//                    min = lists[i].val;
//                    index = i;
//                }
//            }
//            if(lists[index] == null){
//                isNull[index] = true;
//                len--;
//            }else {
//                System.out.println(len + " " +lists[index].val );
//                node.next = new ListNode(lists[index].val);
//                node = node.next;
//                lists[index] = lists[index].next;
//            }
//
//        }
//        return head.next;
//    }



    // 优先队列查找大小
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        while (true){
            int size = queue.size();
            for (int i = 0; i <lists.length ; i++) {
                if(lists[i] != null){
                    queue.offer(lists[i]);
                    lists[i] = lists[i].next;
                }
            }
            if(queue.size() == size) break;
        }
        ListNode node = new ListNode(-1);
        ListNode head = node;
        while (!queue.isEmpty()){
            node.next = new ListNode(queue.poll().val);
            node = node.next;
        }
        return head.next;
    }



}
