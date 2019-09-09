package LuoGu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n<1 || k<1){
            System.out.println("NO RESULT");
            return;
        }
        List<Integer> arr = new ArrayList<>();
        arr.add(sc.nextInt());
        int in;
        for (int i = 1; i < n; i++) {
            in = sc.nextInt();
            for (int j = arr.size()-1; j >=0; j--) {
                if (in>arr.get(j)){
                    arr.add(j+1,in);
                    break;
                }
                if(in == arr.get(j)) break;
                if (j==0) {
                    arr.add(0,in);
                    break;
                }
            }
        }
        if(k>arr.size()) System.out.println("NO RESULT");
        else System.out.println(arr.get(k-1));
    }
}
