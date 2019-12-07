package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2019/12/7 10:12
 **/
public class P409 {
    public static void main(String[] args) {

    }
    public int longestPalindrome(String s) {
        int[] chars = new int[128];
        for (int i = 0; i <s.length() ; i++) {
            chars[s.charAt(i)]++;
        }
        int res = 0;
        for (int i = 0; i <128 ; i++) {
            if(chars[i] > 1){
                res += (chars[i] / 2) * 2;
                chars[i] = chars[i] % 2;
            }
        }
        for (int i = 0; i <128 ; i++) {
            if(chars[i] > 0){
                return res +1 ;
            }
        }
        return res;
    }
}
