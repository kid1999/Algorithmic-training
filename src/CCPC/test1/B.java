package CCPC.test1;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                String s1 = sc.next();
                String s2 = sc.next();
                String s3 =sc.next();
                char a = s1.charAt(0);
                char b = s2.charAt(0);
                int add = a-b;
                char[] res = new char[s3.length()];
                for (int k = 0; k < s3.length(); k++) {
                    char c = (char)(s3.charAt(k) + add);
                    if(c > 'z'){
                        c = (char)('a' + ('z' - c) +1);
                    }
                    if (c < 'a'){
                        c = (char)('z' - ('a' - c) +1);
                    }
                    res[k] = c;
                }
                System.out.println(res);
            }
    }
}
