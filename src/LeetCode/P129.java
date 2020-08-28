package LeetCode;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/26 16:26
 **/
public class P129 {
    public static void main(String[] args) {

    }

    static int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root,"");
        return res;
    }

    public static void dfs(TreeNode root,String num){
        if(root == null) return;
        String nnum = num + root.val;
        if(root.left == null && root.right == null)
            res += Integer.parseInt(nnum);
        dfs(root.left,nnum);
        dfs(root.right,nnum);
    }


}
