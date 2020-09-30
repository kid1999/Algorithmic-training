package LeetCode;

/**
 * @author kid1999
 * @create 2020-09-30 8:43
 * @description TODO
 **/
public class P701 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val < root.val) root.left = insertIntoBST(root.left,val);
        else root.right = insertIntoBST(root.right,val);
        return root;
    }
}