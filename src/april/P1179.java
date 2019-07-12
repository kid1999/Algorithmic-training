package april;

import java.util.Scanner;

public class P1179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String num;
        int res = 0;
        for (int i = a; i <=b ; i++) {
            num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                if(num.charAt(j) == '2')  res++;
            }
        }
        System.out.println(res);
    }
}
