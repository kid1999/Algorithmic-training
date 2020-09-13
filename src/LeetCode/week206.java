package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kid1999
 * @date 2020/9/13 10:18
 * @desc
 **/
public class week206 {
    public static void main(String[] args) {

    }

    // 1
    public static int numSpecial(int[][] mat) {
        int res = 0;
        int len = mat.length;
        int len2 = mat[0].length;
        int[] x = new int[len];
        int[] y = new int[len2];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len2 ; j++) {
                x[i] += mat[i][j];
            }
        }
        for (int i = 0; i <len2 ; i++) {
            for (int j = 0; j <len ; j++) {
                y[i] += mat[j][i];
            }
        }
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len2 ; j++) {
                if(mat[i][j] == 1 && x[i] == 1 && y[j] == 1) res++;
            }
        }
        return res;
    }

    // 2
    static boolean[][] vis;
    static boolean[] find;
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int res = 0;
        find = new boolean[n];
        vis = new boolean[n][n];
        for (int[] pair:pairs) {
            int x = pair[0];
            int y = pair[1];
            vis[x][y] = true;
            vis[y][x] = true;
        }
        for (int[] pair:pairs) {
            int x = pair[0];
            int y = pair[1];
            res += judge(preferences,x,y);
            res += judge(preferences,y,x);
        }
        return res;
    }
    public static int judge(int[][] ps,int x,int y){
        List<Integer> u = new ArrayList<>();
        for (int n:ps[x]) {
            if(n == y) break;
            u.add(n);
        }
        int count = 0;
        for (int n:u) {
            for (int m:ps[n]) {
                if(vis[n][m]) break;
                if(m == x && !find[m]){
                    find[m] = true;
                    count++;break;
                }
            }
        }
        return count;
    }

    // 3
    public int minCostConnectPoints(int[][] ps) {
        int len = ps.length;
        int res = 0;
        boolean[] vis = new boolean[len];
        int[] min_dist = new int[len];
        Arrays.fill(min_dist,Integer.MAX_VALUE);
        min_dist[0] = 0;
        for (int i = 0; i <len ; i++) {         // 每次选取最小距离的点访问
            int u = -1;
            int gmin = Integer.MAX_VALUE;
            for (int j = 0; j <len ; j++) {
                if(!vis[j] && min_dist[j] < gmin){
                    gmin = min_dist[j];
                    u  = j;
                }
            }
            res += gmin;
            vis[u] = true;
            for (int j = 0; j <len ; j++) {     // 更新当前加入点 与 其他没加入点的最小距离
                if(!vis[j]){
                    int new_dist = Math.abs(ps[j][0] - ps[u][0]) + Math.abs(ps[j][1] - ps[u][1]);
                    min_dist[j] = Math.min(min_dist[j],new_dist);
                }
            }
        }
        return res;
    }



//    // Prim  runtime error  没有保存最小距离 导致每次都计算 超时
//    public static int minCostConnectPoints(int[][] ps) {
//        int len = ps.length;
//        int res = 0;
//        boolean[] vis = new boolean[len];
//        List<Integer> queue = new ArrayList<>();
//        queue.add(0);
//        vis[0] = true;
//        while (queue.size() < len){
//            int size = queue.size();
//            int min = Integer.MAX_VALUE;
//            int node = 0;
//            for (int l = 0;l<size;l++) {
//                int i = queue.get(l);
//                for (int j = 0; j <len ; j++) {
//                    int dis = compute(ps[i][0],ps[i][1],ps[j][0],ps[j][1]);
//                    if(!vis[j] && dis < min){
//                        min = dis;
//                        node = j;
//                    }
//                }
//            }
//            if(min != Integer.MAX_VALUE){
//                System.out.println(node + " " + min);
//                vis[node] = true;
//                res += min;
//                queue.add(node);
//            }
//        }
//        return res;
//    }
    public static int compute(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }


    // 4
}
