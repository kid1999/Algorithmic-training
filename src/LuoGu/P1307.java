package LuoGu;

import java.util.Scanner;

public class P1307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 0){
			System.out.println(0);
			return;
		}
		if(n < 0) System.out.print("-");
		StringBuffer num = new StringBuffer(String.valueOf(Math.abs(n)));
		num = num.reverse();
		boolean f = true;
		for (int i = 0; i <num.length() ; i++) {
			if(f && num.charAt(i) == '0') continue;
			if(!f && num.charAt(i) == '0') System.out.print(0);
			if(num.charAt(i) != '0'){
				f = false;
				System.out.print(num.charAt(i));
			}

		}
	}
}
