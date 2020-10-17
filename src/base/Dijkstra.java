package base;

/**
 * @author kid1999
 * @create 2020-10-16 23:22
 * @description Dijkstra算法 -- 单源最短路径
 * 通过Dijkstra计算图G中的最短路径时，需要指定起点s(即从顶点s开始计算)。
 *
 * (1) 初始时，S只包含起点s；U包含除s外的其他顶点，且U中顶点的距离为"起点s到该顶点的距离"[例如，U中顶点v的距离为(s,v)的长度，然后s和v不相邻，则v的距离为∞]。
 *
 * (2) 从U中选出"距离最短的顶点k"，并将顶点k加入到S中；同时，从U中移除顶点k。
 *
 * (3) 更新U中各个顶点到起点s的距离。之所以更新U中顶点的距离，是由于上一步中确定了k是求出最短路径的顶点，从而可以利用k来更新其它顶点的距离；例如，(s,v)的距离可能大于(s,k)+(k,v)的距离。
 *
 * (4) 重复步骤(2)和(3)，直到遍历完所有顶点。
 *
 *
 *  总结  :  就是很像Prim，也是每次寻找最近的点，然后更新距离
 **/

public class Dijkstra {

    private static int[] dijkstra(int[][] weight, int start) {
        int len = weight.length;
        boolean[] visit = new boolean[len]; // 标记某节点是否被访问过
        int[] res = new int[len];     // 记录 start 点到各点的最短路径长度
        for (int i = 0; i < len; i++) {
            res[i] = weight[start][i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        for(int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            // 找出一个未标记的离出发点最近的节点
            for(int j = 0; j < len; j++){
                if(j != start && !visit[j] && res[j] < min){
                    min = res[j];
                    p = j;
                }
            }
            // 标记该节点为已经访问过
            visit[p] = true;
            for (int j = 0; j < len; j++){
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
}