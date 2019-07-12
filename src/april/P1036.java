package april;

import java.util.Scanner;

public class P1036 {
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Start
        int res = selectAndSum(k,0,0,nums.length-1);
        System.out.println(res);


    }

    public static int selectAndSum(int k,int sum,int l,int r){
        if (k==0) return isPirm(sum);
        int res = 0;
        for (int i = l; i < r; i++) {
            res += selectAndSum(k-1,sum+nums[i],l+1,r);
        }
        return res;
    }



    public static int isPirm(int sum){
        int j;
        if (sum <=2) return 0;
        for (j = 2; j*j < sum; j++) {
            if(sum % j == 0){
                return 0;
            }
        }
        return 1;
    }
}
