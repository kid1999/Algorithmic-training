package may;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1320 {
    public static void main(String[] args) {
        List<String> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len  = str.length();
        nums.add(str);
        for (int i = 1; i <len ; i++) {
            nums.add(sc.next());
        }
        char flag = '0';
        int count = 0;
        System.out.print(len + " ");
        for (String string:nums) {
            for (char c:string.toCharArray()) {
                if(c == flag) count++;
                else {
                    System.out.print(count + " ");
                    count = 1;
                    if(flag == '0') flag = '1';
                    else flag = '0';
                }
            }
        }
        System.out.print(count);
    }
}
