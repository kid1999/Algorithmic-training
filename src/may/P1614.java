package may;

import java.util.Scanner;

public class P1614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        for (int i = m; i <n ; i++) {
            if(sum<min) min = sum;
            nums[i] = sc.nextInt();
            sum = sum + nums[i] - nums[i-m];
        }
        if(sum<min) min = sum;
        if(n == m) System.out.println(sum);
        else System.out.println(min);
    }
}
