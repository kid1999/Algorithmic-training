package lanqiao.test2020;

import java.util.Scanner;

public class F {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 200;
		int max = -1;
		double sum = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			sum += num;
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		System.out.println(max);
		System.out.println(min);
		System.out.printf("%.2f",sum/n);
	}
}
