package LeetCode;

public class P106 {
  private  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public static void main(String[] args) {

  }

/*
[9,3,15,20,7]
[9,15,7,20,3]
 */

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder.length == 0) return null;
    TreeNode tree = new TreeNode(postorder[0]);
    return dfs(postorder, inorder, tree, 0, inorder.length-1, 0,inorder.length-1);
  }
  public TreeNode dfs(int[] postorder, int[] inorder,TreeNode root,int l1,int r1,int l2,int r2){
    if(l1>r1 || l1>=inorder.length) return null;
    root = new TreeNode(postorder[r1]);
    int cur = l2;
    while (postorder[r1] != inorder[cur]) cur++;
    int count = cur - l2;
    root.left = dfs(postorder, inorder, root.left, l1, l1+count-1, l2, cur-1);
    root.right = dfs(postorder, inorder, root.right, l1+count, r1-1, cur+1,r2);
    return root;
  }
}
