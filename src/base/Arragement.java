package base;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/6/19 11:07
 **/
public class Arragement {
    public static void main(String[] args) {
        System.out.println(Arragement(10,2));
    }

    // 排列   A(n,m) = n*(n-1)(n-2)……(n-m+1);
    public static int Arragement(int n,int m) {
        if(n<m) return 0;
        int res = 1;
        for(int i = n-m+1;i<=n;i++) {
            res *= i;
        }
        return res;
    }
}
