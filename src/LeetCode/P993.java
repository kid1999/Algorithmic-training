package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/2/22 19:13
 **/
public class P993 {
    public static void main(String[] args) {

    }


    // bfs
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int number = node.val;
                if((number==x && set.contains(y)) || (number==y&&set.contains(x))) return true;
                set.add(number);
                if(node.left!=null && node.right!=null){
                    if(node.left.val == y && node.right.val ==x) return false;
                    if(node.left.val == x && node.right.val ==y) return false;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }
        return false;
    }

}
