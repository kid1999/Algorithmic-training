package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author kid1999
 * @title: P196
 * @date 2020/7/5 10:20
 */

public class P196 {
	public static void main(String[] args) {

	}

	// 1
	public boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		int dep = arr[1] - arr[0];
		for (int i = 1; i <arr.length ; i++) {
			if(arr[i] - arr[i-1] != dep) return false;
		}
		return true;
	}

	// 2
	public int getLastMoment(int n, int[] left, int[] right) {
		int res = 0;
		for (int l:left) {
			res = Math.max(res,l);
		}
		for (int r:right) {
			res = Math.max(res,n-r);
		}
		return res;
	}

	// 3
	public int numSubmat(int[][] mat) {
		int x_len = mat.length;
		int y_len = mat[0].length;
		int res = 0;
		for (int i = 0; i <x_len ; i++) {
			for (int j = 0; j <y_len ; j++) {

			}
		}
		return res;
	}
	public void dfs(int[][] mat,int i,int j,int len){

	}

	// 4
	public String minInteger(String num, int k) {
		char[] s = num.toCharArray();
		int len = s.length;
		for (int i = 0; i <len && k>0 ; i++) {
			int cur = i;
			for (int j = i+1; j <len && j-i<=k ; j++) { // 找到最小的一个合适的数
				if(s[j] <s[cur]) cur = j;
			}
			for (int j = cur; j>i && k>0 ; j--) {   // 往前交换
				k--;
				swap(s,j,j-1);
			}
		}
		return new String(s);
	}
	void swap(char[] s,int i,int j){
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}
}
