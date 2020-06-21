package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/23 9:56
 **/
public class T397 {

    final static long mod = 987654321;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long sum = 0;
        long pre = Combination(n,m);
        for (int i = 1; i <=n ; i++) {
            sum += pre * Combination(n,i) * Math.pow(i,3) % mod;
        }
        System.out.println(sum % mod);
    }


    private static long Combination(int n, int m) {
        if(m>n) return 0;
        else if(m==0||m==n) return 1;
        else return Combination(n-1, m)+Combination(n-1, m-1) % mod;
    }

}
