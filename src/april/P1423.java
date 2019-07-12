import java.util.Scanner;

public class P1423 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double aim = sc.nextDouble();
        double res = 2.0;
        double dist = 2.0;
        int i;
        for (i = 1;res<aim; i++) {
            dist *= 0.98;
            res += dist;
        }
        System.out.println(i);
    }
}
