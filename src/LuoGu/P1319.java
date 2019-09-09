package LuoGu;

import java.util.Scanner;

public class P1319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1;
        boolean flag = false;    // 偶数
        while(sc.hasNext()){
            int a = sc.nextInt();
            if (flag) flag=false;
            else flag = true;
            res = print(a,flag,res,n);
            if(res >= n*n) return;
        }
    }
    public static int print(int a,boolean flag,int res,int n){
        if(flag){
            for (int i = 0; i <a ; i++) {
                System.out.print("0");
                if(res++ % n == 0) System.out.println();
            }
        }else{
            for (int i = 0; i <a ; i++) {
                System.out.print("1");
                if(res++ % n == 0) System.out.println();
            }
        }
        return res;
    }
}
