package lanqiao.test2020;

import java.util.Scanner;

public class I {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length();
		int res = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j <= len; j++) {
				String tmp = s.substring(i,j);
				res += func(tmp);
			}
		}
		System.out.println(res);
	}
	static int func(String s){
		int[] w = new int[26];
		for(char c:s.toCharArray()){
			w[c-'a']++;
		}
		int res = 0;
		for(int n:w){
			if(n > 0) res++;
		}
		return res;
	}
	
}
