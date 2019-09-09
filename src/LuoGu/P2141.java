package LuoGu;

import java.util.Arrays;
import java.util.Scanner;

public class P2141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int i,res = 0;
        for(i=2;i<n;i++) {
            for (int j = 0; j < i-1; j++) {
                for (int k=j+1; k < i; k++) {
                    if (nums[j] + nums[k] == nums[i]){
                        res++;
                        System.out.println(nums[j]+"+"+nums[k]+"="+nums[i]);
                    }

                }
            }
        }
        System.out.println(res);
        //worring.......30
    }
}
