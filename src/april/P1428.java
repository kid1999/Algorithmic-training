import java.util.Scanner;

public class P1428 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fishs = new int[n];
        for (int i = 0; i < n; i++) {
            fishs[i] = sc.nextInt();
        }

        System.out.print(0 + " ");
        for (int i = 1; i < n; i++) {
            int res = 0;
            for (int j = 0; j <i ; j++) {
                if(fishs[i]>fishs[j])
                    res++;
            }
            System.out.print(res + " ");
        }
    }
}
