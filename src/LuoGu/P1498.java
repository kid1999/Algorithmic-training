package LuoGu;

import java.util.Scanner;

public class P1498 {
	static StringBuffer[] res;
	static StringBuffer nul = new StringBuffer(" ");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		res = new StringBuffer[2000];
		res[0] = new StringBuffer(" /\\ ");
		res[1] = new StringBuffer("/__\\");
		for (int i = 1; i < n ; i++) add(i*2);
		for (int i = 0; i < n*2 ; i++) {
			System.out.println(res[i]);
		}
	}
	public static void add(int end){
		for (int i = end; i <end*2 ; i++) {
			res[i] = new StringBuffer(res[i-end].toString() + res[i-end].toString());
		}
		for (int i = 0; i <end ; i++) {
			for (int j = 0; j <end ; j++) res[i].insert(0," ");
			for (int j = res[i].length(); j <end; j++) res[i].insert(res[i].length()," ");
		}
	}
}
