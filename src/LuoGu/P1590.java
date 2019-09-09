package LuoGu;

import java.util.Scanner;

public class P1590 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <n ; i++) {
            Long num = sc.nextLong();
            System.out.println(count_num(num));
        }
    }
    public static long count_num(Long num){
        Long sum = 0L;
        double weishu = 0;
        while(num>0){
           Long now = num%10;
           if(now > 7) now--;
           sum += now*(int)Math.pow(9.0,weishu);
           num /=10;
           weishu++;
        }
        return sum;
    }
}
