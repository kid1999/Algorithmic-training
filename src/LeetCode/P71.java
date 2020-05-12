package LeetCode;

import java.util.Stack;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/12 8:45
 **/
public class P71 {
    public static void main(String[] args) {

    }


    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] worsds = path.split("/");
        for (String s:worsds) {
            if(!s.equals("") && !s.equals(".") && !s.equals("..")) stack.push(s);
            else if(s.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
        }
        if(stack.isEmpty()) return "/";
        String res = "";
        for (String s:stack) {
            res += "/" + s;
        }
        return res;
    }
}
