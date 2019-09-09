package LuoGu;

import java.util.Scanner;

public class P1200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if (getRes(a) == getRes(b)){
            System.out.println("GO");
        }else{
            System.out.println("STAY");
        }
    }


    public static int getRes(String name){
        int res = 1;
        for (int i = 0; i < name.length(); i++) {
            res *= (int)(name.charAt(i) - 'A' +1 );
        }
        return res%47;
    }
}
