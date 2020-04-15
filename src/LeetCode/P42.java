package LeetCode;

import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/15 10:58
 **/
public class P42 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int res = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <height.length ; i++) {
            if (height[i] >= max) {
                while (!stack.isEmpty()){
                    int temp = stack.pop();
                    if(temp == max) break;
                    res += (max - temp);
                }
                max = height[i];
            }
            stack.push(height[i]);
        }
        max = 0;
        while (!stack.isEmpty()){
            int temp = stack.pop();
            if (temp > max) max = temp;
            else if(temp < max) res += (max - temp);
        }
        return res;
    }
}
