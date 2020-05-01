package acWing;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/1 10:08
 **/
public class 二维费用背包 {
    // 在重量的基础上 限制体积
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();   // 重量
        int v = sc.nextInt();   // 体积
        int[][] dp = new int[w+1][v+1];
        for (int i = 0; i <n ; i++) {
            int weight = sc.nextInt();
            int volume = sc.nextInt();
            int value = sc.nextInt();
            for (int j = w; j >=weight ; j--) {
                for (int k = v; k >=volume ; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j-weight][k-volume]+value);
                }
            }
        }
        System.out.println(dp[w][v]);
    }

}
