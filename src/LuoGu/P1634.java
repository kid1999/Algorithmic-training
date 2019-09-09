package LuoGu;

import java.math.BigInteger;
import java.util.Scanner;

public class P1634 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger x = sc.nextBigInteger();
        int n = sc.nextInt();
        BigInteger sum = BigInteger.ONE;
        for (int i = 0;i<n; i++) {
            sum = sum.multiply(x).add(sum);
        }
        System.out.println(sum);
    }
}
