package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/2/22 19:42
 **/
public class P110 {

    public static void main(String[] args) {


    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(dfs(root.left) - dfs(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;
        return Math.max(dfs(node.left),dfs(node.right))+1;
    }


}


