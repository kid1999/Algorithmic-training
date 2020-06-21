package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/18 11:38
 **/
public class P1028 {
    public static void main(String[] args) {

    }

    public TreeNode recoverFromPreorder(String S) {
        Queue<int[]> queue = new LinkedList<>();
        int len = S.length();
        int r = 0;
        while (r<len){
            int[] pair = new int[2];
            int l = r;
            char c = S.charAt(r);
            while (c == '-') c = S.charAt(++r);
            pair[0] = r-l;
            l = r;
            while (Character.isDigit(c)){
                r++;
                if(r==len) break;
                c = S.charAt(r);
            }
            pair[1] = Integer.parseInt(S.substring(l,r));
            queue.offer(pair);
        }
        return decode(queue,0);
    }
    public TreeNode decode(Queue<int[]> queue,int dep){
        if(queue.isEmpty()) return null;
        int[] pair = queue.peek();
        int dep0 = pair[0];
        int num = pair[1];
        if(dep != dep0) return null;
        TreeNode node = new TreeNode(num);
        queue.poll();
        node.left = decode(queue,dep+1);
        node.right = decode(queue,dep+1);
        return node;
    }
}
