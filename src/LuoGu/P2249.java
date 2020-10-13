package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-12 14:30
 * @description TODO
 **/
public class P2249 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            dp[i] = sc.nextInt();
        }
        for (int i = 1; i <=m ; i++) {
            int num = sc.nextInt();
            int res = find(dp,num);
            if(i != m) System.out.print(res+ " ");
            else System.out.print(res);
        }
    }

    public static int find(int[] dp,int num){
        int l = 1, r = dp.length-1;
        while (l<r){
            int m = (l+r)>>1;
            if(dp[m] < num) l = m+1;
            else r = m;
        }
        if(dp[l] == num) return l;
        else return -1;
    }

}