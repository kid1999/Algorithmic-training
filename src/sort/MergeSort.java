package sort;

import java.util.ArrayList;
import java.util.List;


/**
 * @author kid1999
 * @date 2020/9/17 22:48
 * @title 归并排序
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,9,3,7,6,4,2,1,8};
        for (int n:nums) {
            System.out.print(n + " ");
        }
        System.out.println();
        sort(nums,0,nums.length-1);

        for (int n:nums) {
            System.out.print(n + " ");
        }
    }

    private static void sort(int[] nums,int L,int R){
        if (L >= R) return;

        int mid = (L+R) >> 1;
        sort(nums,L,mid);       // 往两边分
        sort(nums,mid+1,R);
        merge(nums,L,mid,R);    // 合并已经排好序的两个数组
    }
    private static void merge(int[] nums,int L,int mid,int R){
        List<Integer> tmp = new ArrayList<>();
        int left = L;
        int right = mid +1;
        while (left<=mid && right <= R){        // 只要左边数组 或右边数组还没选完
            if (nums[left] <= nums[right]){     // 从两个数组中 选择最小的 放入 临时数组中
                tmp.add(nums[left++]);
            }else{
                tmp.add(nums[right++]);
            }
        }
        while (left<=mid) tmp.add(nums[left++]);    // 将剩下的数组元素 全部放入临时数组
        while (right<=R) tmp.add(nums[right++]);

        int j = L;
        for (int num:tmp) {         // 将临时数组中的元素放回数组中
            nums[j++] = num;
        }
        tmp.clear();        // 清空临时数组
    }


}
