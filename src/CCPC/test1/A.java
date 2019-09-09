package CCPC.test1;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count = 0;
            for (int j = 0; j < n; j++) {
                String name = sc.next();
                count += name.toCharArray().length;
            }
            System.out.println(count);
        }
    }
}
