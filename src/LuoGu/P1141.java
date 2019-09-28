package LuoGu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1141 {
	static boolean[][] dp;
	static int[][] flag;
	static int[] fun;
	static int n;
	private static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		dp = new boolean[n+1][n+1];
		flag = new int[n+1][n+1];
		fun = new int[]{0,1,0,-1,1,0,-1,0};
		// 构架dP
		for (int i = 0; i <n ; i++) {
			String str = sc.next();
			for (int j = 0; j <n ; j++) {
				dp[i][j] = str.charAt(j) == '0';
			}

		}
		// 访问答案
		for (int i = 0; i <m ; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			if (flag[x][y] == 0){
				List<Node> res = new ArrayList<>();
				DFS(x, y,res);
				for (Node node:res) {
					flag[node.x][node.y] = res.size();
				}
			}
			System.out.println(flag[x][y]);
		}
	}
	public static void DFS(int i, int j, List<Node> used){
		if(i<0 || i>=n || j<0 || j>=n) return;
		used.add(new Node(i,j));
		flag[i][j] = 1;
		for (int k = 0; k <4 ; k++) {
			int x = i+fun[2*k],y = j+fun[2*k+1];
			if(x>=0 && x<n && y>=0 && y<n && dp[x][y] != dp[i][j] && flag[x][y] == 0) DFS(x,y,used);
		}
	}
}
