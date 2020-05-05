package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/5 9:09
 **/
public class P474 {
    public static void main(String[] args) {

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m+1][n+1];
        for (String s:strs) {
            int one = 0;
            int zero = 0;
            for (int i = 0; i <s.length() ; i++) {
                if(s.charAt(i) == '0') zero++;
                else one++;
            }
            for (int i = m; i >=zero; i--) {
                for (int j = n; j >= one ; j--) {
                    f[i][j] = Math.max(f[i][j],f[i-zero][j-one]+1);
                }
            }
        }
        return f[m][n];
    }

}
