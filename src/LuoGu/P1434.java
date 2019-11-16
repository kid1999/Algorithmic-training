package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @title: P1434
 * @date 2019/11/16 10:30
 */

public class P1434 {
	static int[][] nums,vis;
	static int[] fun;
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nums = new int[n][m];
		vis = new int[n][m];
		fun = new int[]{-1,0,0,1,1,0,0,-1};
		for (int i = 0; i <n ; i++) {
			for (int j = 0; j <m ; j++) {
				nums[i][j] = sc.nextInt();
			}
		}
		int res = 0;
		for (int i = 0; i <n ; i++) {
			for (int j = 0; j <m ; j++) {
				res = Math.max(res,dfs(i,j));
			}
		}
		System.out.println(res);
	}
	public static int dfs(int i,int j){
		int max = 0;    // 往前还能走几步
		for (int k = 0; k <4 ; k++) {
			int x = i + fun[2 * k];
			int y = j + fun[2 * k + 1];
			if(x>=0&&x<n&&y>=0&&y<m &&nums[i][j] > nums[x][y]) {
				if(vis[x][y]==0){       //还没走过
					int length = dfs(x,y);
					max = Math.max(max,length);
				}else{
					max = Math.max(max,vis[x][y]);
				}
			}
		}
		vis[i][j] = max+1;     // 每次走过保存往后走的最大值
		return vis[i][j];     // 回传还能走几步
	}
}
