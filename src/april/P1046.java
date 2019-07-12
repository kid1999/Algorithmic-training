import java.util.Scanner;

public class P1046 {
    public static void main(String[] args) {
        int[] apples = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            apples[i] = sc.nextInt();
        }
        int height = sc.nextInt();
        int res = 0;
        for (int apple:apples) {
            if (apple<=(height+30))
                res++;
        }
        System.out.println(res);
    }
}
