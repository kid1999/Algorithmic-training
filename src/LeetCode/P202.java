package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/30 9:13
 **/
public class P202 {
    public static void main(String[] args) {
        System.out.println(isHappy(4));
    }

    public static boolean isHappy(int n) {
        int slow = n,fast = n;
        while (true){
            slow = func(slow);
            fast = func(fast);
            fast = func(fast);
            if(slow == fast) return false;
            if(fast == 1 || slow == 1) return true;
        }
    }
    public static int func(int num){
        int res = 0;
        while (num != 0){
            res += (num%10)*(num%10);
            num /= 10;
        }
        return res;
    }
}
