package LuoGu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1980 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char m = sc.next().charAt(0);
        Map<Character,Integer> nums = new HashMap<>();
        for (int i = 0; i <=9; i++) {
            nums.put((char)('0'+i),0);
        }
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            for (char c:num.toCharArray()) {
                nums.put(c,nums.get(c)+1);
            }
        }
        System.out.println(nums.get(m));
    }
}
