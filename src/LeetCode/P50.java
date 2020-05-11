package LeetCode;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/11 8:20
 **/
public class P50 {
    public static void main(String[] args) {

    }

    // 快速幂
    // x^k = x1 * x2 * x4 * ...
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n;i!=0;i/=2){
            if((int)(i&1)==1){      // x 为齐数 * x
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1.0 / res : res;
    }

    // 递归写法
    double myPow(double x, long n) {
        if (n == 0) return 1;
        else if (n > 0 && n % 2 == 0) return myPow(x * x, n / 2);
        else if (n > 0) return myPow(x, n - 1) * x;
        else return 1 / myPow(x, -n);
    }
}
