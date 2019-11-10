package LeetCode;

import CCPC.test1.A;

import java.util.ArrayList;
import java.util.List;

public class week162 {
	public static void main(String[] args) {
//		reconstructMatrix(5,5,new int[]{2,1,2,0,1,0,1,2,0,1});
		closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}});
	}

	public static int oddCells(int n, int m, int[][] indices) {
		int[][] arr = new int[n][m];
		for (int i = 0; i <indices.length ; i++) {
			int a = indices[i][0];    //行
			int b = indices[i][1];    //列
			for (int j = 0; j <m ; j++) {
				arr[a][j] += 1;
			}
			for (int j = 0; j <n ; j++) {
				arr[j][b] += 1;
			}
		}
		int res = 0;
		for (int i = 0; i <n ; i++) {
			for (int j = 0; j <m ; j++) {
				if((arr[i][j] % 2) == 1) {
					res++;
				}
			}
		}
		return res;
	}

	// 2
	public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> zero = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		for (int i = 0; i <colsum.length ; i++) {
			if(colsum[i] == 0){
				zero.add(0);
				one.add(0);
			}else if(colsum[i] == 2){
				zero.add(1);
				one.add(1);
				upper--;
				lower--;
			}else{
				if(lower<=upper){
					zero.add(1);
					one.add(0);
					upper--;
				}else{
					zero.add(0);
					one.add(1);
					lower--;
				}
			}
		}
		if(upper == 0 && lower == 0){
			res.add(zero);
			res.add(one);
		}
		return res;
	}


	//3
	private static int[] func;
	private static boolean f = false;
	public static int closedIsland(int[][] grid) {
		int res = 0;
		func = new int[]{-1,0,0,1,1,0,0,-1};
		for (int i = 0; i <grid.length ; i++) {
			for (int j = 0; j <grid[0].length ; j++) {
				if(grid[i][j] == 0){
					dfs(grid,i,j);
					if(!f) res++;
					f = false;
				}
			}
		}
		return res;
	}
	public static void dfs(int[][] grid,int i,int j){
		if(i<0||i>=grid.length||j<0||j>=grid[0].length){
			f = true;     //边界
			return;
		}
		if(grid[i][j] != 0) return;   // 遇到过
		grid[i][j] = -1;
		for (int k = 0; k <4 ; k++) {
			dfs(grid,i+func[2*k],j+func[2*k+1]);
		}
	}


	// 4

}


