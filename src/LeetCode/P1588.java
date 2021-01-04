package LeetCode;

/**
 * @author kid1999
 * @create 2021-01-03 10:17
 * @description TODO
 **/
public class P1588 {
    public static void main(String[] args) {

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 1; i <arr.length ; i+=2) {
            for (int j = 0; j <arr.length-i ; j++) {
                for (int k = 0; k <i ; k++) {
                    res += arr[j+k];
                }
            }
        }
        return res;
    }
}