package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class heapSort {
  public static void main(String[] args) {
    int[] arr = {1,5,3,2,7,6,4,9,8};
    int k = 3;      // 队的size
    PriorityQueue<Integer> q1 = new PriorityQueue<>(k);   // 维护小顶堆
    PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {   // 维护大顶堆
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    for (int i = 0; i <9 ; i++) {
      if(q.size() < k) q.add(arr[i]);
      else if(arr[i] < q.peek()){
        q.poll();
        q.add(arr[i]);
      }
    }
    for (int i = 0; i <k ; i++) {
      System.out.println(q.poll());
    }
  }
}
