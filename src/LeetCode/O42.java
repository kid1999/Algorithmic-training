package LeetCode;

/**
 * @author kid1999
 * @create 2020-11-17 20:08
 * @description TODO
 **/
public class O42 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int n:nums) {
            if(sum + n < n) sum = 0;
            sum += n;
            max = Math.max(max,sum);
        }
        return max;
    }
}