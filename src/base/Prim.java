package base;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/13 19:18
 * @title Prim  最小生成树  --- 适用于稠密图 O（n^2）
 *
 * leetcode 5513题：连接所有点的最小费用
 *
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Prim {

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
}

