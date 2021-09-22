package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kid1999
 * @create 2021-08-02 15:47
 * @description TODO
 **/

public class P743 {

    // 基于优先队列的Dijkstra算法
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[][] weight = new int[n+1][n+1];
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=n ; j++) {
                weight[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] arr : times){
            weight[arr[0]][arr[1]] = arr[2];
        }
        int[] res = solution(weight,k);
        res[k] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <res.length ; i++) {
            if (res[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max,res[i]);
        }
        return max;
    }

    private static int[] solution(int[][] weight, int start) {
        boolean[] visit = new boolean[weight.length]; // 标记某节点是否被访问过
        int[] res = new int[weight.length];     // 记录 start 点到各点的最短路径长度
        for (int i = 0; i < res.length; i++) {
            res[i] = weight[start][i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        for(int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            // 找出一个未标记的离出发点最近的节点
            for(int j = 0; j < weight.length; j++){
                if(j != start && !visit[j] && res[j] < min){
                    min = res[j];
                    p = j;
                }
            }
            // 标记该节点为已经访问过
            visit[p] = true;

            for (int j = 0; j < weight.length; j++){
                if (j == p || weight[p][j] == Integer.MAX_VALUE) {  // p 点不能到达 j
                    continue;
                }
                if (res[p] + weight[p][j] < res[j]){
                    res[j] = res[p] + weight[p][j];  //更新最短路径
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        networkDelayTime(times,4,2);
    }

}