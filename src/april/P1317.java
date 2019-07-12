import java.util.Scanner;

public class P1317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        Boolean flag = false;
        int pre = nums[0];
        int res = 0;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i]>pre && flag){
                res++;
                flag = false;
            }
            if (nums[i]<=pre){
                flag = true;
            }
            pre = nums[i];
        }
        System.out.println(res);
    }
}
