package LuoGu;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-10-11 14:09
 * @description TODO
 **/
public class P3817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        long res = 0, p = 0;
        for (int i = 0; i <n ; i++) {
            long t = sc.nextLong();
            if(p+t > x){
                res += t+p-x;   // 多余的糖果
                t = x-p;
            }
            p = t;
        }
        System.out.println(res);
    }
}