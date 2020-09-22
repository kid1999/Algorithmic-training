package HDOJ.ccpc2020;

import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/20 12:17
 * @desc
 **/
public class P1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int n = sc.nextInt();
            boolean f = false;
            int last = -1;
            for (int j = 0; j <n ; j++) {
                int num = sc.nextInt();
                if(last == num && !f) {
                    System.out.println("NO");
                    f = true;
                }else {
                    last = num;
                }
            }
            if(!f) System.out.println("YES");
        }
    }
}
