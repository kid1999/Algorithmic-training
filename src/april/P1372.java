package april;

import java.util.Scanner;

public class P1372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n%k == 0){
            System.out.println(n/k);
        }
    }
}
