package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kid1999
 * @create 2021-08-03 10:43
 * @description TODO
 **/
public class P95 {

    public static void main(String[] args) {
        generateTrees(3);
    }

    static List<TreeNode> res;
    static boolean[] vis;
    public static List<TreeNode> generateTrees(int n) {
        res = new ArrayList<>();
        vis = new boolean[n+1];
        for (int i = 1; i <=n ; i++) {
            vis[i] = true;
            TreeNode head = new TreeNode(i);
            dfs(head,head,1);
            vis[i] = false;
        }
        return res;
    }

    public static void dfs(TreeNode root,TreeNode head,int count){
        if (count == vis.length -1){
            res.add(head);
            return;
        }

        for (int i = 1; i < vis.length; i++) {
            if (!vis[i]){
                vis[i] = true;
                if (root.val > i){
                    root.left = new TreeNode(i);
                    dfs(root.left,head,count+1);
                }else{
                    root.right = new TreeNode(i);
                    dfs(root.right,head,count+1);
                }
                vis[i] = false;
            }
        }
    }
}