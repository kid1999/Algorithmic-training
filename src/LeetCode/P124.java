package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/5 10:58
 **/
public class P124 {
    public static void main(String[] args) {

    }

    //
    static int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        dfs(root);
        return result;
    }
    public static int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));
        result = Math.max(result,root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}
