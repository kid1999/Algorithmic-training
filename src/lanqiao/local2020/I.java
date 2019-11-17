package lanqiao.local2020;

import java.util.Scanner;

public class I {

	static boolean[][] vis;
	static int[][] dp;
	static int n,m;
	static double size; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		size = sc.nextDouble();
		vis = new boolean[n+1][m+1];
		dp = new int[n+1][m+1];
		System.out.println(dfs(1,1));
	}
	public static int dfs(int i,int j){
		if(i==n&&j==m) return 0;
		if(dp[i][j] != 0) return dp[i][j];
		int min = Integer.MAX_VALUE;
		for(int x=0;x<=n-i;x++){     // 搜索策略
			for(int y=0;y<=m-j;y++){
				if(Math.sqrt((x*x) + (y*y)) > size) break;
				if(!vis[i+x][j+y]) {
					vis[i+x][j+y] = true;
					min = Math.min(min, dfs(i+x,j+y));
					vis[i+x][j+y] = false;
				}	
			}
		}
		dp[i][j] = min+1;    // 保存最短路径
		return min + 1;
	}

}
