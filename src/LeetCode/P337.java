package LeetCode;

import java.util.HashMap;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/5 10:05
 **/
public class P337 {
    public static void main(String[] args) {

    }

    // 朴素递归
//    public int rob(TreeNode root) {
//        if(root == null) return 0;
//        int sum = 0;
//        if(root.left!=null) sum+= rob(root.left.left) + rob(root.left.right);
//        if(root.right!=null) sum+= rob(root.right.left) + rob(root.right.right);
//        return Math.max(rob(root.left)+rob(root.right),root.val+sum);
//    }

    // 记忆化
//    static HashMap<TreeNode, Integer> map;
//    public int rob(TreeNode root) {
//        map = new HashMap<>();
//        return dfs(root);
//    }
//
//    public int dfs(TreeNode root) {
//        if(root == null) return 0;
//        if(map.containsKey(root)) return map.get(root);
//        int sum = 0;
//        if(root.left!=null) sum+= dfs(root.left.left) + dfs(root.left.right);
//        if(root.right!=null) sum+= dfs(root.right.left) + dfs(root.right.right);
//        int res = Math.max(dfs(root.left)+dfs(root.right),root.val+sum);
//        map.put(root,res);
//        return res;
//    }

    // 树状dp
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }
    //0 代表不偷，1 代表偷
    public int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] res = {0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = left[0] + right[0] + root.val;
        return res;
    }
}
