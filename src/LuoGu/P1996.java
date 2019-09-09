package LuoGu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P1996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }


        int t = 0;
        for (int i = 0; i < n; i++) {
            t = (t-1+m)%list.size();
            System.out.print(list.get(t) + " ");
            list.remove(t);
        }
    }
}
