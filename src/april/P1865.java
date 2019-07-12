import java.util.Scanner;

public class P1865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        for (int[] num:nums) {
            if(num[1]>m || num[1]<1){
                System.out.println("Crossing the line");
                continue;
            }
            if(num[0]<2) num[0] = 2;
            int res = 0;
            for (int j = num[0]; j <= num[1]; j++) {
                if(j==2){
                    res++;
                    continue;
                }
                if(j==3){
                    res++;
                    continue;
                }
                boolean flag = false;
                for (int k = 2; k*k <= j; k++) {
                    if (j%k == 0){
                        flag = true;
                        break;
                    }
                }
                if (flag) res++;
            }
            System.out.println(res);
        }
    }
}
