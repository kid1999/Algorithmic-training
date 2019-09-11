package LuoGu;

import java.util.Scanner;

public class P1426 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double s = sc.nextDouble();
		double x = sc.nextDouble();
		double len = 7;
		double sum = 0;
		boolean flag = false;
		while(sum <= s+x){
			if(flag) {
				System.out.println('y');
				return;
			}
			if(sum >= s-x) flag = true;
			sum += len;
			len *= 0.98;
		}
		System.out.println('n');
	}
}
