package LuoGu;

import java.math.BigInteger;
import java.util.Scanner;

public class P1255 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        BigInteger a = BigInteger.valueOf(1);
//        BigInteger b = BigInteger.valueOf(1);
//
//        List<BigInteger> arr = new ArrayList<>();
//        arr.add(0,BigInteger.valueOf(1));
//        arr.add(1,BigInteger.valueOf(2));
//        for (int i = 2; i < n; i++) {
//            arr.add(i,arr.get(i-1).add(arr.get(i-2)));
//        }
//        System.out.println(arr.get(n-1));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(2);
        BigInteger tmp;
        if(n<1){
            System.out.println(0);
            return;
        }
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n == 2) {
            System.out.println(2);
            return;
        }
        for (int i = 2; i < n; i++) {
            tmp = a.add(b);
            a = b;
            b = tmp;
        }
        System.out.println(b);
    }
}
