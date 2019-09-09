package LuoGu;

import java.util.Scanner;

public class P1908 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        // 执行归并 计算逆序数
        mergeSort(nums,0,nums.length-1);
        System.out.println(res);

    }

    public static void mergeSort(int[] nums,int L ,int R){
        // 如果只有一个元素不用排序
        if(L >= R) return;
        else{
            int M = (L+R) >>1;
            mergeSort(nums,L,M);
            mergeSort(nums,M+1,R);

            // 合并
            merge(nums,L,M,R);
        }
    }

    public static void merge(int[] nums,int L,int M,int R){
        int[] tmp = new int[R-L+1];
        int index = 0;
        int right = M+1;
        int left = L;
//        System.out.println(L +" " + M + " " + R + " " + tmp.length);
        while(left<=M && right<=R){
            if(nums[left]<=nums[right]) tmp[index++] = nums[left++];
            else{
                tmp[index++] = nums[right++];
                res += M-left+1;            // 求逆序数
            }

        }

        while(left<=M){
            tmp[index++] = nums[left++];
        }
        while (right<=R){
            tmp[index++] = nums[right++];
        }

        // 还原数据到原数组中
        for (int i = 0; i <tmp.length ; i++) {
            nums[L +i] = tmp[i];
        }
    }

}
