package lanqiao.test2020;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int res = 0;
		for (int i = 1; i <= 2020; i++) {
			String s = String.valueOf(i);
			for(char c:s.toCharArray()){
				if(c == '2') res++;
			}
		}
		System.out.println();
		
		
		
		
	}
}
