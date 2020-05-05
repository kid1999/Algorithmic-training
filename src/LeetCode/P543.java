package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/5 9:32
 **/
public class P543 {
    public static void main(String[] args) {

    }

    static int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root){
        if(root == null) return 0;
        int left = root.left != null ? dfs(root.left)+1 : 0;
        int right = root.right != null ? dfs(root.right)+1 : 0;
        res = Math.max(res,left+right);
        return Math.max(left,right);
    }
}
