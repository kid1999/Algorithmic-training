package LeetCode;

/**
 * @author kid1999
 * @date 2020/9/5 22:00
 * @desc
 **/
public class P1004 {
    public static void main(String[] args) {

    }

    public int longestOnes(int[] A, int K) {
        int res = 0;
        int l = 0, r = 0,count = 0;
        while(r<A.length){
            count += A[r] == 0 ? 1 : 0;
            while(count > K){
                count -= A[l++] == 0 ? 1 : 0;
            }
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
