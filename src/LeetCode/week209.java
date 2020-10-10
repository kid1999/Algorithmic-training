package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kid1999
 * @create 2020-10-04 10:24
 * @description TODO
 **/
public class week209 {
    public static void main(String[] args) {
//        int[] arr = {3,6,7,7,0};
//        System.out.println(specialArray(arr));

        System.out.println(minimumOneBitOperations(6));
    }

    // 1
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = len-1; i >=0 ; i--) {
            int dep = len-i;
            if(i-1>=0 && dep > nums[i-1] && dep <= nums[i])
                return dep;
        }
        if(nums.length < nums[0]) return nums.length;
        return -1;
    }

    // 2
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int last1 = Integer.MAX_VALUE;
            int last2 = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                if(index % 2 == 0 && (val <= last2 || val % 2 == 0)) return false;
                if(index % 2 == 1 && (val >= last1 || val % 2 == 1)) return false;
                last1 = last2 = val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            index++;
        }
        return true;
    }

    // 3


    // 4

    public static int minimumOneBitOperations(int n) {
        int ans = 0;
        while(n > 0) {
            ans ^= n;
            n /= 2;
        }
        return ans;
    }
}