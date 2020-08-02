package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/8/2 10:27
 **/
public class week200 {
    public static void main(String[] args) {
        int[] arr = {};

        System.out.println();
    }

    // 1
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int len = arr.length;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j <len ; j++) {
                for (int k = j+1; k < len; k++) {
                    if(Math.abs(arr[i]- arr[j]) <= a
                    && Math.abs(arr[j] - arr[k]) <= b
                    && Math.abs(arr[i] - arr[k]) <= c
                    && i!=j && j!=k && k!=i){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    // 2
    public int getWinner(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            deque.addLast(i);
            max = Math.max(max,i);
        }
        if(k>=arr.length){
            return max;
        }
        int num = Integer.MAX_VALUE,count = 0;
        while (count < k){
            int a = deque.pollFirst();
            int b = deque.pollFirst();
            if(a>b){
                if(num == a) count++;
                else count = 1;
                num = a;
                deque.offerFirst(a);
                deque.offerLast(b);
            }else{
                if(num == b) count++;
                else count = 1;
                num = b;
                deque.offerFirst(b);
                deque.offerLast(a);
            }
        }
        return num;
    }

    // 3
    public int minSwaps(int[][] grid) {
        int[] f = new int[grid.length];
        for (int i = 0; i <grid.length ; i++) {
            int count = 0;
            for (int j = grid[0].length-1; j >=0 ; j--) {
                if(grid[i][j] == 0) count++;
                else break;
            }
            f[i] = count;
        }
        int res = 0,j;
        int len = f.length;
        for (int i = 0; i <len ; i++) {
            boolean flag = true;
            for (j = i; j <len ; j++) {
                if(f[j] >= len-i-1){
                    flag = false;
                    break;
                }
            }
            if(flag) return -1;
            for (int k = j; k >i ; k--) {
                swap(f,k,k-1);
                res++;
            }
//            for (int c : f) {
//                System.out.print(c);
//            }
//            System.out.println();
        }
        return res;
    }
    public void swap(int[] f,int i,int j){
        int temp = f[i];
        f[i] = f[j];
        f[j] = temp;
    }

    // 4

}
