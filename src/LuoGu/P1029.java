package LuoGu;

import java.util.Scanner;

public class P1029 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int res = 0;
		for (int i = 0; i <=y ; i++) {
			for (int j = 0; j <=y ; j++) {
				if(i*j==x*y && gcd(i,j) == x) res++;
			}
		}
		System.out.println(res);
	}
	public static int gcd(int x,int y){
		if(x>y){
			int tmp = x;
			x = y;
			y = tmp;
		}
		return x == 0 ? y : gcd(y%x,x);
	}
}
