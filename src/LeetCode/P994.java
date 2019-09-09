package LeetCode;

import java.util.LinkedList;
import java.util.Queue;


public class P994 {
	public static void main(String[] args) {
//		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//		int[][] grid = {{1},{2}};
				int[][] grid = {{0,2,2}};
		System.out.println(orangesRotting(grid));
	}
	public static int orangesRotting(int[][] grid) {
		class node{
			public int x;
			public int y;
		}

		Queue<node> q = new LinkedList<>();
		int len = 0;
		// 先加入 队列
		for (int i = 0; i <grid.length ; i++) {
			for (int j = 0; j <grid[i].length ; j++) {
				if(grid[i][j] == 2){
					node node = new node();
					node.x = j;
					node.y = i;
					q.offer(node);
					len++;
				}
			}
		}

		//
		int max = -1;	// 最终感染时间
		while (!q.isEmpty()){
			max++;
			int count = 0;	//下一轮数量
			for (int i = 0; i <len ; i++) {
				node node1 = q.poll();
				int x = node1.x;
				int y = node1.y;
				if (y+1<grid.length && grid[y+1][x]==1){
					grid[y+1][x] = 2;
					node node = new node();
					node.x = x;
					node.y = y+1;
					q.offer(node);
					count++;
				}
				if (y-1>= 0 && grid[y-1][x]==1){
					node node = new node();
					grid[y-1][x] = 2;
					node.x = x;
					node.y = y-1;
					q.offer(node);
					count++;
				}
				if (x+1< grid[y].length && grid[y][x+1]==1){
					node node = new node();
					grid[y][x+1] = 2;
					node.x = x+1;
					node.y = y;
					q.offer(node);
					count++;
				}
				if (x-1>=0 && grid[y][x-1]==1){
					node node = new node();
					grid[x-1][y] = 2;
					node.x = x-1;
					node.y = y;
					q.offer(node);
					count++;
				}
			}
			len = count;
		}

		// 最后扫描确认
		for (int i = 0; i <grid.length ; i++) {
			for (int j = 0; j <grid[i].length ; j++) {
				if(grid[i][j] == 1) return -1;
			}
		}
		if(max <0)return 0;
		else return max;
	}
}
