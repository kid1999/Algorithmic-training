package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/19 10:45
 **/
public class T602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if(s1.equals(s2)) System.out.println(0);
        else if(s2.compareTo(s1) > 0) System.out.println(1);
        else System.out.println(-1);
    }
}
