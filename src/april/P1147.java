import java.util.Scanner;

public class P1147 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1.枚举法
        int l = 1;
        int res = 0;
        for (int r = 1; r < n; r++) {
            res+=r;
            while(res>n){
                res-=l++;   //总值回退 左边界加
            }
            if (res == n){
                System.out.println(l + " " + r);
            }
        }
    }
}
