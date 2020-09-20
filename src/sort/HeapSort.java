package sort;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * @author kid1999
 * @date 2020/9/17 22:48
 * @title 堆排序
 * 堆排序算法是不稳定的，基于交换的排序算法。
 * 基于二叉树 - 维护一个大顶堆/小顶堆。
 * 检查所有非终端节点是否满足 根 >= 左右节点，
 * 若不满足，将当前节点与更大的一个孩子互换
 * i 左孩子 -- 2i
 * i 右孩子 -- 2i+1
 * i 父节点 -- [i/2]
 *
 *  每次排序 选择元素最大的元素加入有序子序列
 *  然后再次调整大根堆，小元素下坠
 */

public class HeapSort {
    public static void main(String[] args) {
  	    int[] nums = {1,5,3,2,7,6,4,9,8};
        int k = 3;      // 队的size
//      javaHeapSort(arr,k);

	    heapSort(nums,nums.length-1);
	    System.out.println(Arrays.toString(nums));

    }

	// Java自带的堆排序  默认大顶堆
	public static void javaHeapSort(int[] arr,int k){
	PriorityQueue<Integer> q1 = new PriorityQueue<>(k);   // 维护小顶堆
	PriorityQueue<Integer> q = new PriorityQueue<>(k, (o1,o2)-> { return o2-o1; });// 维护大顶堆
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

	// 将以K为根的子树调整为大根堆
	public static void buildMaxHeap(int[] nums,int len){
		for (int i = len/2; i >=0 ; i--) {   // 往后调整所有非终端节点
			adjustHeap(nums,i,len);
		}
	}
	// 调整大根堆 -- 小元素下坠
	public static void adjustHeap(int[] nums,int k,int len){
    	int temp = nums[k];     // 暂存根节点
		for (int i = 2*k; i<=len ; i*=2) {     // 向下筛选
			if(i<len && nums[i] < nums[i+1]) i++;  //取key较大的子节点下标
			if(temp >= nums[i]) break;  // 筛选结束
			else {
				nums[k] = nums[i]; // 将nums[i]调整到双亲节点上
				k = i; //  修改key值一边继续向下筛选
			}
		}
		nums[k] = temp;
	}

	// 堆排序过程
	public static void heapSort(int[] nums,int len){
		buildMaxHeap(nums,len);
		for (int i = len; i >0 ; i--) {
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			adjustHeap(nums,0,i-1);
		}
	}

	// 插入元素

	// 删除元素

}
