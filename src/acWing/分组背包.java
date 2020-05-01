package acWing;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/1 10:40
 **/
public class 分组背包 {
    // 在01背包的基础上 划分组
    // 相当于 多重背包的 普遍情况
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] dp = new int[w+1];
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] weight = new int[len+1];
            int[] values = new int[len+1];
            for (int j = 0; j <len ; j++) {
                weight[j] = sc.nextInt();
                values[j] = sc.nextInt();
            }
            for (int j = w; j >=0 ; j--) {
                for (int k = 0; k < len; k++) {
                    if(j >= weight[k]) dp[j] = Math.max(dp[j],dp[j-weight[k]]+values[k]);
                }
            }
        }
        System.out.println(dp[w]);
    }
}
