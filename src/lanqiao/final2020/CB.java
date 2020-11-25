package lanqiao.final2020;

/**
 * @author kid1999
 * @create 2020-11-14 17:08
 * @description TODO
 **/
public class CB {
    public static void main(String[] args) {
        System.out.println(2020 - countPrimes(2020));
    }

    public static int countPrimes(int n) {
        boolean[] nums = new boolean[n];
        //只需要遍历到n的平方根
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]){
                res++;
            }
        }
        return res;
    }
}