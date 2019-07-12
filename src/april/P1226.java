package april;

import java.math.BigInteger;
import java.util.Scanner;

public class P1226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long b = sc.nextLong();
        Long p = sc.nextLong();
        Long k = sc.nextLong();
        BigInteger b1 = BigInteger.valueOf(b);
        BigInteger p1 = BigInteger.valueOf(p);
        BigInteger k1 = BigInteger.valueOf(k);
        BigInteger res = b1.modPow(p1,k1);
        System.out.println(b+"^"+p+" mod "+k+"="+res);
    }
}
