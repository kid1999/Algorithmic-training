package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/23 9:15
 **/
public class T529 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] res = new double[n];
        for (int i = 0; i <n ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            res[i] = 0.7*a + 0.2*b + 0.1*c + d;
        }
        for (int i = 0; i <n ; i++) {
            if(res[i]>100) System.out.println(100.0);
            else System.out.printf("%.1f",res[i]);
            System.out.println();
        }
    }
}
