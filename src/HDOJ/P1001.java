package HDOJ;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-18 19:46
 * @description TODO
 **/
public class P1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int sum = 0;
            if(n%2==0) sum = n/2*(n+1);
            else sum = (n+1)/2*n;
            System.out.println(sum);
            System.out.println();
        }
    }
}