package HDOJ.ccpc2020;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/23 0:07
 * @desc
 **/
public class P1002 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(prim(n,k));
        }
    }
    static long prim(int n,int k){
        long sum = 0;
        boolean[] vis = new boolean[n+1];
        int[]  dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        int[][] path = new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                path[i][j] = lcm(i,j);
            }
        }
        for (int i = 1; i <=n ; i++) {
            int u = -1;
            int gmin = Integer.MAX_VALUE;
            for (int j = 1; j <=n ; j++) {
                if(!vis[j] && dist[j] < gmin){
                    gmin = dist[j];
                    u = j;
                }
            }
            sum = (sum + gmin) % k;
            vis[u] = true;
            for (int j = 1; j <=n ; j++) {
                if(!vis[j]){
                    int new_dist = path[u][j];
                    dist[j] = Math.min(dist[j],new_dist);
                }
            }
        }
        return sum;
    }

    //求a、b的最小公倍数
    static int lcm(int a, int b){
        return a*b/gcd(a, b);
    }

    public static int gcd(int x,int y){
        if(x>y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        return x == 0 ? y : gcd(y%x,x);
    }
}
