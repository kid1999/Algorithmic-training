package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/8 10:06
 **/
public class P199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 1; i <=size ; i++) {
                TreeNode node = queue.poll();
                if(i == size){
                    res.add(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
