package LeetCode;

/**
 * @author kid1999
 * @date 2020/9/8 18:23
 * @title P979
 */

public class P979 {
	public static void main(String[] args) {

	}

	static int res = 0;
	public int distributeCoins(TreeNode root) {
		dfs(root);
		return res;
	}
	public static int dfs(TreeNode root){
		if(root == null) return 0;
		if(root.left != null) root.val += dfs(root.left);
		if(root.right != null) root.val += dfs(root.right);
		res += Math.abs(root.val -1);
		return root.val -1;
	}


}
