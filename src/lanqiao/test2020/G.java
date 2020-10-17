package lanqiao.test2020;

import java.util.Scanner;

public class G {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] ws = new int[128];
		for(char c:s.toCharArray()){
			ws[c]++;
		}
		int max = 0;
		char w = 'a';
		for (int i = 0; i < ws.length; i++) {
			if(ws[i] > max){
				max = ws[i];
				w = (char) i;
			}
		}
		System.out.println(w);
		System.out.println(max);
	}
}
