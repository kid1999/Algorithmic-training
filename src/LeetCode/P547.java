package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @auther: kid1999
 * @date: 2019/11/11 16:01
 * @desc: P547
 **/
public class P547 {
	public static void main(String[] args) {

	}
	// dfs 染色
	public int findCircleNum(int[][] M) {
		int res = 0;
		boolean[] vis = new boolean[M.length];
		for (int i = 0; i <M.length ; i++) {
			if(!vis[i]){
				dfs(M,vis,i);
				res++;
			}
		}
		return res;
	}
	public static void dfs(int[][] M,boolean[] vis,int i){
		for (int j = 0; j <M.length ; j++) {
			if(M[i][j] == 1 && !vis[j]){
				dfs(M,vis,j);
				vis[j] = true;
			}
		}
	}
}
