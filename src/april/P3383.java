package april;

import java.util.*;

public class P3383 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int num;
        Set<Integer> prims = new HashSet<>();
        prims.add(2);
        prims.add(3);
        for (int a = 2; a <n ; a++) {
            //大于等于5的质数一定和6的倍数相邻
            if(a==2||a==3) prims.add(a);
            for(int i=5;i*i<=a;i+=6)
            {
                if(a%i!=0 && a%(i+2)!=0) prims.add(a);
            }
        }

        for (int i = 0; i < m; i++) {
            num = sc.nextInt();
            if (prims.contains(num)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
