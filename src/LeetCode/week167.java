package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kid1999
 * @title: week167
 * @date 2019/12/15 10:28
 */

public class week167 {
	public static void main(String[] args) {
		int[][] arr = {{0,1,0,1},{0,1,0,0},{0,0,1,0},{1,0,0,1},{0,1,0,0}};  //{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
//		System.out.println(maxSideLength(arr,4));
		System.out.println(shortestPath(arr,18));
	}
	// 1.



	// 2
	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> res = new ArrayList<>();
		int len = String.valueOf(low).length();
		int maxLen = String.valueOf(high).length();
		for (int i = len; i <= maxLen ; i++) {
			for (int j = 1; j <= 9-i+1; j++) {
				String num = "";
				for (int k = 0; k <i ; k++) {
					num += (j+k);
				}
				if(Integer.parseInt(num) <= high && Integer.parseInt(num) >= low) res.add(Integer.parseInt(num));
			}
		}
		return res;
	}


	// 3
	public static int maxSideLength(int[][] mat, int threshold) {
		int res = 0;
		int xLen = mat.length;
		int yLen = mat[0].length;
		for (int i = 0; i <xLen; i++) {
			for (int j = 0; j <yLen; j++) {
				for (int k = 1; k <=Math.min(xLen,yLen); k++) {      // 从0开始
					int count = 0;
					if(k+i>xLen || k+j > yLen) break;
					for (int l = 0; l <k ; l++) {
						for (int m = 0; m <k ; m++) {
							count += mat[i+l][j+m];
						}
					}
					if(count > threshold) break;
					if(count <= threshold && k>res) res = k;
				}
			}
		}
		return res;
	}





	// 4
	private static int res;
	private static int[] fun;
	public static int shortestPath(int[][] grid, int k) {
		res = Integer.MAX_VALUE;
		fun = new int[]{0,1,1,0,0,-1,-1,0};
		dfs(grid,k,1,0,0,0);
		if(res == Integer.MAX_VALUE) return -1;
		else return res;
	}
	public static void dfs(int[][] grid,int k,int pre,int i,int j,int count){
		if(i==grid.length-1 && j==grid[0].length-1){
			if(count < res) res = count;
		}
		for (int l = 0; l <4 ; l++) {
			if ((pre+2)%4 == l) continue;
			int x = i+fun[2*l];
			int y = j+fun[2*l+1];
			if(x<0 || x>=grid.length || y<0|| y>= grid[0].length) return;
			if(grid[x][y] == 1 && k>0) dfs(grid,k-1,l,x,y,count+1);
			else if(grid[i+fun[2*l]][j+fun[2*l+1]] == 1 && k<=0) continue;
			else dfs(grid,k,l,x,y,count+1);
		}
	}


}
