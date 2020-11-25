package HDOJ;

/**
 * @author kid1999
 * @create 2020-11-18 20:59
 * @description TODO
 **/
public class P1012 {
    public static void main(String[] args) {
        double[] dp = new double[11];
        int[] sum = new int[11];
        sum[0] = 1;
        for (int i = 1; i <=10 ; i++) {
            sum[i] = sum[i-1]*i;
        }
        for (int i = 0; i <=9 ; i++) {
            for (int j = 0; j <=i ; j++) {
                dp[i] += 1.0/sum[j];
            }
        }
        System.out.println("n e");
        System.out.println("- -----------");
        System.out.println(0 + " " + 1);
        System.out.println(1 + " " + 2);
        System.out.println(2 + " " + 2.5);
        for (int i = 3; i <=9 ; i++) {
            System.out.printf("%d %.9f%n",i,dp[i]);
        }
    }
}