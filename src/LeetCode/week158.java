package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class week158 {
	public static void main(String[] args) {
		int[][] arr = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
		int[] aim = {0,0};
		queensAttacktheKing(arr,aim);
	}
 // 4
	public int balancedStringSplit(String s) {
		int num = 0;
		char word = 'L';
		int res = 0;
		for (char c:s.toCharArray()){
			if(c == word) num++;
			else num--;
			if(num == 0) {
				res++;
				word = c;
			}
		}
		return res;
	}
	// 2
	static int[] arr;
	static int[] aim;
	static int[][] map;
	static List<List<Integer>> res;
	public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		res = new ArrayList<>();
		map = new int[9][9];
		arr = new int[]{0,1,0,-1,1,0,-1,0,-1,-1,1,1,-1,1,1,-1};
		aim = king;
		for (int i = 0; i <queens.length ; i++) {
			map[queens[i][0]][queens[i][1]] = 1;
		}
		for (int i = 0; i <queens.length ; i++) {
			for (int j = 0; j <8 ; j++) {
				boolean f = dfs(queens[i][0]+arr[2*j],queens[i][1]+arr[2*j],j);
				if(f) {
					List<Integer> ll = new ArrayList<>();
					ll.add(queens[i][0]);
					ll.add(queens[i][1]);
					res.add(ll);
				}
			}
		}
		return res;

	}
	public static boolean dfs(int i,int j,int index){
		if(i<0 ||i >=8 || j<0||j>=8) return false;
		if(map[i][j] == 1) return false;
		if(i == aim[0] && j== aim[1]){
			return true;
		}
		boolean f = dfs(i+arr[index*2],j+arr[index*2+1] , index);
		return f;
	}

	// 4
	public int maxEqualFreq(int[] nums) {
		int[] arr = new int[nums.length];
		for (int i = 0; i <nums.length ; i++) {
			arr[nums[i]]++;
		}
		return 0;
	}


}
