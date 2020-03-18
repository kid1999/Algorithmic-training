package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/18 20:15
 **/
public class T566 {
    private static int a;
    private static int b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        swap(a,b);
        System.out.println(a + " " + b);
    }

    public static void swap(int x,int y){
        a = y;
        b = x;
    }
}
