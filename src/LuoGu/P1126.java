package LuoGu;

import java.util.Scanner;

public class P1126 {
	static int[][] nums;    // 图
	static int[][][] dp;    // 图的状态
	static int[] node;      // 始末节点
	static int res = -1;    // 最终答案
	static int[] funs;      // 方向数组
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		nums = new int[n+1][m+1];
		dp = new int[n+1][m+1][8];    // 4个方向状态
		// 读取数据 处理为点数组
		for (int i = 0; i <n ; i++) {
			for (int j = 0; j <m ; j++) {
				int num = sc.nextInt();
				if(num == 1){
					nums[i][j] = 1;
					nums[i+1][j] = 1;
					nums[i][j+1] = 1;
					nums[i+1][j+1] = 1;
				}
			}
		}
		// 处理边界位1
		for (int i = 0; i <=n ; i++) {
			nums[i][0] = 1;
			nums[i][m] = 1;
		}
		for (int i = 0; i <=m ; i++) {
			nums[0][i] = 1;
			nums[n][i] = 1;
		}
		funs = new int[]{-1,0,1,0,0,-1,0,1};  //方向数组
		// 搞定 始末坐标
		node = new int[4];
		for (int i = 0; i <4 ; i++) {
			node[i] = sc.nextInt();
		}
		String word = sc.next();    // 方向
		int to = 0;                 // 方向变量
		switch (word){
			case "N":{to = 0;break;}
			case "S":{to = 2;break;}
			case "W":{to = 4;break;}
			case "E":{to = 6;break;}
		}
		dfs(node[0],node[1],0,to);      //搜索
		System.out.println(res);
	}
	public static boolean dfs(int i,int j,int count,int to){
		if(i<0 || i>=nums.length || j<0 || j>=nums[0].length ||nums[i][j] == 1) return false;   //边界
		if(i==node[2] && j==node[3]){           //终点
			if(res == -1 || res>count) res =count;
			return true;
		}
		dp[i][j][to] = 1;     //保存状态 这种状态已存在
		// 向前 走 n 步
		boolean flag = dfs(i+funs[to],j+funs[to+1],count+1,to);
		if(flag) flag = dfs(i+funs[to]*2,j+funs[to+1]*2,count+1,to);
		if(flag) dfs(i+funs[to]*3,j+funs[to+1]*3,count+1,to);
		// 转弯
		if(to == 0 || to == 2){
			if(dp[i][j][4]!=1)dfs(i,j,count+1,4);
			if(dp[i][j][6]!=1)dfs(i,j,count+1,6);
		}
		if(to==4 || to==6){
			if(dp[i][j][0]!=1)dfs(i,j,count+1,0);
			if(dp[i][j][2]!=1)dfs(i,j,count+1,2);
		}
		return true;
	}
}