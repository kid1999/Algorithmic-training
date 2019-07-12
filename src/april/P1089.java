import java.util.Scanner;

public class P1089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pre = 0;
        int sum = 0;
        for (int i = 1; i <= 12; i++) {
            int price = pre + 300 - sc.nextInt();
            if (price<0){
                System.out.println("-" + i);
                return;
            }
            sum += (price/100)*100;
            pre = price%100;
        }
        System.out.println((int)(pre + sum*1.2));
    }
}
