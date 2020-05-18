package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/18 8:53
 **/
public class P315 {
    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        System.out.println(countSmaller(arr));
    }

    static Integer[] arr;
    static int[] index;
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        index = new int[nums.length];
        arr = new Integer[nums.length];
        Arrays.fill(arr,0);
        for (int i = 0; i < nums.length; i++) index[i] = i;
        merge_sort(nums,0,nums.length-1);
        return Arrays.asList(arr);
    }


    static void merge_sort(int[] nums,int l,int r){
        if(l>=r) return;
        int mid = l+r>>1;
        merge_sort(nums,l,mid);
        merge_sort(nums,mid+1,r);
        int[] tmp = new int[r-l+1];
        int k=0,left=l,right=mid+1;
        while (left<=mid && right<=r){
            if(nums[index[left]] <= nums[index[right]]){
                arr[index[left]] += right-mid-1;    // 前面的数出来时 计算后面的比他小的数有几个
                tmp[k++] = index[left++];
            }else{
                tmp[k++] = index[right++];
            }
        }
        while (left<=mid){
            arr[index[left]] += r-mid;  //  后面的走完了，前面还剩的数直接加上后面数组的长度 都是比他小的
            tmp[k++] = index[left++];
        }
        while (right<=r) tmp[k++] = index[right++];
        for (int n:tmp) index[l++] = n;
    }
}
