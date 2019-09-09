package LuoGu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            int a = sc.nextInt();
            if(a == 0) break;
            nums.add(a);
        }

        for(int i = nums.size()-1; i >=0 ; i--) {
            System.out.print(nums.get(i) + " ");
        }
    }
}
