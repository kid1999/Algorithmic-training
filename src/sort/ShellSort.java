package sort;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/17 23:21
 * @title 希尔排序
 *  相当于通过改变步进 逐渐实现对数组的排序
 *  基于插入排序
 *
 */

public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {1,5,3,2,7,6,4,9,8,2};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// 希尔排序
	public static void shellSort(int[] nums){
		int dep;    // 步长 默认n/2
		int i,j,temp,n = nums.length;
		for(dep = n/2;dep>=1;dep/=2){
			for (i = dep+1; i < n ; i++) {
				if(nums[i] < nums[i-1]){
					temp = nums[i];
					for(j = i-dep;j>=0 && temp<nums[j];j-=dep){   // 此处dep相当于原来插入排序的i
						nums[j+dep] = nums[j];
					}
					nums[j+dep] = temp;
				}
			}
		}
	}
}
