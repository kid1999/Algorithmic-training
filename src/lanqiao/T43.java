package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/18 12:22
 **/
public class T43 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int k = sc.nextInt();
//        long res = 0;
//        long fn = f(n)% 999101;
//        long fm = f(m)% 999101;
//        long last = fn/(fm*f(n-m)) % 999101;
//        for (int i = 1; i <=n ; i++) {
//            res += fn/(f(i)*f(n-i)) * last * Math.pow(i,k) % 999101;
//        }
//        System.out.println(res);
//    }
//
//    public static long f(int n){
//        long mod = 999101;
//        long res = 1;
//        for (int j = 1; j <=n ; j++) {
//            res = (res * j);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long mod = 999101;
        long res = 0;
        long last = Lucas(n,m,mod);
        for (int i = 1; i <=n ; i++) {
            res += Lucas(n,i,mod) * last * Math.pow(i,k) % mod;
        }
        System.out.println(res%mod);
    }

//    public static long quickpow(long a,long b,long mod)
//    {
//        long ans = 1;
//        while(b!=0)
//        {
//            if((b&1)==1)
//                ans=ans*a%mod;
//            a=a*a%mod;
//            b>>=1;
//        }
//        return ans;
//    }
//
//
//    // 组合数 公式
//    public static long C(long n,long m,long p)
//    {
//        if(m>n) return 0;
//        long x=1,y=1;
//        while(m!=0)
//        {
//            x=(x*n)%p;
//            y=(y*m)%p;
//            n--; m--;
//        }
//        return x * quickpow(y,p-2,p) % p;
//    }
//
//    //Lucas ，快速求解组合数 C(n,m) 从 n 里面 选 m 的可能性,对 P 进行取模
//    public static long Lucas(long n, long m, long p)
//    {
//        if(m==0) return 1;
//        return C(n%p,m%p,p)*Lucas(n/p,m/p,p)%p;
//    }

    static long quick_mod(long m, long k, long p){
        long res = 1, t = m;
        while(k > 0){
            if( (k&1) == 1){
                res = res * t % p;
            }
            t = t * t % p;  //t^1 t^2 t^4 ...
            k = k>>1;
        }
        return res % p;
    }

    // 组合数 公式
    static long C(long n, long m,long p)
    {
        if(m > n) return 0;
        long ans = 1;
        for(int i=1; i<=m; i++)
        {
            long a = (n + i - m) % p;
            long b = i % p;
            ans = ans * (a * quick_mod(b, p-2,p) % p) % p;
        }
        return ans;
    }
    //Lucas ，快速求解组合数 C(n,m) 从 n 里面 选 m 的可能性,对 P 进行取模
    static long Lucas(long n, long m,long p)
    {
        if(m == 0) return 1;
        return C(n % p, m % p,p) * Lucas(n / p, m / p,p) % p;
    }

}
