package base;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/13 20:26
 * @title Disjoint 并查集
 */

public class Disjoint {

	public static void main(String[] args) {
		int[][] edges = {
				{0,1},{1,2},{1,3},
				{3,2},{2,4}
		};
		int len = (int) 1e5;
		int[] parents = new int[len];
		Arrays.fill(parents,-1);    // 初始化

		// xxxx  其他操作

		for (int[] edge:edges) {
			int x = edge[0];
			int y = edge[1];
			if(union(x,y,parents)){
				// 如果是相同的的父节点 说明已经是同一个集合
				// 再加入就是环了！！！
				System.out.println("find cycle.");
				return;
			}
		}
		System.out.println("not find cycle.");
	}

	// 查找根节点
	public static int find_root(int x, int[] parents){
		int x_root = x;
		while (parents[x_root] != -1){
			x_root = parents[x_root];
		}
		return x_root;
	}

	// 合并两个集合
	public static boolean union(int x,int y,int[] parents){
		int x_root = find_root(x,parents);
		int y_root = find_root(y,parents);
		if(x_root != y_root){
			parents[x_root] = y_root;      // 将x合并到y中
			return false;
		}else return true;
	}
}
