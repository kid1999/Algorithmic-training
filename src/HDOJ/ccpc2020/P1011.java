package HDOJ.ccpc2020;

import java.util.Scanner;

/**
 * @author kid1999
 * @date 2020/9/20 15:31
 * @desc
 **/
public class P1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            double[][] K = new double[4][4];
            double[][] A = new double[n+1][n+1];
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=n ; k++) {
                    A[j][k] = sc.nextInt();
                }
            }
            for (int j = 1; j <=3 ; j++) {
                for (int k = 1; k <=3 ; k++) {
                    K[j][k] = (double) sc.nextInt();
                }
            }
            K = Transf(K);
            while(true){
                double [][] B;
                B = func(A,K);
                if(judge(B, A)){
                    disp(B);
                    break;
                }
                A = B;
            }

        }
    }
    public static double[][] func(double[][] A,double[][] K){
        int n = A.length;
        double[][] B = new double[n][n];
        for (int x = 1; x <n ; x++) {
            for (int y = 1; y <n ; y++) {
                double sum = 0;
                int ti = Integer.min(n-x,3), tj = Math.min(n-y,3);
                for(int i = 1;i<=ti;i++){
                    for(int j =1;j<=tj;j++){
                        double a = A[x+i-1][y+j-1];
                        double k = K[i][j];
                        sum += (a*k);
                    }
                }
                B[x][y] = sum;
            }
        }
        return B;
    }

    public static void disp(double[][] arr){
        int n = arr.length, m = arr[0].length;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(j == m-1)   System.out.print((int) arr[i][j]);
                else System.out.print((int) arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean judge(double[][] A,double[][] B){
        for (int i = 1; i <A.length ; i++) {
            for (int j = 1; j <A[0].length ; j++) {
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    public static double[][] Transf(double[][] K){
        int n = 4;
        double[][] B = new double[n][n];
        double sum = 0;
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <n ; j++) {
                sum += K[i][j];
            }
        }
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <n ; j++) {
                B[i][j] = K[i][j] / sum;
            }
        }
        return B;
    }
}
