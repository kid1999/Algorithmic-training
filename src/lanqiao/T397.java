package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/23 9:56
 **/
public class T397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 987654321;
        long sum = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = 1,b = 1;
        for (int i = n; i >n-m ; i--) { // 第一项
            a = a * i % num;
        }
        for (int i = m; i >0 ; i--) { // 第一项
            b = b * i % num;
        }
        for (int k = 0; k <=n ; k++) {
            long res = a/b;
            if(k != 0 && k != n){
                for (int i = n; i >n-k ; i--) {
                    res = res * i % num;
                }
                for (int i = k; i >0 ; i--) {
                    res /= i;
                }
            }
            res = res * k % num;
            res = res * k % num;
            res = res * k % num;
            sum = (sum + res) % num;
        }
        System.out.println(sum);
    }
}
