package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/2/22 20:23
 **/
public class P257 {

    public static void main(String[] args) {

    }

    // dfs 方法一
//    static List<String> res;
//    public List<String> binaryTreePaths(TreeNode root) {
//        res = new ArrayList<>();
//        if(root == null) return res;
//        dfs(root,String.valueOf(root.val));
//        return res;
//    }
//    private void dfs(TreeNode root,String string){
//        if(root == null) return;
//        if(root!= null && root.left == null && root.right == null){
//            res.add(string);
//            return;
//        }
//        if(root.left!=null) dfs(root.left,string + "->" + root.left.val);
//        if(root.right!=null) dfs(root.right,string + "->" + root.right.val);
//    }


    // dfs 方法二
    static List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,"");
        return res;
    }
    private void dfs(TreeNode root,String string){
        if(root == null) return;
        string += root.val;
        if(root.left == null && root.right == null){
            res.add(string);
        }else{
            dfs(root.left,string + "->");
            dfs(root.right,string + "->");
        }
    }
}
