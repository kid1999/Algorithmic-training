package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/23 9:36
 **/
public class T571 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[11];
        for (int i = 0; true; i++) {
            int n = sc.nextInt();
            if(n == 0) break;
            arr[i] = n;
        }
        quick_sort(arr,0,arr.length-1);
        for (int num:arr) {
            if(num == 0) continue;
            System.out.print(num + " ");
        }
    }
    public static void quick_sort(int[] arr,int l , int r){
        if(l>=r) return;
        int m = arr[l+r>>1],left = l-1,right = r+1;
        while (left<right){
            do left++; while (arr[left] < m);
            do right--; while (arr[right] >m);
            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        quick_sort(arr,l,right);
        quick_sort(arr,right+1,r);
    }
}
