package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther: kid1999
 * @desc:
 * @date: 2020/8/26 16:49
 **/
public class P113 {
    public static void main(String[] args) {

    }

    static List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        dfs(root,0,target,new LinkedList<>());
        return res;
    }

    public static void dfs(TreeNode root,int sum,int target,List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == target) res.add(new LinkedList<>(list));
        }
        dfs(root.left,sum,target,list);
        dfs(root.right,sum,target,list);
        list.remove(list.size()-1);
    }
}
