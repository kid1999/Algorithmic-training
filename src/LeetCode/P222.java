package LeetCode;

/**
 * @author kid1999
 * @create 2020-11-24 11:54
 * @description TODO
 **/
public class P222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 1;
        return countNodes(root.left) + countNodes(root.right);
    }
}