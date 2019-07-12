import java.util.Scanner;

public class P1567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pre = sc.nextInt();
        int max = 0,count = 1;
        int now;
        for (int i = 1; i <n ; i++) {
            now = sc.nextInt();
            if(now>pre) count++;
            else count = 1;
            if(count > max){
                max = count;
            }
            pre = now;
        }
        System.out.println(max);
    }
}
