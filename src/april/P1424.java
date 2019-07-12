import java.util.Scanner;

public class P1424 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long start = sc.nextLong();
        Long n = sc.nextLong();
        Long days = 0L;
        days += (n - 2*((n+start-1)/7));        // 去除双休
        if ((n+start-1)%7 >5){
            days -= (n+start-1)%7 -5;         // 除去当前周六
        }
        if(start == 7) days++;
        System.out.println(250*days);

    }
}
