package LeetCode;

import javax.sound.midi.MidiSystem;
import java.util.*;

/**
 * @author kid1999
 * @date 2020/9/13 10:18
 * @desc
 **/
public class week206 {
    public static void main(String[] args) {
//        {2,1,3},{0,3,2},{1,0,3},{2,0,1}
//        {1,2,3},{3,2,0},{3,1,0},{1,2,0}
//        int[][] arr = {
//                {1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}
//        };
//        int[][] arr2 = {{1,3},{2,0}};
//        System.out.println(unhappyFriends(4,arr,arr2));

                int[][] arr = {
                        {2,-3},{-17,-8},{13,8},{-17,-15}
        };
        System.out.println(minCostConnectPoints(arr));
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
    static class  Node {
        int x;
        int y;
        int distence;
        public Node(int x, int y, int distence) {
            this.x = x;
            this.y = y;
            this.distence = distence;
        }
    }
    // kruskal
//    public static int minCostConnectPoints(int[][] ps) {
//        int len = ps.length;
//        int res = 0;
//        List<Node> list = new ArrayList<>();
//        for (int i = 0; i <len ; i++) {
//            for (int j = i+1; j <len ; j++) {
//                list.add(new Node(i,j,compute(ps[i][0],ps[i][1],ps[j][0],ps[j][1])));
//            }
//        }
//        Set<Integer> set = new HashSet<>();
//        list.sort((Node o1, Node o2)-> {
//                return o1.distence - o2.distence;
//            });
//        for (Node node:list) {
//            if(set.contains(node.x) && set.contains(node.y)) continue;
//            else {
//                set.add(node.x);
//                set.add(node.y);
//                res += node.distence;
//            }
//        }
//        return res;
//    }

    // Prim  runtime error
    public static int minCostConnectPoints(int[][] ps) {
        int len = ps.length;
        int res = 0;
        boolean[] vis = new boolean[len];
        List<Integer> queue = new ArrayList<>();
        queue.add(0);
        vis[0] = true;
        while (queue.size() < len){
            int size = queue.size();
            int min = Integer.MAX_VALUE;
            int node = 0;
            for (int l = 0;l<size;l++) {
                int i = queue.get(l);
                for (int j = 0; j <len ; j++) {
                    int dis = compute(ps[i][0],ps[i][1],ps[j][0],ps[j][1]);
                    if(!vis[j] && dis < min){
                        min = dis;
                        node = j;
                    }
                }
            }
            if(min != Integer.MAX_VALUE){
                System.out.println(node + " " + min);
                vis[node] = true;
                res += min;
                queue.add(node);
            }
        }
        return res;
    }
    public static int compute(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }


    // 4
}
