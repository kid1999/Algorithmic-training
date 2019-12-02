package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @auther: kid1999
 * @date: 2019/12/2 8:34
 * @desc: P637
 **/
public class P637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                if(node != null){
                    sum += node.val;
                }else continue;
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
            res.add(sum / size);
        }
        return res;
    }
}
