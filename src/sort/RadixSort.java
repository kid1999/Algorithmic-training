package sort;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/19 20:40
 * @title 基数排序
 * 不基于比较和移动，基于关键字各位大小排序
 * 如： 百位，十位，个位
 * 按关键字进行分配 最后再按序收集
 * O(关键字数量 * (N分配 + R收集))
 *
 * 适用于：
 * 可拆分关键字且取值范围不大，数据元素较多
 */

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {1,5,3,2,7,6,4,9,8,2};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	// 获取关键字数量 - 最大位数
	public static int getMaxLength(int[] nums){
		int maxNum = 0;
		for(int n:nums) maxNum = Math.max(maxNum,n);
		return ("" + maxNum).length();
	}
	// 基数排序
	public static void radixSort(int[] nums){
		int[][] temp = new int[10][nums.length];  //用于暂存数据的数组
		int[] counts = new int[10];   //用于记录temp数组中每个桶内存的数据的数量
		int n = 1;      // 记录数位
		int maxLength = getMaxLength(nums);    // 最大长度
		for (int i = 0; i < maxLength  ; i++) {
			// 按位 桶排 放到temp中 （分配）
			for (int j = 0; j < nums.length ; j++) {
				int num = (nums[j]/n) % 10;
				temp[num][counts[num]] = nums[j];
				counts[num]++;
			}
			n *= 10;
			// 从temp中取元素重新放到nums数组中，等待下一位的比较
			// （收集）
			int index = 0;
			for (int k = 0; k <counts.length ; k++) {
				for (int j = 0; j <counts[k] ; j++) {
					nums[index] = temp[k][j];
					index++;
				}
				counts[i] = 0;
			}
		}

	}
}
