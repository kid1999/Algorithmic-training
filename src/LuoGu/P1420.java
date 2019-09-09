package LuoGu;

import java.util.Scanner;

public class P1420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pre = sc.nextInt();
        int count = 1,max = 0;
        for (int i = 1; i < n; i++) {
            int now = sc.nextInt();
            if (count>max) max = count;
            if (now == pre+1) count++;
            else count = 1;
            pre = now;
        }
        System.out.println(max);
    }
}
