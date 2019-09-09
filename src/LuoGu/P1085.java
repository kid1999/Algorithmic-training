package LuoGu;

import java.util.Scanner;

public class P1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 7;
        int a,b,flag = 0;
        for (int i = 1; i <= 7; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if(a+b>max){
                max = a+b;
                flag = i;
            }
        }
        System.out.println(flag);
    }
}
