package LuoGu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class P1469 {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(nums.contains(num)){
                nums.remove(num);
            }else{
                nums.add(num);
            }
        }
        for (Iterator<Integer> it = nums.iterator(); it.hasNext(); ) {
            int a = it.next();
            System.out.println(a);
        }
    }
}
