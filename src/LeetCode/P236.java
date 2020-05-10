package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/10 8:06
 **/
public class P236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root ==q || root==p) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        else if(left!=null) return left;
        else if(right!=null) return right;
        else return null;
    }
}
