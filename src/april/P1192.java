package april;

import java.util.Scanner;

public class P1192 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && (i-j)>=0; j++) {      // 类似当k=2时 t(n) = t(n-1) + t(n-2)
                nums[i] += nums[i-j];                   // 此时是t(n) = t(n-j) 当j满足时候的所有情况相加
            }
            nums[i] = nums[i]%100003;
        }
        System.out.println(nums[n]);
    }
}
