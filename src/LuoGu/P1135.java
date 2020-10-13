package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-13 14:32
 * @description TODO
 **/
public class P1135 {
    static int minDep = Integer.MAX_VALUE;
    static int[] to = new int[205];
    static boolean[] vis = new boolean[205];
    static int n,a,b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            to[i] = sc.nextInt();
        }
        vis[a] = true;
        dfs(a,0);
        if(minDep != Integer.MAX_VALUE) System.out.println(minDep);
        else System.out.println(-1);
    }
    public static void dfs(int now,int dep){
        if(now == b) {
            minDep = Math.min(minDep,dep);
            return;
        }
        if(dep > minDep) return;
        vis[now] = true;
        int up = now+to[now];
        int down = now-to[now];
        if(up <= b && !vis[up]) dfs(up,dep+1);
        if(down >=1 && !vis[down]) dfs(down,dep+1);
        vis[a] = false;
    }
}