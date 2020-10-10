package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-10 22:49
 * @description TODO
 **/
public class P5729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int x = sc.nextInt();
        int h = sc.nextInt();
        boolean[][][] dp = new boolean[21][21][21];
        int n = sc.nextInt();
        for (int a = 0; a <n ; a++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int z2 = sc.nextInt();
            for (int i = x1; i <=x2 ; i++) {
                for (int j = y1; j <=y2; j++) {
                    for (int k = z1; k <=z2; k++) {
                        dp[i][j][k] = true;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <=w ; i++) {
            for (int j = 1; j <=x ; j++) {
                for (int k = 1; k <=h ; k++) {
                    if(!dp[i][j][k]) count++;
                }
            }
        }
        System.out.println(count);
    }
}

//1235