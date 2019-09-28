package BBOJ;

import java.util.Scanner;

public class 蜜蜂飞舞 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] sum = new double[6];
		for (int i = 0; i <n ; i++) {
			double[] tmp = new double[6];
			for (int j = 0; j <6 ; j++)
				tmp[j] = sc.nextDouble();
			double t = sc.nextDouble();
			for (int j = 0; j <6 ; j++) {
				sum[j] += tmp[j]*t;
			}
		}
		for (int i = 0; i <6 ; i++)
			sum[i] += sc.nextDouble();
		double res = Math.sqrt((sum[0]-sum[3])*(sum[0]-sum[3]) + (sum[1]-sum[4])*(sum[1]-sum[4]) + (sum[2]-sum[5])*(sum[2]-sum[5]));
		System.out.printf("%.4f",res);
	}
}
