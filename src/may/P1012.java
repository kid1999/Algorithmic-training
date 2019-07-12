package may;

import java.util.Arrays;
import java.util.Scanner;

public class P1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            System.out.print(nums[i]);
        }

    }
}
