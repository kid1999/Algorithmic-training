package HDOJ.ccpc2020;

import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/20 12:44
 * @desc
 **/
public class P1007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println("Case #" + (i+1) + ": " + Lborder(s));
        }
    }
    public static int Lborder(String s){
        int[] map = new int[256];
        int max = 0;
        for (char c:s.toCharArray()) {
            map[c]++;
            if(map[c] > max) max = map[c];
        }
        return max;
    }
}
