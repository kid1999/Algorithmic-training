package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/21 10:43
 **/
public class T539 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        double sum = 0;
        double sum_a = 0;
        for (int i = 0; i <n1; i++) {
            String a = sc.next();
            String b = sc.next();
            if(b.equals("P") || b.equals("N")) continue;
            sum += Integer.parseInt(a)*Integer.parseInt(b);
            sum_a += Integer.parseInt(a);
        }
        double sum1 = sum/sum_a;

        int n2 = sc.nextInt();
        sum = 0;
        sum_a = 0;
        for (int i = 0; i <n2; i++) {
            String a = sc.next();
            String b = sc.next();
            if(b.equals("P") || b.equals("N")) continue;
            sum += Integer.parseInt(a)*Integer.parseInt(b);
            sum_a += Integer.parseInt(a);
        }
        double sum2 = sum/sum_a;
        double res = sum1 - sum2;
        if(res<0.01&&res>-0.01) System.out.println("0.00");
        else System.out.printf("%.2f",sum1 - sum2);
    }

}
