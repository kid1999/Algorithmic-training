package LeetCode;

/**
 * @author kid1999
 * @date 2020/9/8 18:09
 * @title P897
 */

public class P897 {
	public static void main(String[] args) {

	}

	static TreeNode head;
	public TreeNode increasingBST(TreeNode root) {
		head = new TreeNode(-1);
		TreeNode start = head;
		dfs(root);
		return start.right;
	}
	public static void dfs(TreeNode root){
		if(root == null) return;
		dfs(root.left);
		head.right = new TreeNode(root.val);
		head = head.right;
		dfs(root.right);
	}
}
