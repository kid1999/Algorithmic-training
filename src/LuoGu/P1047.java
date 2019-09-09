package LuoGu;

import java.util.Scanner;

public class P1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] flag = new boolean[n+1];
        int a,b;
        for (int i = 0; i <m ; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = a; j <=b; j++) {
                flag[j] = true;
            }
        }
        int res = 0;
        for (boolean flg:flag) {
            if(flg==false) res++;
        }
        System.out.println(res);
    }
}
