package LuoGu;

import java.util.Scanner;

/**
 * @auther: kid1999
 * @date: 2019/11/29 9:30
 * @desc: P1091
 **/
public class P1091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        int[] left = new int[n+1];
        for (int i = 0; i <n ; i++) {
            int count = 1;
            for (int j = i; j >=0 ; j--) {
                if(nums[j] < nums[i]){
                    count = Math.max(count,left[j] + 1);
                }
            }
            left[i] = count;
        }

        int[] right = new int[n+1];
        for (int i = n-1; i>=0; i--) {
            int count = 1;
            for (int j = i; j <=n-1 ; j++) {
                if(nums[j] < nums[i]){
                    count = Math.max(count,right[j] + 1);
                }
            }
            right[i] = count;
        }

        int res = 0;
        for (int i = 0; i <n ; i++) {
            res = Math.max(res,left[i] + right[i]);
        }
        System.out.println(n - res + 1);
    }
}
