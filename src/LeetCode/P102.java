package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/13 8:42
 **/
public class P102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                if(node == null) continue;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                line.add(node.val);
            }
            res.add(line);
        }
        return res;
    }
}
