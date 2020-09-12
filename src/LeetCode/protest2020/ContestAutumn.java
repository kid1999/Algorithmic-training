package LeetCode.protest2020;

import CCPC.test1.A;

import java.util.Arrays;

/**
 * @author kid1999
 * @date 2020/9/12 14:51
 * @title ContestAutumn
 */

public class ContestAutumn {
	public static void main(String[] args) {
		
	}

	// 1
	public int calculate(String s) {
		int x = 1, y = 0, sum = 0;
		for(char c:s.toCharArray()){
			if(c == 'A'){
				x = 2*x+y;
			}else {
				y = 2*y+x;
			}
		}
		return x+y;
	}

	// 2
	public static int breakfastNumber(int[] staple, int[] drinks, int x) {
		int res = 0;
		int mod = 1000000007;
		int len = 0;
		Arrays.sort(staple);
		Arrays.sort(drinks);
		for (int i = drinks.length-1; i >=0 ; i--) {
			int m = x - drinks[i];
			for (int j = len; j < staple.length ; j++) {
				if(staple[j] > m){
					len = j-1 ;break;
				}else if(j == staple.length-1){
					len = staple.length - 1;
				}
			}
			res = (len+1 + res) % mod;
			len = Math.max(len, 0);
		}
		return res;
	}

	// 3
	// 3
//	public static int minimumOperations(String leaves) {
//		boolean f = false;
//		if(leaves.charAt(leaves.length()-2) == 'y'){
//			leaves = leaves.substring(0,leaves.length()-2) + 'r';
//			f = true;
//		}
//		int res = 0, len = leaves.length();
//		char[] ls = leaves.toCharArray();
//		int[] rs = new int[len+1];
//		int[] ys = new int[len+1];
//		for (int i = 0; i <len ; i++) {
//			if(ls[i] == 'r'){
//				rs[i+1] = rs[i] + 1;
//				ys[i+1] = ys[i];
//			}else {
//				ys[i+1] = ys[i] + 1;
//				rs[i+1] = rs[i];
//			}
//		}
////		for (int i = 1; i <len-1 ; i++) {
////			for (int j = i+1; j <len ; j++) {
////				res = Math.min(ys[i] + (rs[j]-rs[i]) + (ys[len]-ys[j]),res);
////			}
////		}
//		if(ys[len] == 0 || rs[len] == 0) return 1;
//		int[] dp = new int[len+1];
//		for (int i = 1; i <=len ; i++) {
//			dp[i] = ys[i] - rs[i];
//		}
//		// max (dp[j] - dp[i])
//		int min = Integer.MAX_VALUE;
//		for (int i = 1; i <len ; i++) {
//			res = Math.max(dp[i] - min,res);
//			min = Math.min(min,dp[i]);
//		}
//		if(!f) return Math.max(ys[len] - res, 0);
//		else return Math.max(ys[len] - res, 0) +1;
//	}

	public int cost(char a, char b) {
		return a == b ? 0 : 1;
	}

	public int minimumOperations(String leaves) {
		int[] last = new int[4];
		int[] next = new int[4];
		int inf = (int) 1e8;
		Arrays.fill(last, inf);
		last[0] = 0;
		for (char c : leaves.toCharArray()) {
			Arrays.fill(next, inf);
			next[1] = Math.min(last[1] + cost('r', c), last[0] + cost('r', c));
			next[2] = Math.min(last[2] + cost('y', c), last[1] + cost('y', c));
			next[3] = Math.min(last[3] + cost('r', c), last[2] + cost('r', c));
			int[] tmp = last;
			last = next;
			next = tmp;
		}
		return last[3];
	}

	// 4


	// 5


	// 6
}
