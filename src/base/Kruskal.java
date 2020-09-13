package base;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kid1999
 * @date 2020/9/13 19:18
 * @title Kruskal 最小生成树  --- 适用于稀疏图 O（mlogm）
 *
 *  * leetcode 5513题：连接所有点的最小费用
 *  *
 *  * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *  *
 *  * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *  *
 *  * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Kruskal {

	static class Edge implements Comparable<Edge>{
		int x,y,len;

		public Edge(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.len,o.len);
		}
	}

	int[] f ; //并查集find数组

	public int find(int x) {    //find函数，判断是否同一个root节点
		return f[x] == x ? x : find(f[x]);
	}

	public int minCostConnectPoints(int[][] points) {
		int h = points.length;
		f=new int[h+1];
		for (int i = 0; i < f.length; i++) {//初始化find数组，让初始每个节点都自成一个集合，互相不联通
			f[i]=i;
		}
		ArrayList<Edge> edges = new ArrayList<>();
		//求边长
		for (int i = 0; i < h; i++) {
			for (int j = i + 1; j < h; j++) {
				int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				if (len != 0) {
					edges.add(new Edge(i, j, len));
				}
			}
		}
		int ans =0;
		Collections.sort(edges);
		for(Edge e:edges){
			int x=e.x;
			int y =e.y;
			int len = e.len;
			if(find(x)==find(y)) { //如果两个节点是同一个集合中，说明之前已经有其他路径连过了
				continue;
			}
			ans+=len;
			f[find(x)] = find(y);//把两集合合并
		}
		return ans;
	}

}
