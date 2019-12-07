package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/7 10:21
 **/
public class P503 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <2*len ; i++) {
            int num = nums[i%len];
            while (!stack.isEmpty() && num > nums[stack.peek()]){       // 维护一个单调递减的栈
                res[stack.pop()] = num;
            }
            if(i<len) stack.push(i);
        }
        return res;
    }
}
