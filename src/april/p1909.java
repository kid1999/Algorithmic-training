package april;

import java.util.Scanner;

public class p1909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextInt();
        double[] arr  = new double[6];
        for (int i = 0; i < 6; i++) {
            arr[i++] = sc.nextInt();
            arr[i] = sc.nextInt();
        }

        // start
        int min = 99999999;
        for (int i = 1; i < 6; i++) {
            int money = (int) (Math.ceil(n/arr[i-1]) * arr[i++]);
            if (money < min) min = money;
        }
        System.out.println(min);
    }

}
