package LeetCode;

import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/7/1 20:26
 **/
public class P32 {
    public static void main(String[] args) {

    }


    // DP
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()+1];
        int max = 0;
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '(')
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i-1] + ((i-dp[i-1] >= 2) ? dp[i - dp[i-1] - 2] : 0) +2;
            }
            System.out.println(dp[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    // 栈
//    public int longestValidParentheses(String s) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int max = 0;
//        for (int i = 0; i <s.length() ; i++) {
//            if(s.charAt(i) == ')'){
//                stack.pop();
//                if(stack.isEmpty()) stack.push(i);      // 左边界
//                else max = Math.max(max,i-stack.peek());
//            }else{
//                stack.push(i);
//            }
//        }
//        return max;
//    }
}
