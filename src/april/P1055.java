package april;

import java.util.Scanner;

public class P1055 {
    public static void main(String[] args) {
        int res = 0;
        int n;
        Scanner sc = new Scanner(System.in);
        String isbn = sc.next();
        String[] ids = isbn.split("-");
        if(ids[3].equals("X")) {
            n = 10;
        }else{
            n = Integer.parseInt(ids[3]);
        }

        String nums = ids[0] + ids[1] + ids[2];
        for (int i = 0; i < nums.length(); i++) {
            res += (i+1) * (nums.charAt(i) - '0');
        }
        if(res%11 == n){
            System.out.println("Right");
        }else{
            if(res%11 == 10){
                System.out.println(ids[0] + "-" + ids[1] + "-" + ids[2] + "-" + "X");
            }else{
                System.out.println(ids[0] + "-" + ids[1] + "-" + ids[2] + "-" + String.valueOf(res%11));
            }

        }

    }
}
