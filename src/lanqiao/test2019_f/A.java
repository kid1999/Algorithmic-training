package lanqiao.test2019_f;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-13 13:55
 * @description TODO
 **/
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 2019;
//        a*a + d = x*x ; x*x + d = y*y;
        for (int i = 2020; i < 30000; i++) {
            for (int j = i+1; j < 50000; j++) {
                if(i*i*2 - j*j == a*a){
                    System.out.println(i + j);
                }
            }
        }
    }
}
//4076361