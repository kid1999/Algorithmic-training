package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/19 11:12
 **/
public class T588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i <8 ; i++) {
            number.append(num&1);
            num>>=1;
        }
        System.out.println(number.reverse());
    }
}
