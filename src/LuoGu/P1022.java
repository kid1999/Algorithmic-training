package LuoGu;

import java.util.Scanner;

public class P1022 {
	static double sum = 0;
	static double x = 0;
	static boolean f = true;   // +
	static boolean eq = true;   // = 前后
	static String num = "";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String func = sc.next();
		char tmp = ' ';
		for (int i = 0; i <func.length() ; i++) {
			char word = func.charAt(i);
			if(word == '-'){
				func();
				f = false;
			}
			if(word == '+'){
				func();
				f = true;
			}
			if(word>='0' && word<='9') num += word;
			if(word>='a' && word<='z'){
				tmp = word;
				double count =0;
				if(num.equals("")) count = 1;
				else count = Double.valueOf(num);
				count = f ? count  : -count;
				x += eq ? count : -count;
				num = "";
			}
			if(word == '='){
				func();
				f = true;
				eq = false;
			}
		}
		func();
		System.out.printf("%c=%.3f",tmp,-sum/x);
	}

	private static void func(){
		if(!num.equals("")){
			double count = Double.valueOf(num) ;
			count = f ? count  : -count;
			sum += eq ? count : -count;
			num = "";
		}
	}
}
