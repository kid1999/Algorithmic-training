package sort;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/17 22:48
 * @title  插入排序
 *  插入排序是稳定的，基于插入排序的排序算法。
 *  每次排序，将该元素加入有序子序列
 */

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {1,5,3,2,7,6,4,9,8,2};
		insertSortWithBinary(arr);
		System.out.println(Arrays.toString(arr));
	}


	// 插入排序
	public static void insertSort(int[] nums){
		int i,j,temp;
		for (i = 1; i <nums.length ; i++) {
			if(nums[i] < nums[i-1]){
				temp = nums[i];
				for (j = i-1; j >=0 && nums[j] > temp; j--) {
					nums[j+1] = nums[j];    // 往后推
				}
				nums[j+1] = temp;
			}
		}
	}

	// 基于二分搜索优化的插入排序  其实也没用 最后还是要挪元素....
	public static void insertSortWithBinary(int[] nums){
		int i,j,temp,l,r,mid;
		for (i = 1; i <nums.length ; i++) {
			if(nums[i] < nums[i-1]){
				temp = nums[i];
				l = 0;r = i-1;
				while (l<=r){       // 搜索插入位置
					mid = (l+r) >> 1;
					if(nums[mid] > temp) r = mid-1;
					else l = mid+1;
				}
				for (j = i-1; j>=r+1 ; j--) {
					nums[j+1] = nums[j];    // 往后推
				}
				nums[j+1] = temp;
			}
		}
	}
}
