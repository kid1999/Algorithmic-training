package april;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> dist = new LinkedList<>();
        int pre = sc.nextInt();
        int now;
        for (int i = 1; i < a; i++) {
            now = sc.nextInt();
            dist.add(now-pre);
            pre = now;
        }
        while(b>0){
            int min = 99999999;
            int i,flag = 0;
            for (i = 0; i < dist.size()-1; i++) {
                if(dist.get(i)<min){
                    flag = i;
                    min = dist.get(i);
                }
            }
            if(b == 1) {
                System.out.println(min);
                return;
            }
            dist.set(flag+1,min + dist.get(flag+1));
            dist.remove(flag);
            b--;
        }
    }
}
