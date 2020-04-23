package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/4/23 10:07
 **/
public class P152 {
    public static void main(String[] args) {
        int[] arr = {-1,-2,-9,-6};
        System.out.println(maxProduct(arr));
    }

    // 两种状态表示:
    // f[i]以i结尾的最大连续乘积 , g[i]以i结尾的最小连续乘积
    // f[i] = max(f[i-1]*n, g[i-1]*n, n)
    // g[i] = min(f[i-1]*n, g[i-1]*n, n)
    public static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int[] f = new int[nums.length+1];
        int[] g = new int[nums.length+1];
        f[0] = 1;g[0] = 1;
        for (int i = 1; i <=nums.length ; i++) {
            int n = nums[i-1];
            int max = Math.max(f[i-1]*n,g[i-1]*n);
            int min = Math.min(f[i-1]*n,g[i-1]*n);
            f[i] = Math.max(max,n);
            g[i] = Math.min(min,n);
            if(f[i] > res) res = f[i];
        }
        return res;
    }
}
