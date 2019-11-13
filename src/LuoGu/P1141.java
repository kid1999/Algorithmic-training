package LuoGu;


import java.util.Scanner;

public class P1141{
	static int[][] f;
	static boolean[][] s;
	static int n,m;
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		s = new boolean[n][n];
		f = new int[n][n];
		res = new int[m+5];
		for (int i = 0; i <n ; i++) {
			String str = sc.next();
			for (int j = 0; j <n ; j++) {
				s[i][j] = str.charAt(j) == '0';
			}
		}
		for (int i = 1; i <=m ; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			if (f[x][y] == 0) dfs(x,y,s[x][y],i);
			else res[i] = res[f[x][y]];
		}

		for (int i = 1; i <=m ; i++) {
			System.out.println(res[i]);
		}

	}
	public static void dfs(int i,int j,boolean pre,int index){
		if (i<0 || i>=n || j<0 || j>=n || f[i][j] != 0 || s[i][j] != pre) return;
		f[i][j] = index;
		res[index]++;
		dfs(i-1,j,!pre,index);
		dfs(i+1,j,!pre,index);
		dfs(i,j+1,!pre,index);
		dfs(i,j-1,!pre,index);
	}
}




/**

//  DFS + 记忆化 + bufferreder 优化读写

import java.io.*;
public class P1141 {
	static int n;
	static boolean[][] dp;	// 原图
	static int[][] vis;		// 按联通集 染色 并 记录
	static int[] fun;
	static int[] ans;		//记录之前 联通集的 ans
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Documents\\GitHub\\Algorithmic-training\\data\\testdata (1).in")));
		String s[] = new String[0];
		try {
			s = bf.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		n = Integer.valueOf(s[0]);
		int m = Integer.valueOf(s[1]);
		dp = new boolean[n][n];
		vis = new int[n][n];
		ans = new int[m+5];
		fun = new int[]{0,1,0,-1,1,0,-1,0};
		// 构架dP
		for (int i = 0; i <n ; i++) {
			String str = null;
			try {
				str = bf.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int j = 0; j <n ; j++) {
				dp[i][j] = str.charAt(j) == '0';
			}
		}
		// 访问答案
		for (int i = 1; i <=m ; i++) {
			String ss[] = new String[0];
			try {
				ss = bf.readLine().split(" ");
			} catch (IOException e) {
				e.printStackTrace();
			}
			int x = Integer.valueOf(ss[0])-1;
			int y = Integer.valueOf(ss[1])-1;
			if (vis[x][y] == 0) DFS(x,y,i);		//未被访问过
			else ans[i] = ans[vis[x][y]];		// 已访问 vis 记录联通的结果保存在哪里
		}
		for (int j = 1; j <= m ; j++) {
			System.out.println(ans[j]);
		}
	}
	public static void DFS(int i, int j,int index){
		vis[i][j] = index;
		ans[index]++;
		for (int k = 0; k <4 ; k++) {
			int x = i+fun[2*k],y = j+fun[2*k+1];
			// 坐标合理 且未被访问过 与当前值不同
			if(x>=0 && x<n && y>=0 && y<n && vis[x][y] == 0 && dp[x][y] != dp[i][j]){
				DFS(x,y,index);
			}
		}
	}
}



// DFS + 记忆化

public class Main {
	static int n;
	static boolean[][] dp;
	static int[][] vis;
	static int[] fun;
	static int[] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		dp = new boolean[n][n];
		vis = new int[n][n];
		ans = new int[m+5];
		fun = new int[]{0,1,0,-1,1,0,-1,0};
		// 构架dP
		for (int i = 0; i <n ; i++) {
			String str = sc.next();
			for (int j = 0; j <n ; j++) {
				dp[i][j] = str.charAt(j) == '0';
			}
		}
		// 访问答案
		for (int i = 1; i <=m ; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			if (vis[x][y] == 0) DFS(x,y,i);
			else ans[i] = ans[vis[x][y]];
		}
		for (int j = 1; j <= m ; j++) {
			System.out.println(ans[j]);
		}
	}
	public static void DFS(int i, int j,int index){
		vis[i][j] = index;
		ans[index]++;
		for (int k = 0; k <4 ; k++) {
			int x = i+fun[2*k],y = j+fun[2*k+1];
			if(x>=0 && x<n && y>=0 && y<n && vis[x][y] == 0 && dp[x][y] != dp[i][j]){
				DFS(x,y,index);
			}
		}
	}
}


// BFS  超内存

public class P1141{
	private static boolean[][] dp;
	private static boolean[][] vis;
	private static int n;
	private static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int[] func;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		dp = new boolean[n][n];
		func = new int[]{-1,0,0,1,1,0,0,-1};
		for (int i = 0; i <n ; i++) {
			String str = sc.next();
			for (int j = 0; j <n ; j++) {
				dp[i][j] = str.charAt(j) == '0';
			}
		}
		for (int i = 0; i <m ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			bfs(x-1,y-1);
		}
	}
	public static void bfs(int x,int y){
		 boolean[][] vis = new boolean[n][n];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		vis[x][y] = true;
		int res = 1;
		while (!q.isEmpty()){
			Node node = q.poll();
			boolean flag = dp[node.x][node.y];
			for (int k = 0; k <4 ; k++) {
				int i = node.x + func[2*k];
				int j = node.y + func[2*k+1];
				if(i<0 || i>=n || j<0 || j>=n) continue;
				if(flag != dp[i][j] && !vis[i][j]){
					res++;
					q.add(new Node(i,j));
					vis[i][j] = true;
				}
			}
		}
		System.out.println(res);
	}
}

 **/