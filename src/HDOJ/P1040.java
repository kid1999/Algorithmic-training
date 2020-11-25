package HDOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-19 20:28
 * @description TODO
 **/
public class P1040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[] nums = new int[t];
            for (int j = 0; j <t ; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            for (int j = 0; j <t ; j++) {
                if(j != t-1) System.out.print(nums[j] + " ");
                else System.out.println(nums[j]);
            }
        }
    }
}