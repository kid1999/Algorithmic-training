package CCPC.test1;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <n ; i++) {
            int  m = sc.nextInt();
            int[][] nums = new int[m][2];
            for (int j = 0; j < m; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
            }
            int k = 100;
            int[] num = new int[k];
            for (int j = 0; j < k; j++) {
                num[j] = nums[0][0]*j + nums[0][1];
            }

            int ans = 0;
            boolean flag = false;
            for (int j = 0; j < k; j++) {
                if (flag){
                    System.out.println("No");
                    break;
                }
                int l;
                for (l = 1; l < m; l++) {
                    if(num[j]%nums[l][0] == nums[l][1]){
                        ans = num[j];
                        break;
                    }
                }
                if(l == m) flag = true;
            }
            System.out.println(ans);

        }

    }
}
