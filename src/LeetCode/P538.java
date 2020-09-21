package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author kid1999
 * @date 2020/9/21 18:09
 * @title P538
 */

public class P538 {
	public static void main(String[] args) {

	}

	static List<Integer> nodes;
	public TreeNode convertBST(TreeNode root) {
		nodes = new ArrayList<>();
		dfs(root);
		nodes.sort((a,b)->{ return b-a; });
		HashMap<Integer,Integer> map = new HashMap<>();
		int sum = 0;
		for (int n:nodes) {
			sum += n;
			map.put(n,sum);
		}
		func(root,map);
		return root;
	}

	static void func(TreeNode root,HashMap<Integer,Integer> map){
		if(root == null) return;
		root.val = map.get(root.val);
		func(root.left,map);
		func(root.right,map);
	}

	static void dfs(TreeNode root){
		if(root == null) return;
		nodes.add(root.val);
		dfs(root.left);
		dfs(root.right);
	}




	// 后向中序遍历
//	int sum=0;
//	public TreeNode convertBST(TreeNode root) {
//		if(root==null)
//			return null;
//		convertBST(root.right);
//		sum+=root.val;
//		root.val=sum;
//		convertBST(root.left);
//		return root;
//	}
}
