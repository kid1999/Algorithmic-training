package lanqiao.final2020;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kid1999
 * @create 2020-11-14 17:18
 * @description TODO
 **/
//public class C {
//    static int n = 20000;
//    static int[] f = {0,1,0,-1,-1,0,1,0};
//    static boolean[][] vis;
//    static int res = 0;
//    public static void main(String[] args) {
//        vis = new boolean[n][n];
//        dfs(10000,10000,0);
//        dfs(12020,10011,0);
//        dfs(10011,10014,0);
//        dfs(12000,12000,0);
//        System.out.println(res);
//    }
//    public static void dfs(int i,int j,int d){
//        if(d == 20 || vis[i][j]) return;
//        vis[i][j] = true;
//        System.out.println(i + " " + j);
//        res++;
//        for (int k = 0; k <4 ; k++) {
//            dfs(i+f[2*k],i+f[2*k+1],d+1);
//        }
//    }
//}


public class C {
    static int n = 20000;
    static int[] f = {0,1,0,-1,-1,0,1,0};
    static boolean[][] vis;
    static int res = 0;
    public static void main(String[] args) {
        vis = new boolean[n][n];
        bfs(2020);
        System.out.println(res);
    }
    public static void bfs(int d){
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(10000,10000));
        q.add(new Pair<>(12020,10011));
        q.add(new Pair<>(10011,10014));
        q.add(new Pair<>(12000,12000));
        res += 4;
        while (d > 0){
            int size = q.size();
            for (int k = 0; k <size ; k++) {
                Pair<Integer,Integer> p = q.poll();
                int x = p.getKey();
                int y = p.getValue();
                vis[x][y] = true;
                for (int l = 0; l <4 ; l++) {
                    int tx = x+f[2*l];
                    int ty = y+f[2*l+1];
                    if(!vis[tx][ty]) {
                        vis[tx][ty] = true;
                        res++;
                        q.add(new Pair<>(tx,ty));
                    }
                }
            }
            d--;
        }
        System.out.println(res);
    }
}