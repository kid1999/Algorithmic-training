package lanqiao;

import java.util.Scanner;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/3/19 11:24
 **/
public class T594 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        func(n,"");
    }
    public static void func(int n,String res){
        if(n == 0){
            System.out.println(res);
            return;
        }
        func(n/10,(n%10 + "-") + res );
    }
}
