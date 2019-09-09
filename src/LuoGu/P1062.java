package LuoGu;

import java.util.Scanner;

public class P1062 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		char[] binary = Integer.toBinaryString(n).toCharArray();
		long res = 0;
		for (int i = 0; i <binary.length; i++) {
			res = k*res+(binary[i]-'0');
		}
		System.out.println(res);
	}
}
