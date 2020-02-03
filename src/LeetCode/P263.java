package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/2/3 12:45
 **/
public class P263 {
    public static void main(String[] args) {

    }

    public boolean isUgly(int num) {
        if(num<1) return false;
        int[] arr = {2,3,5};
        while (num != 1){
            boolean f = false;
            for (int n:arr) {
                if(num%n == 0){
                    num = num/n;
                    f = true;
                    break;
                }
            }
            if (!f) return false;
        }
        return true;
    }
}
