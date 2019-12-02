package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther: kid1999
 * @date: 2019/12/2 8:45
 * @desc: P513
 **/
public class P513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == 0 && node!=null) res = node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return res;
    }
}
