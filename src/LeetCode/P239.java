package LeetCode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/14 8:20
 **/
public class P239 {
    public static void main(String[] args) {
        int[] arr = {1,-1};
        System.out.println(maxSlidingWindow(arr,1));
    }

    // 大顶堆 + 双端队列 超时 n*logk
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        Deque<Integer> deque = new LinkedList<>();
//        int[] res = new int[nums.length-k+1];
//        PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        if(nums.length < 2) return nums;
//        for (int i = 0; i <k ; i++) {
//            deque.addLast(nums[i]);
//            q.add(nums[i]);
//        }
//        res[0] = q.peek();
//        for (int i = k; i <nums.length ; i++) {
//            deque.addLast(nums[i]);
//            q.remove(deque.pollFirst());
//            q.add(nums[i]);
//            res[i-k+1] = q.peek();
//        }
//        return res;
//    }

public static int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int[] res = new int[nums.length-k+1];
    if(nums.length < 2) return nums;
    int maxIndex = 0;
    for (int i = 0; i <k ; i++) {
        if(nums[i] >= nums[maxIndex]) maxIndex = i;
        deque.addLast(nums[i]);
    }
    res[0] = nums[maxIndex];
    for (int i = k; i < nums.length; i++) {
        deque.pollFirst();
        deque.addLast(nums[i]);
        if(nums[i] >= nums[maxIndex]) maxIndex = i; // 新值 > max
        if(nums[i] < nums[maxIndex] && i-k+1 >= maxIndex) { // 新值小于max 不管 直到max被删除 重新搜索
            maxIndex = i;
            for (int j = i-k+1; j <=i ; j++) {
                if(nums[j] >= nums[maxIndex]) maxIndex = j;
            }
        }
        res[i-k+1] = nums[maxIndex];
    }
    return res;
}
}
