package HDOJ;

import java.util.Scanner;

/**
 * @author kid1999
 * @create 2020-11-18 20:42
 * @description TODO
 **/
public class P1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if(n == 0) return;
            int res = 0,last = 0;
            for (int i = 0; i <n ; i++) {
                int floor = sc.nextInt();
                if(floor > last) res += (floor-last)*6+5;
                else res += (last-floor)*4+5;
                last = floor;
            }
            System.out.println(res);
        }
    }
}