package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;






public class week10 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println("abcef".substring(0,2) + " " +"abcef".substring(3) );
		System.out.println(isValidPalindrome("abcdeca",2));
	}

	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
		List<Integer> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int i = 0; i <arr1.length ; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i <arr2.length ; i++) {
			if(set.contains(arr2[i])){
				set2.add(arr2[i]);
			}
		}
		for (int i = 0; i <arr3.length ; i++) {
			if(set2.contains(arr3[i])) res.add(arr3[i]);
		}
		return res;
	}



	static boolean f = false;
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		Set<Integer> set = new HashSet<>();
		boolean f = false;
		dfs(root1,set);
		dfs2(root2,target,set);
		return f;
	}

	public void dfs(TreeNode root,Set<Integer> set){
		if(root == null) return;
		set.add(root.val);
		dfs(root.left,set);
		dfs(root.right,set);
	}

	public void dfs2(TreeNode root,int aim,Set<Integer> set){
		if(root == null) return;
		if(set.contains(aim - root.val)) {
			f = true;
			return;
		}
		dfs2(root.left,aim,set);
		dfs2(root.right,aim,set);
	}


// 3

	public List<Integer> countSteppingNumbers(int low, int high) {
		List<Integer> res = new ArrayList<>();
		return null;
	}
	public void func(boolean isUp,int last,int index,String res){
		if(last > 9 || last < 0) return;
		if(isUp){
			for (int i = last; i <=9 ; i++) {
				func(isUp,i+1,index ,res+ String.valueOf(i));
			}

		}

	}



	// 4


	static int[][] dp;
	public static boolean isValidPalindrome(String s, int k) {
		return function(s,k);
	}

	public static boolean function(String s,int k){
		if( k == 0){
			if(ishui(s)) return true;
			else return false;
		}
		int l = 0, r = s.length()-1;
		while (l<r){
			if(s.charAt(l) != s.charAt(r)) {
			//				( ]
				String res1 = s.substring(0,l) + s.substring(l+1);
				String res2 = s.substring(0,r) + s.substring(r+1);
				System.out.println(res1 + " " + res2);
				function(res1,k-1 );
				function(res2,k-1 );
			}else{
				l++;
				r--;
			}
		}
		return true;
	}

	public static boolean ishui(String s){
		int l = 0, r = s.length()-1;
		while (l<r){
			if(s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}
