package sort;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/18 16:55
 * @title 选择排序
 * 选择算法是不稳定的，基于交换的排序算法。
 * 每次排序，选择最小的元素加入有序子序列队尾
 */

public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {1,5,3,2,7,6,4,9,8,2};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] nums){
		int n = nums.length;
		for (int i = 0; i < n ; i++) {
			int min = i;
			for (int j = i+1; j <n ; j++) {
				if (nums[j] < nums[min]) min = j;
			}
			if(min != i){
				int temp = nums[min];
				nums[min] = nums[i];
				nums[i] = temp;
			}
		}
	}


}
