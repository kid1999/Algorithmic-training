package LeetCode;

public class P105 {
   private  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public static void main(String[] args) {

  }

  // 前序遍历 preorder = [3,9,20,15,7]
  //中序遍历 inorder = [9,3,15,20,7]

  public TreeNode buildTree(int[] preorder, int[] inorder) {
     TreeNode tree = new TreeNode(preorder[0]);
    return dfs(preorder, inorder, tree, 0, preorder.length, 0,inorder.length);
  }
  public TreeNode dfs(int[] preorder, int[] inorder,TreeNode root,int l1,int r1,int l2,int r2){
     if(l2>r2) return null;
     root = new TreeNode(preorder[l1]);
     int cur = l2;
     while (preorder[l1] != inorder[cur]) cur++;
     int count = cur - l2;
     dfs(preorder, inorder, root.left, l1, r1, l2, r2+count-1);
     dfs(preorder, inorder, root.left, l1, r1, l2, r2+count-1);
     return root;
  }
}
