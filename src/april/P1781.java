package april;

import java.math.BigInteger;
import java.util.Scanner;

public class P1781 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger max = BigInteger.ZERO;
        BigInteger now;
        int flag = 1;
        for (int i = 1; i <= n; i++) {
            now = sc.nextBigInteger();
            if(now.compareTo(max) == 1){
                max = now;
                flag = i;
            }
        }
        System.out.println(flag);
        System.out.println(max);

    }
}
