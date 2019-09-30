package LuoGu;

import java.util.Scanner;

public class P1010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(helper(n));
	}
	public static String helper(int num){
		if(num == 1) return "2(0)";
		if(num == 2) return "2";
		if(num == 3) return "2+2(0)";
		int n = (int) (Math.log(num)/Math.log(2));  // log 2 num
		int t = (int) Math.pow(2,n);    // 2** n
		if(num == t) return "2(" + helper(n) + ")";   // 被2整除
		else return "2(" + helper(n) + ")" + "+" +  helper(num-t);
	}
}
