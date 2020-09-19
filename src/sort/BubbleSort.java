package sort;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/18 16:36
 * @title 冒泡排序
 * 冒泡算法是稳定的，基于交换的排序算法。
 * 每次排序，挨个对比选择交换
 */

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {1,5,3,2,7,6,4,9,8,2};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] nums){
		int n = nums.length;
		for (int i = 0; i <n ; i++) {
			boolean flag = false;
			for (int j = 0; j < n-i-1 ; j++) {
				if (nums[j] > nums[j+1]){
					int temp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = temp;
					flag = true;
				}
			}
			if (!flag) return;
		}
	}

}
