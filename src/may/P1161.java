package may;

import java.util.*;

public class P1161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            double a = sc.nextDouble();
            int t = sc.nextInt();
            for (int j = 1; j <=t ; j++) {
                int num = (int)(a*j);
                if (nums.contains(num)) nums.remove(num);
                else nums.add(num);
            }
        }
        int k = 1;
        while (true){
            if(nums.contains(k))
                break;
            k++;
        }
        System.out.println(k);
    }
}
