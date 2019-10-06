package LeetCode;

import java.util.*;

public class week157 {
	public static void main(String[] args) {
		int[][] arr = {{0,6,0},{5,8,7},{0,9,0}};
//		System.out.println(longestSubsequence(arr,0));
		System.out.println(getMaximumGold(arr));
	}

	// 1
	public int minCostToMoveChips(int[] chips) {
		int j = 0, o = 0;
		for (int i = 0; i <chips.length ; i++) {
			if(chips[i]%2==0) o++;
			else j++;
		}
		return Math.min(j,o);
	}

	// 2
	public static int longestSubsequence(int[] arr, int difference) {
		Map<Integer,Integer> map = new HashMap<>();
		int[] dp = new int[arr.length];
		for (int i = 0; i <arr.length ; i++) {
			if(map.containsKey(arr[i] - difference)) dp[i] = dp[map.get(arr[i] - difference)]+1;
			else dp[i] = 1;
			map.put(arr[i], i);
		}
		int max = 0;
		for (int i = 0; i <dp.length ; i++) {
			if(dp[i] > max) max = dp[i];
		}
		return max;
	}

	// 3
	static int max = 0;
	public static int getMaximumGold(int[][] grid) {
		for (int i = 0; i <grid.length ; i++) {
			for (int j = 0; j <grid[0].length ; j++) {
				if(grid[i][j] != 0) dfs(grid,i,j,0);
			}
		}
		int tmp = max;
		max = 0;
		return tmp;
	}
	public static void dfs(int[][] grid,int i,int j,int count){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return;
		count += grid[i][j];
		int tmp = grid[i][j];
		grid[i][j] = 0;
		if(count > max) max = count;
		dfs(grid,i-1,j,count);
		dfs(grid,i+1,j,count);
		dfs(grid,i,j-1,count);
		dfs(grid,i,j+1,count);
		grid[i][j] = tmp;
	}


}
